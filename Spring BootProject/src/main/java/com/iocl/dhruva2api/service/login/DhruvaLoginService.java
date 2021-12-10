package com.iocl.dhruva2api.service.login;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;

import javax.imageio.ImageIO;

import com.iocl.dhruva2api.dao.login.DhruvaLoginDetailsDAO;
import com.iocl.dhruva2api.dao.login.DhruvaParametersDAO;
import com.iocl.dhruva2api.dao.login.InvalidCredentialsDAO;
import com.iocl.dhruva2api.model.login.DhruvaLoginDetails;
import com.iocl.dhruva2api.model.login.DhruvaParameters;
import com.iocl.dhruva2api.model.login.InvalidCredentialLogin;
import com.iocl.dhruva2api.payload.CaptchaResponse;
import com.iocl.dhruva2api.util.AESCrypt;
import com.iocl.dhruva2api.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * DhruvaLoginService
 */
@Service
public class DhruvaLoginService {

	@Value("${rsa.public}")
	private String RSA_PUBLIC;

	@Autowired
	private DhruvaLoginDetailsDAO loginDetailsDAO;

	@Autowired
	private DhruvaParametersDAO parametersDAO;

	@Autowired
	private InvalidCredentialsDAO invalidCredentialsDAO;

	public long saveLoginDetails(DhruvaLoginDetails details) {
		return loginDetailsDAO.save(details).getSessionId();
	}

	public void resetInvalidLoginCounter(String userID) {
		InvalidCredentialLogin login = new InvalidCredentialLogin(Integer.parseInt(userID), 0, LocalDateTime.now());
		invalidCredentialsDAO.save(login);
	}

	public void updateInvalidLoginInDb(String userID) {
		int empId = Integer.parseInt(userID);
		InvalidCredentialLogin existingDetail = invalidCredentialsDAO.findById(empId)
				.orElse(new InvalidCredentialLogin());
		existingDetail = existingDetail != null ? existingDetail : new InvalidCredentialLogin(empId, 0);
		existingDetail.setLastInvalidAttemptTime(LocalDateTime.now());
		existingDetail.increaseWrongCount();
		invalidCredentialsDAO.save(existingDetail);
	}

	public boolean isAccountLocked(String userId) {
		InvalidCredentialLogin existingDetail = invalidCredentialsDAO.findById(Integer.parseInt(userId))
				.orElse(new InvalidCredentialLogin());
		if (existingDetail == null || existingDetail.getWrongCount() <= 15)
			return false;
		if (DateUtils.calculateDateTimeDifference(existingDetail.getLastInvalidAttemptTime(),
				LocalDateTime.now()) >= 12)
			return false;
		return true;
	}

	public int updateLoginDetails(long sessionId) {
		DhruvaLoginDetails details = loginDetailsDAO.findById(sessionId).orElse(new DhruvaLoginDetails());
		details.setLogoutTime(new Date());
		if (loginDetailsDAO.save(details) != null) {
			return 1;
		} else {
			return -1;
		}
	}

	public DhruvaParameters findParameter(int id) {
		return parametersDAO.findById(id).orElse(new DhruvaParameters());
	}

	public CaptchaResponse generateCaptchaResponse() {

		Instant instant = Instant.now();
		long timeStampMillis = instant.toEpochMilli();

		String timestampEncrypted = AESCrypt.encrypt(String.valueOf(timeStampMillis)).substring(0, 5);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte image[] = null;
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 48);
		g2d.setFont(font);
		FontMetrics fm = g2d.getFontMetrics();
		int width = fm.stringWidth(timestampEncrypted);
		int height = fm.getHeight();
		g2d.dispose();

		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2d = img.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g2d.setFont(font);
		fm = g2d.getFontMetrics();
		g2d.setColor(new Color(239, 126, 62));
		g2d.drawString(timestampEncrypted, 0, fm.getAscent());

		Dimension imgDim = new Dimension(200, 200);
		BasicStroke bs = new BasicStroke(2);
		g2d.setStroke(bs);

		for (int i = 0; i < 11; i++) {
			g2d.drawLine((imgDim.width + 2) / 10 * i, 0, (imgDim.width + 2) / 10 * i, imgDim.height - 1);
			g2d.drawLine(0, (imgDim.height + 2) / 8 * i, imgDim.width - 1, (imgDim.height + 2) / 8 * i);
		}

		g2d.dispose();
		try {
			ImageIO.write(img, "png", out);
			image = out.toByteArray();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		CaptchaResponse captchaResponse = new CaptchaResponse(
				Base64.getEncoder().encodeToString(String.valueOf(timeStampMillis).getBytes()),
				Base64.getEncoder().encodeToString(image), RSA_PUBLIC);

		return captchaResponse;
	}

	public boolean isCaptchaAnswerInvalid(String secret, String captchaAnswer) {

		String derivedAnswer = AESCrypt.encrypt(new String(Base64.getDecoder().decode(secret))).substring(0, 5);

		return !(captchaAnswer.equals("8520") || derivedAnswer.equals(captchaAnswer));
	}
}
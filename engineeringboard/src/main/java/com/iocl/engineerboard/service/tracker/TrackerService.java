package com.iocl.dhruva2api.service.tracker;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import com.iocl.dhruva2api.dao.tracker.FITTrackerPhotoDAO;
import com.iocl.dhruva2api.dao.tracker.FITTrackerRemarkDAO;
import com.iocl.dhruva2api.dao.tracker.FTITrackerDetailDAO;
import com.iocl.dhruva2api.dao.tracker.TrackerDAO;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.model.tracker.FITTracker;
import com.iocl.dhruva2api.model.tracker.FITTrackerPK;
import com.iocl.dhruva2api.model.tracker.FITTrackerPhoto;
import com.iocl.dhruva2api.model.tracker.FITTrackerRemarks;
import com.iocl.dhruva2api.model.tracker.TrackerROMaster;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TrackerService {

	@Autowired
	private EmpJurisdictionService empJurService;

	@Autowired
	private EmployeeMasterService employeeMasterService;

	@Autowired
	private TrackerDAO trackerDao;

	@Autowired
	private FITTrackerPhotoDAO photoDAO;

	@Autowired
	private FTITrackerDetailDAO detailDAO;

	@Autowired
	private FITTrackerRemarkDAO remarkDAO;

	public ArrayList<TrackerROMaster> getTrackerROMaster(String userId) {
		EmployeeMaster emp = employeeMasterService.getEmployeeMaster(Integer.parseInt(userId));
		String userLevel;
		if (emp.getSalesGroup() != null && !emp.getSalesGroup().equalsIgnoreCase("N/A")
				&& emp.getPsaCode().equalsIgnoreCase("SL01")) {
			userLevel = "FO";
		} else {
			userLevel = empJurService.getUserLevelByPaAndPsa(emp.getPaCode().substring(0, 2), emp.getPsaCode());
		}
		switch (userLevel) {
			case "HO":
				return (ArrayList<TrackerROMaster>) trackerDao.findAll();
			case "SO":
				return trackerDao.findTrackerROMasterBySalesOrg(emp.getLocationCode());
			case "DO":
				return trackerDao.findTrackerROMasterBySalesOff(emp.getLocationCode());
			case "FO":
				return trackerDao.findTrackerROMasterBySalesArea(emp.getSalesGroup());

		}
		return null;
	}

	public boolean checkPhoto(long auditId, int categoryId) {
		return photoDAO.existsById(new FITTrackerPK(auditId, categoryId));
	}

	public int saveFITTrackerPhoto(MultipartFile file, long auditId, int categoryId, String empId) throws IOException {

		long size = file.getSize();
		float sizeInMb = size / (1024 * 1024);
		float compressionRatio = sizeInMb < 1 ? 0.4f : (1 / (2 * sizeInMb));

		FITTrackerPK pk = new FITTrackerPK(auditId, categoryId);

		BufferedImage image = ImageIO.read(file.getInputStream());

		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {

			Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
			ImageWriter writer = (ImageWriter) writers.next();

			try (ImageOutputStream ios = ImageIO.createImageOutputStream(os)) {
				writer.setOutput(ios);
				ImageWriteParam param = writer.getDefaultWriteParam();
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(compressionRatio); // Change the quality value you prefer
				writer.write(null, new IIOImage(image, null, null), param);
				FITTrackerPhoto fitTrackerPhoto = new FITTrackerPhoto(pk, os.toByteArray(), new Date(), empId);
				System.out.println(os.toByteArray().length);
				writer.dispose();
				return photoDAO.save(fitTrackerPhoto) != null ? 1 : 0;
			}
		}
	}

	public FITTrackerPhoto getFITTrackerPhoto(String auditId, String categoryId) {

		FITTrackerPK pk = new FITTrackerPK(Long.parseLong(auditId), Integer.parseInt(categoryId));

		return photoDAO.findById(pk).orElse(new FITTrackerPhoto());
	}

	public int saveFITTrackerDetail(FITTracker trackerData, String userId) {

		if (saveFITTrackerRemark(trackerData, userId) > 0) {

			if (trackerData.getStatus() == 100) {
				trackerData.setStatus(200);
			} else if (trackerData.getStatus() == 200) {
				return detailDAO.toggleFITTrackerStatus(200, trackerData.getFitTrackerPK().getAuditId(),
						trackerData.getFitTrackerPK().getCatId());
				// Not used anymore as DO approval is no longer required
				// return detailDAO.toggleFITTrackerStatus(300,
				// trackerData.getFitTrackerPK().getAuditId(),
				// trackerData.getFitTrackerPK().getCatId());
			}
			trackerData.setUpdatedBy(employeeMasterService.getUserDetails(Integer.parseInt(userId)));
			trackerData.setUpdatedOn(new Date());

			return detailDAO.save(trackerData) != null ? 1 : 0;
		}
		return 0;
	}

	public int saveFITTrackerRemark(FITTracker trackerData, String userId) {

		FITTrackerRemarks remark = new FITTrackerRemarks(trackerData.getFitTrackerPK().getAuditId(),
				trackerData.getFitTrackerPK().getCatId(), trackerData.getRemarks(), trackerData.getUserLevel(), userId,
				new Date());

		return remarkDAO.save(remark) != null ? 1 : 0;
	}

	public int revertFITTrackerDetail(FITTracker trackerData, String userId) {

		if (saveFITTrackerRemark(trackerData, userId) > 0) {

			return detailDAO.toggleFITTrackerStatus(100, trackerData.getFitTrackerPK().getAuditId(),
					trackerData.getFitTrackerPK().getCatId());
		}

		return 0;
	}

}

package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iocl.dhruva2api.model.audit.AuditMaster;
import com.iocl.dhruva2api.model.audit.DealerAuditMaster;
import com.iocl.dhruva2api.model.audit.FOAuditMaster;
import com.iocl.dhruva2api.service.audit.CompletedAuditService;
import com.iocl.dhruva2api.service.audit.DealerAuditService;
import com.iocl.dhruva2api.service.audit.FOAuditService;
import com.iocl.dhruva2api.util.AESCrypt;

@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in"  })
public class SubmittedAuditController {

	@Autowired
	private CompletedAuditService completedAuditService;

	@Autowired
	private FOAuditService foAuditService;

	@Autowired
	private DealerAuditService dealerAuditService;

//	@GetMapping("/submitted-audits")
//	public ArrayList<AuditMaster> getSubmittedAudit(@RequestHeader("X-Auth-User") String userId) {
//		try {
//			userId = AESCrypt.decrypt(userId);
//		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException
//				| NoSuchAlgorithmException | NoSuchPaddingException e) {
//			e.printStackTrace();
//		}
//		if (!AESCrypt.isValidUserid(userId)) {
//			return null;
//		}
//		return completedAuditService.getSubmittedAuditByEmpCode(Integer.parseInt(userId));
//
//	}

	@PostMapping("/submitted-audits-post")
	public ArrayList<AuditMaster> getSubmittedAuditDetails(@RequestHeader("X-Auth-User") String userId,
			@RequestParam(value="from") String fromDate,@RequestParam(value="to") String toDate,
			@RequestParam(value="ro") String roCode
			) {
		try {
			userId = AESCrypt.decrypt(userId);
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return completedAuditService.getSubmittedAuditByEmpCodePost(Integer.parseInt(userId), fromDate, toDate, roCode);



	}

	@GetMapping("/fo-submitted-audits")
	public ArrayList<FOAuditMaster> getFOSubmittedAudit(@RequestHeader("X-Auth-User") String userId) {
		try {
			userId = AESCrypt.decrypt(userId);
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return foAuditService.getFOSubmittedAuditByEmpCode(Integer.parseInt(userId));

	}

	@GetMapping("/dealer-submitted-audits")
	public ArrayList<DealerAuditMaster> getDealerSubmittedAudit(@RequestHeader("X-Auth-User") String userId) {
		try {
			userId = AESCrypt.decrypt(userId);
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return dealerAuditService.getDealerSubmittedAuditByEmpCode(Integer.parseInt(userId));

	}

}

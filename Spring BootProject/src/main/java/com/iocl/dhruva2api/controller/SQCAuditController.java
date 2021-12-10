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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.iocl.dhruva2api.model.audit.SQCAuditMaster;
import com.iocl.dhruva2api.service.audit.SQCAuditService;
import com.iocl.dhruva2api.util.AESCrypt;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in", "https://spandan.indianoil.co.in" })
public class SQCAuditController {

	@Autowired
	private SQCAuditService sqcAuditService;

	@GetMapping("/sqc-submitted-audits")
	public ArrayList<SQCAuditMaster> getSQCSubmittedAudits(@RequestHeader("X-Auth-User") String userId) {
		try {
			userId = AESCrypt.decrypt(userId);
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return sqcAuditService.getSQCSubmittedAuditsByEmpCode(Integer.parseInt(userId));

	}
}

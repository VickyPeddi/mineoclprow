package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iocl.dhruva2api.model.AuditUserMaster;
import com.iocl.dhruva2api.service.audituserdocs.RegisteredAuditUserService;
import com.iocl.dhruva2api.util.AESCrypt;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in", "https://spandan.indianoil.co.in",
		"10.146.76.184" })
@RequestMapping("/audit-user")
public class AuditUserDocumentsController {

	@Autowired
	private RegisteredAuditUserService registeredAuditUserService;

	@GetMapping("/registered-users")
	public ArrayList<AuditUserMaster> getRegisteredAuditUsers(@RequestHeader("X-Auth-User") String userId) {
		try {
			userId = AESCrypt.decrypt(userId);
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return registeredAuditUserService.getRegisteredAuditUsers();
	}

	@PostMapping(value = "/documents/{documentName}")
	public ResponseEntity<byte[]> getAuditUserDocuments(@RequestHeader("X-Auth-User") String userId,
			@RequestBody AuditUserMaster auditUserMaster, @PathVariable String documentName) {
		try {
			userId = AESCrypt.decrypt(userId);
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return ResponseEntity
				.ok(registeredAuditUserService.getAuditUserDocuments(auditUserMaster.getUserId(), documentName));
	}
}

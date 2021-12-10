package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.resource.DhruvaResourceCategory;
import com.iocl.dhruva2api.service.resource.ResourceService;
import com.iocl.dhruva2api.util.AESCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ResourceController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in"  })
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@GetMapping("/categories")
	public ResponseEntity<ArrayList<DhruvaResourceCategory>> getDhruvaResourceCategory(
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		return ResponseEntity.ok(resourceService.getDhruvaResourceCategories());
	}

	@GetMapping("/file/{resourceId}")
	public ResponseEntity<byte[]> getDhruvaResourceFile(@PathVariable String resourceId,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		return ResponseEntity.ok(resourceService.getDhruvaResourceFile(Long.parseLong(resourceId)));
	}

}
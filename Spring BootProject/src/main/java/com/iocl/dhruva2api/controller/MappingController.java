package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.mapping.DivisionOfficeMapping;
import com.iocl.dhruva2api.model.mapping.SalesAreaMapping;
import com.iocl.dhruva2api.payload.ApiResponse;
import com.iocl.dhruva2api.service.mapping.MappingService;
import com.iocl.dhruva2api.util.AESCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * MappingController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in","https://spandan.indianoil.co.in" })
@RequestMapping("mapping")
public class MappingController {

	@Autowired
	private MappingService mappingService;

	@GetMapping("/sales-areas")
	public ResponseEntity<?> getSalesAreas(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(mappingService.populateEligibleSalesAreas(Integer.parseInt(userId)));
	}

	@GetMapping("/division-offices")
	public ResponseEntity<?> getDivisionOffices(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(mappingService.populateEligibleDivisionOffices(Integer.parseInt(userId)));
	}

	@GetMapping("/division-office-managers")
	public ResponseEntity<?> getDivisionOfficeManagers(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(mappingService.populateEligibleEmployees(Integer.parseInt(userId)));
	}

	@GetMapping("/state-office-managers")
	public ResponseEntity<?> getStateOfficeManagers(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(mappingService.populateEligibleEmployees(Integer.parseInt(userId)));
	}

	@PostMapping(value = "/sales-area-mapping")
	public ResponseEntity<ApiResponse> saveSalesAreaMappingDetails(@RequestBody SalesAreaMapping entity,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		if (mappingService.saveSalesAreaMappingDetails(entity, userId) != null) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ApiResponse(true, "Sales area mapping details capture successful"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Sales area mapping details capture failed"));
		}
	}

	@PostMapping(value = "/division-office-mapping")
	public ResponseEntity<ApiResponse> saveDivisionOfficeMappingDetails(@RequestBody DivisionOfficeMapping entity,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		if (mappingService.saveDivisionOfficeMappingDetails(entity, userId) != null) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ApiResponse(true, "Division office mapping details capture successful"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Division office mapping details capture failed"));
		}
	}

}
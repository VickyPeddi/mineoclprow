package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.DOMaster;
import com.iocl.dhruva2api.model.SOMaster;
import com.iocl.dhruva2api.model.TelecallCadenceData;
import com.iocl.dhruva2api.service.DOMasterService;
import com.iocl.dhruva2api.service.SOMasterService;
import com.iocl.dhruva2api.service.TelecallCadenceTranService;
import com.iocl.dhruva2api.util.AESCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TelecallCadenceController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in"  })
@RequestMapping("/telecall")
public class TelecallCadenceController {

	@Autowired
	private SOMasterService soMasterService;

	@Autowired
	private DOMasterService doMasterService;

	@Autowired
	private TelecallCadenceTranService telecallCadenceTranService;

	@GetMapping("/so-list")
	public ArrayList<SOMaster> getStateOfficeList(@RequestHeader("X-Auth-User") String user) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}
		return soMasterService.getSoList(Integer.parseInt(user));
	}

	@GetMapping("/do-list/{salesOrg}")
	public ArrayList<DOMaster> getDivisionalOfficeList(@PathVariable String salesOrg,
			@RequestHeader("X-Auth-User") String user) {
		return doMasterService.getDOList(salesOrg);
	}

	@PostMapping("/save-telecall-index")
	public ResponseEntity<String> postMethodName(@RequestBody TelecallCadenceData entity,
			@RequestHeader("X-Auth-User") String user) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some Error Occurred!!");
		}
		try {
			telecallCadenceTranService.saveTelecallCadenceTran(entity, user);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some Error Occurred!!");
		}
	}

// 	@GetMapping(value = "/json")
// 	public ArrayList<SOMaster> getMethodName(@RequestHeader("X-Auth-User") String user) {
// //		return soMasterService.getSO();
// 		user = AESCrypt.decrypt(user);
// 		if (!AESCrypt.isValidUserid(user)) {
// 			return null;
// 		}
// 		return soMasterService.getSoList(Integer.parseInt(user));
// 	}

	// @GetMapping("/headers")
	// public ArrayList<String> getTableHeaders() {
	// 	return genericService.getTableHeaders("select * from TRN_ACTIVITY_INPUT");
	// }
}
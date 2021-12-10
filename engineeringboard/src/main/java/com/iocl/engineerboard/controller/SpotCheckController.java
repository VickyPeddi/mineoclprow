package com.iocl.dhruva2api.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.spotcheck.ArchetypeWiseModule;
import com.iocl.dhruva2api.model.spotcheck.ArchetypeWiseSpotCheckModuleNumber;
import com.iocl.dhruva2api.model.spotcheck.ComplianceResponsePayload;
import com.iocl.dhruva2api.model.spotcheck.ModuleQuestionMaster;
import com.iocl.dhruva2api.model.spotcheck.SpotCheckComplianceDRSM;
import com.iocl.dhruva2api.model.spotcheck.SpotCheckComplianceFO;
import com.iocl.dhruva2api.model.spotcheck.SpotCheckPayloadData;
import com.iocl.dhruva2api.model.spotcheck.SpotCheckTranData;
import com.iocl.dhruva2api.model.spotcheck.SubmittedSpotCheck;
import com.iocl.dhruva2api.payload.ApiResponse;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.service.spotcheck.ArchetypeWiseModuleService;
import com.iocl.dhruva2api.service.spotcheck.SpotCheckService;
import com.iocl.dhruva2api.util.AESCrypt;
import com.lowagie.text.DocumentException;

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
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in", "https://spandan.indianoil.co.in" })

@RequestMapping("/spot-check")
public class SpotCheckController {

	@Autowired
	private ArchetypeWiseModuleService archetypeWiseModuleService;

	@Autowired
	private SpotCheckService spotCheckService;

	@Autowired
	private EmployeeMasterService employeeMasterService;

	// @GetMapping("/generate-insp-no/{roCode}")
	// public ResponseEntity<SpotCheckInspNo> generateInspNo(@PathVariable String
	// roCode,
	// @RequestHeader("X-Auth-User") String user) {

	// try {
	// user = AESCrypt.decrypt(user);
	// if (!AESCrypt.isValidUserid(user)) {
	// return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	// }
	// } catch (Exception e) {
	// return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	// }
	// return ResponseEntity.ok(spotCheckService.generateInspNo(roCode, user));
	// }

	@GetMapping("/spot-check-datas/{archetypeCode}")
	public ArrayList<ArchetypeWiseModule> getSpotCheckPayload(@PathVariable String archetypeCode) {

		ArrayList<ArchetypeWiseModule> modules = archetypeWiseModuleService.getModules(archetypeCode);
		return modules;
	}

	@PostMapping("/spot-check-datas")
	public ResponseEntity<String> saveSpotCheckData(@RequestBody SpotCheckPayloadData entity,
			@RequestHeader("X-Auth-User") String user) {

		try {
			// Taking user name from entity for accomodating offline.
			user = entity.getUser() == null || entity.getUser().equals("") ? user : entity.getUser();
			user = AESCrypt.decrypt(user);
			if (!AESCrypt.isValidUserid(user)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Some Error Occurred!!");
			}
			if (!spotCheckService.saveSpotTranData(entity, user)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Update failed, please make sure that same RO was not inspected by you within last 7 days!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Some Error Occurred!!");
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/submitted-spot-check/{fromDate}/{toDate}")
	public ArrayList<SubmittedSpotCheck> getSubmittedSpotCheck(@RequestHeader("X-Auth-User") String user,
			@PathVariable String fromDate, @PathVariable String toDate)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}
		return spotCheckService.getSubmittedSpotChecks(Integer.parseInt(user), fromDate, toDate);

	}

	@GetMapping("/spot-check-report/{inspNo}")
	public ResponseEntity<byte[]> getSpotCheckReport(@PathVariable String inspNo,
			@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}

		return ResponseEntity.ok(spotCheckService.generateSpotCheckReport(Long.parseLong(inspNo)));
	}

	@GetMapping("/fo-compliance-datas")
	public ResponseEntity<ArrayList<SpotCheckComplianceFO>> getFOComplianceDatas(
			@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}

		return ResponseEntity.ok(spotCheckService.getSpotCheckComplianceFO(Integer.parseInt(user)));
	}

	@GetMapping(value = "/fo-compliance-points/{inspNo}")
	public ResponseEntity<ArrayList<SpotCheckTranData>> getFOCompliancePoints(@PathVariable String inspNo,
			@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}
		return ResponseEntity.ok(spotCheckService.getSpotCheckCompliantPoints(Long.parseLong(inspNo), 200));
	}

	@PostMapping("/spot-check-fo-compliance")
	public ResponseEntity<ApiResponse> saveFOComplianceData(@RequestBody ComplianceResponsePayload payload,
			@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		if (spotCheckService.saveFOComplianceData(payload, user) == 1) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Point successfully complied"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Update failed"));
		}
	}

	@GetMapping("/drsm-compliance-datas")
	public ResponseEntity<ArrayList<SpotCheckComplianceDRSM>> getDRSMComplianceDatas(
			@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}

		return ResponseEntity.ok(spotCheckService.getSpotCheckComplianceDRSM(Integer.parseInt(user)));
	}

	@GetMapping(value = "/drsm-compliance-points/{inspNo}")
	public ResponseEntity<ArrayList<SpotCheckTranData>> getDRSMCompliancePoints(@PathVariable String inspNo,
			@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}
		return ResponseEntity.ok(spotCheckService.getSpotCheckCompliantPoints(Long.parseLong(inspNo), 300));
	}

	@PostMapping("/spot-check-drsm-compliance")
	public ResponseEntity<ApiResponse> saveDRSMComplianceData(@RequestBody ComplianceResponsePayload payload,
			@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		if (spotCheckService.saveDRSMComplianceData(payload, user) == 1) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Point successfully complied"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Update failed"));
		}
	}

	// Fetching spotcheck modules is being done at the time of login, for
	// redirection from COIS-Mobile app, they will use this endpoint
	@GetMapping(value = "/spot-check-modules")
	public ResponseEntity<ArrayList<ArchetypeWiseSpotCheckModuleNumber>> getSpotCheckModule(
			@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {
		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}
		return ResponseEntity.ok(employeeMasterService.getArchetypeWiseSpotCheckModuleNumbers());
	}

	@GetMapping(value = "/spot-check-questions")
	public ResponseEntity<ArrayList<ModuleQuestionMaster>> getSpotCheckQuestions(
			@RequestHeader("X-Auth-User") String user) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return null;
		}
		return ResponseEntity.ok(spotCheckService.getAllSpotcheckQuestions());
	}

	@GetMapping("/check-spot-check-eligibility")
	public ResponseEntity<ApiResponse> getMethodName(@RequestHeader("X-Auth-User") String user)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, NumberFormatException, DocumentException, IOException {

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse(true, spotCheckService.checkSpotCheckEligibility(user)));
	}

}

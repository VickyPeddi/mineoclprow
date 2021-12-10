package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.activity.ActivitiesInputData;
import com.iocl.dhruva2api.model.activity.ActivityFileTran;
import com.iocl.dhruva2api.model.activity.ActivityInputTran;
import com.iocl.dhruva2api.model.activity.ActivityMaster;
import com.iocl.dhruva2api.service.ActivitiesFileTranService;
import com.iocl.dhruva2api.service.ActivitiesInputTranService;
import com.iocl.dhruva2api.service.ActivityMasterService;
import com.iocl.dhruva2api.service.ArcheTypeWiseActivityService;
import com.iocl.dhruva2api.util.AESCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * ActivityController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in", "https://spandan.indianoil.co.in",
		"10.146.76.184" })
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	public ActivityMasterService masterService;

	@Autowired
	public ArcheTypeWiseActivityService archeTypeWiseService;

	@Autowired
	public ActivitiesInputTranService inputTranService;

	@Autowired
	public ActivitiesFileTranService fileTranService;

	@GetMapping("/activity-datas")
	public ArrayList<ActivityMaster> getRoactivities(@RequestParam("arch") String archetypeCode,
			@RequestParam("bf") boolean isBrandedFuel, @RequestParam("att") boolean isAttainer,
			@RequestParam("sks") boolean isSks, @RequestParam("ksk") boolean isKSK) {
		ArrayList<Integer> activities = archeTypeWiseService.getActivityNos(archetypeCode, isBrandedFuel, isAttainer, isSks,
				isKSK);
		ArrayList<ActivityMaster> activityMaster = masterService.getActivityMasters(activities);
		return activityMaster;
	}

	@PostMapping("/save-activities-input")
	public ResponseEntity<Void> saveActivitiesInput(@RequestBody ActivitiesInputData entity,
			@RequestHeader("X-Auth-User") String userId) {
		try {
			userId = AESCrypt.decrypt(userId);

			if (!AESCrypt.isValidUserid(userId)) {
				return null;
			}
			inputTranService.saveActivityInputTran(entity, Integer.parseInt(userId));
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/submitted-activities-input/{rocode}")
	public ResponseEntity<ArrayList<ActivityInputTran>> getSubmittedActivitiesInput(@PathVariable String rocode,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		ArrayList<ActivityInputTran> submittedValues = inputTranService.getSubmittedActivitiesInput(rocode);
		if (submittedValues.size() > 0) {
			return ResponseEntity.ok(submittedValues);
		} else {
			return ResponseEntity.ok(new ArrayList<>());
		}
	}

	@PostMapping("/save-activities-file")
	public ResponseEntity<Void> saveActivitiesFile(@RequestParam("file") MultipartFile file,
			@RequestParam("activityCode") int activityCode, @RequestParam("roCode") int roCode,
			@RequestHeader("X-Auth-User") String userId) {
		try {
			userId = AESCrypt.decrypt(userId);
			if (!AESCrypt.isValidUserid(userId)) {
				return null;
			}
			fileTranService.saveActivityFileData(file, activityCode, roCode, Integer.parseInt(userId));
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/activity-file/{filename:.+}")
	public ResponseEntity<byte[]> getActivityFile(@PathVariable String filename) {
		ActivityFileTran document = fileTranService.getActivityFile(filename);
		if (document.getData().length > 0) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getDocName() + "\"")
					.body(document.getData());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/activity-file-list/{rocode}")
	public ArrayList<String> getMethodName(@PathVariable String rocode) {
		return fileTranService.getActivityFiles(Integer.parseInt(rocode));
	}

	@GetMapping("/submitted-ros")
	public ArrayList<BigDecimal> getSubmittedROs(@RequestHeader("X-Auth-User") String userId) {
		try {
			userId = AESCrypt.decrypt(userId);
			if (!AESCrypt.isValidUserid(userId)) {
				return null;
			}
			return inputTranService.getSubmittedRos(userId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
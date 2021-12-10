package com.iocl.dhruva2api.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.tracker.AuditWiseFitDetails;
import com.iocl.dhruva2api.model.tracker.FITTracker;
import com.iocl.dhruva2api.model.tracker.FITTrackerPhoto;
import com.iocl.dhruva2api.model.tracker.TrackerROMaster;
import com.iocl.dhruva2api.payload.ApiResponse;
import com.iocl.dhruva2api.service.tracker.AuditWiseFitDetailsService;
import com.iocl.dhruva2api.service.tracker.TrackerService;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in"  })

@RequestMapping("/fit-tracker")
public class TrackerController {

	@Autowired
	private TrackerService trackerService;

	@Autowired
	private AuditWiseFitDetailsService auditWiseFitDetailsService;

	@GetMapping("/latest-submitted-audits")
	public ArrayList<TrackerROMaster> getLatestSubmittedAudit(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return trackerService.getTrackerROMaster(userId);
	}

	@PostMapping("/audit-wise-fit-details")
	public ArrayList<AuditWiseFitDetails> findAuditWiseFitDetails(@RequestHeader("X-Auth-User") String userId,
			@RequestBody LinkedHashMap<String, String> auditMap) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		Long auditId = Long.parseLong(auditMap.get("currentAudit"));
		return auditWiseFitDetailsService.getAuditWiseFitDetails(auditId);
	}

	@GetMapping("/check-photo-fit/{auditId}/{categoryId}")
	public ApiResponse checkPhotoExistense(@RequestHeader("X-Auth-User") String userId, @PathVariable String auditId,
			@PathVariable String categoryId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		return new ApiResponse(trackerService.checkPhoto(Long.parseLong(auditId), Integer.parseInt(categoryId)),
				"Response for existence of photo for request");
	}

	@GetMapping("/fit-tracker-photo/{auditId}/{categoryId}")
	public ResponseEntity<byte[]> getMethodName(@PathVariable String auditId, @PathVariable String categoryId) {

		FITTrackerPhoto photo = trackerService.getFITTrackerPhoto(auditId, categoryId);

		if (photo.getPhoto().length > 0) {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=\"fit-tracker-" + auditId + "-" + categoryId + "-" + new Date().getTime() + ".jpeg\"")
					.body(photo.getPhoto());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

	@PostMapping("/fit-tracker-file")
	public ResponseEntity<ApiResponse> saveFITTrackerPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam("auditId") String auditId, @RequestParam("categoryId") String categoryId,
			@RequestHeader("X-Auth-User") String userId) throws NumberFormatException, IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		if (trackerService.saveFITTrackerPhoto(file, Long.parseLong(auditId), Integer.parseInt(categoryId), userId) > 0) {
			return ResponseEntity.ok(new ApiResponse(true, "Photo uploaded successfully"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(true, "Photo upload failed"));
		}
	}

	@PostMapping("/fit-tracker-detail")
	public ResponseEntity<ApiResponse> saveFITTrackerDetail(@RequestBody FITTracker entity,
			@RequestHeader("X-Auth-User") String userId) throws NumberFormatException, IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		if (trackerService.saveFITTrackerDetail(entity, userId) > 0) {
			return ResponseEntity.ok(new ApiResponse(true, "Data updated successfully"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(true, "Data update failed"));
		}
	}

	@PostMapping("/fit-tracker-detail/revert")
	public ResponseEntity<ApiResponse> revertFITTrackerDetail(@RequestBody FITTracker entity,
			@RequestHeader("X-Auth-User") String userId) throws NumberFormatException, IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		if (trackerService.revertFITTrackerDetail(entity, userId) > 0) {
			return ResponseEntity.ok(new ApiResponse(true, "Revert to FO successful"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(true, "Revert to FO failed"));
		}
	}

}

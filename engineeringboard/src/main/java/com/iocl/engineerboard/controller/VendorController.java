package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.DhruvaCustomer;
import com.iocl.dhruva2api.model.vendor.VendorAdminInputData;
import com.iocl.dhruva2api.model.vendor.VendorAssignInputData;
import com.iocl.dhruva2api.model.vendor.VendorAssignOptionData;
import com.iocl.dhruva2api.model.vendor.VendorManage;
import com.iocl.dhruva2api.model.vendor.VendorMaster;
import com.iocl.dhruva2api.payload.ApiResponse;
import com.iocl.dhruva2api.service.vendor.VendorAdminService;
import com.iocl.dhruva2api.service.vendor.VendorAssignService;
import com.iocl.dhruva2api.service.vendor.VendorManageService;
import com.iocl.dhruva2api.service.vendor.VendorMasterService;
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
 * VendorController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in", "https://spandan.indianoil.co.in" })
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorMasterService vendorMasterService;

	@Autowired
	private VendorAdminService vendorAdminService;

	@Autowired
	private VendorAssignService vendorAssignService;

	@Autowired
	private VendorManageService vendorManageService;

	@GetMapping("/vendor-details/{vendorCode}")
	public ResponseEntity<VendorMaster> getMethodName(@PathVariable String vendorCode,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(vendorMasterService.getVendormaster(vendorCode));
	}

	@PostMapping("/vendor-admin-details")
	public ResponseEntity<ApiResponse> saveVendorAdminDetails(@RequestBody VendorAdminInputData vendorAdminDetails,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		if (vendorAdminService.saveVendorAdminDetails(vendorAdminDetails, userId) == 1) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true,
					"Vendor registration successful for vendor code: " + vendorAdminDetails.getVendorCode()));
		} else {
			return ResponseEntity.badRequest().body(
					new ApiResponse(false, "Vendor registration failed for vendor code: " + vendorAdminDetails.getVendorCode()));
		}
		// System.out.println(vendorAdminDetails);
	}

	@GetMapping("/vendor-assign-list/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public ResponseEntity<ArrayList<DhruvaCustomer>> getMethodName(@PathVariable String salesOrg,
			@PathVariable String salesOff, @PathVariable String salesArea, @PathVariable String archetypeCode,
			@PathVariable String phase, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		return ResponseEntity
				.ok(vendorAssignService.fetchRetailOutletsForAssignment(salesOrg, salesOff, salesArea, archetypeCode, phase));
	}

	@PostMapping("/vendor-assign-details/upload")
	public ResponseEntity<ApiResponse> saveVendorAssignDetails(
			@RequestBody ArrayList<VendorAssignInputData> vendorAssignDetails, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		// vendorAssignDetails.forEach(System.out::println);
		if (vendorAssignService.saveVendorAssignUploadData(vendorAssignDetails, userId) == 1) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ApiResponse(true, "Vendor assignment details capture successful"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Vendor assignment details capture failed"));
		}
	}

	@PostMapping("/vendor-assign-details/options")
	public ResponseEntity<ApiResponse> saveVendorAssignDetails(@RequestBody VendorAssignOptionData vendorAssignOptionData,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		System.out.println(vendorAssignOptionData);
		if (vendorAssignService.saveVendorAssignOptionData(vendorAssignOptionData, userId) == 1) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ApiResponse(true, "Vendor assignment details capture successful"));
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Vendor assignment details capture failed"));
		}
	}

	@GetMapping("/vendor-manage-details/{personnelType}")
	public ResponseEntity<ArrayList<VendorManage>> getVendorManageDatas(@PathVariable String personnelType,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok().body(vendorManageService.getVendorManageDatas(personnelType));
	}

	@GetMapping(value = "/vendor-manage/activate/{vendorCode}")
	public ResponseEntity<ApiResponse> activatePersonnel(@PathVariable String vendorCode,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		if (vendorManageService.toggleVendorState(vendorCode, "A") > 0) {
			return ResponseEntity.ok(new ApiResponse(true, "Activation successful for vendor code: " + vendorCode));
		} else {
			return ResponseEntity.badRequest()
					.body(new ApiResponse(false, "Activation failed for vendor code: " + vendorCode));
		}
	}

	@GetMapping(value = "/vendor-manage/deactivate/{vendorCode}")
	public ResponseEntity<ApiResponse> deActivatePersonnel(@PathVariable String vendorCode,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		if (vendorManageService.toggleVendorState(vendorCode, "D") > 0) {
			return ResponseEntity.ok(new ApiResponse(true, "Deactivation successful for vendor code: " + vendorCode));
		} else {
			return ResponseEntity.badRequest()
					.body(new ApiResponse(false, "Deactivation failed for vendor code: " + vendorCode));
		}
	}

}
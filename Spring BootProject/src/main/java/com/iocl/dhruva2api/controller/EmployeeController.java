package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.DhruvaCustomer;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.util.AESCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in"  })
public class EmployeeController {

	@Autowired
	public EmployeeMasterService employeeService;

	@GetMapping("/employee")
	public ArrayList<DhruvaCustomer> getEmployeeCustomerDetails(@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return employeeService.getDhruvaCustomersByEmployeeCode(Integer.parseInt(userId));
	}
	
	@GetMapping("/rca-customers")
	public ArrayList<DhruvaCustomer> getRCACustomerDetails(@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return employeeService.getRCACustomersByEmployeeCode(Integer.parseInt(userId));
	}

	@GetMapping("/employee-details")
	public String[] getEmployeePersonalDetails(@RequestHeader("X-Auth-User") String userId) {
		EmployeeMaster emp = employeeService.getEmployeeMaster(Integer.parseInt(userId));
		String[] array = { emp.getEmpName(), emp.getDesignation() };
		return array;
	}

	@GetMapping(value = "/health")
	public ResponseEntity<String> getHealthStatus() {
		return ResponseEntity.ok("{\"status\":\"UP\"}");
	}

//	@GetMapping("/delete-user")
//	public String deleteUser(@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
//		String decryptedUserName = AESCrypt.decrypt(userId);
//		ApplicationOneTimeConstants.encryptedTextEncryptionKeyMap.remove(userId);
//		ApplicationOneTimeConstants.userNameEncryptedTextMap.remove(decryptedUserName);
//		return "";
//	}

}
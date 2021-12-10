package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.rca.DhruvaRootCauseData;
import com.iocl.dhruva2api.model.rca.RcaAtrId;
import com.iocl.dhruva2api.model.rca.RcaFormData;
import com.iocl.dhruva2api.model.rca.RootCauseIssues;
import com.iocl.dhruva2api.model.rca.RootCauseSupportOptions;
import com.iocl.dhruva2api.model.rca.SubmittedRcaAtr;
import com.iocl.dhruva2api.service.DhruvaRootCauseService;
import com.iocl.dhruva2api.service.rca.RcaAtrService;
import com.iocl.dhruva2api.service.rca.RootCauseIssueSupportOptionsService;
import com.iocl.dhruva2api.service.rca.RootCauseIssuesService;
import com.iocl.dhruva2api.service.rca.SubmittedRcaAtrService;
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
 * RootCauseController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in" })
@RequestMapping("/root-cause")
public class RootCauseController {

	@Autowired
	private DhruvaRootCauseService rootCauseService;

	@Autowired
	private RootCauseIssuesService rootCauseIssuesService;

	@Autowired
	private RootCauseIssueSupportOptionsService rootCauseIssueSupportOptionsService;

	@Autowired
	private RcaAtrService rcaAtrService;

	@Autowired
	private SubmittedRcaAtrService submittedRcaAtrService;

	@GetMapping("/root-cause-datas")
	public ArrayList<DhruvaRootCauseData> getDhruvaRootCauseDatas() {
		return rootCauseService.getDhruvaRootCauseDatas();
	}

	@GetMapping("/issues/{id}")
	public ArrayList<RootCauseIssues> getRootCauseIssues(@PathVariable String id) {
		return rootCauseIssuesService.getRootCauseIssues(Integer.parseInt(id));
	}

	@GetMapping("/issue/support/{id}")
	public ArrayList<RootCauseSupportOptions> getRootCauseSupportOptions(@PathVariable String id) {
		return rootCauseIssueSupportOptionsService.getRootCauseSupportOptions(Integer.parseInt(id));
	}

	@GetMapping("/root-cause-data/{rocode}/{rootCauseSrNo}")
	public ResponseEntity<ArrayList<SubmittedRcaAtr>> getMethodName(@PathVariable("rocode") String roCode,
			@PathVariable("rootCauseSrNo") int rootCauseSrNo) {
		ArrayList<SubmittedRcaAtr> submittedAtrDatas = submittedRcaAtrService.getSubmittedRcaAtr(roCode, rootCauseSrNo);
		if (submittedAtrDatas.size() > 0) {
			return ResponseEntity.ok(submittedAtrDatas);
		} else {
			return ResponseEntity.ok(new ArrayList<>());
		}
	}

	@PostMapping("/save-rca-form")
	public ResponseEntity<String> saveRcaForm(@RequestBody RcaFormData entity,
			@RequestHeader("X-Auth-User") String user)
			throws ParseException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException,
			BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		// We can not make client site validation for required fields because Form's
		// nature is dynamic, sometimes it needs those fields, some times it does not.

		user = AESCrypt.decrypt(user);
		if (!AESCrypt.isValidUserid(user)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some Error Occurred!!");
		}
		boolean isFormCompleted = rcaAtrService.saveRcaForm(entity, user);
		if (isFormCompleted)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incomplete Details");
	}

	@GetMapping("/submitted-ros")
	public ArrayList<RcaAtrId> getSubmittedROs(@RequestHeader("X-Auth-User") String userId) {
		try {
			userId = AESCrypt.decrypt(userId);
			if (!AESCrypt.isValidUserid(userId)) {
				return null;
			}
			return submittedRcaAtrService.getSubmittedRos(userId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
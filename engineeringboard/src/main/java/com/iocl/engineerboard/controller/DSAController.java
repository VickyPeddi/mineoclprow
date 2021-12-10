package com.iocl.dhruva2api.controller;

import java.util.List;

import com.iocl.dhruva2api.model.dsa.DSASummary;
import com.iocl.dhruva2api.payload.ApiResponse;
import com.iocl.dhruva2api.service.dsa.DSAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DSAController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in"  })
@RequestMapping("/dsa-summary")
public class DSAController {

	@Autowired
	private DSAService dsaService;

	@PostMapping("/data")
	public ResponseEntity<ApiResponse> saveDSASummaryData(@RequestBody List<DSASummary> dsaPayload) {

		// dsaPayload.forEach(System.out::println);
		String response = dsaService.saveDSASummaryData(dsaPayload);
		if ("OK".equals(response)) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ApiResponse(true, "DSA Summary details capture successful"));
		} else {
			return ResponseEntity.ok().body(new ApiResponse(false, response));
		}
	}

}
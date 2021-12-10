package com.iocl.dhruva2api.controller;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.help.DhruvaHelpResponsePayload;
import com.iocl.dhruva2api.service.help.DhruvaHelpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelpController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in","https://spandan.indianoil.co.in" })
@RequestMapping("/help")
public class HelpController {

	@Autowired
	public DhruvaHelpService dhruvaHelpService;

	@GetMapping("/personnel")
	public ResponseEntity<ArrayList<DhruvaHelpResponsePayload>> getDhruvaPersonnel() {
		return ResponseEntity.ok(dhruvaHelpService.getDhruvaHelpContents());
	}

}
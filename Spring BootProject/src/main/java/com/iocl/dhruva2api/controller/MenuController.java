package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.iocl.dhruva2api.model.MISMenuItems;
import com.iocl.dhruva2api.model.menu.AuditMenuTabs;
import com.iocl.dhruva2api.model.menu.InputMenuTabs;
//import com.iocl.dhruva2api.model.menu.LeaderboardMenuTabs;
import com.iocl.dhruva2api.model.menu.MISMenuTabs;
import com.iocl.dhruva2api.model.menu.Menu;
import com.iocl.dhruva2api.service.menu.AuditMenuTabsService;
import com.iocl.dhruva2api.service.menu.InputMenuTabsService;
//import com.iocl.dhruva2api.service.menu.LeaderboardMenuTabsService;
import com.iocl.dhruva2api.service.menu.MISMenuItemsService;
import com.iocl.dhruva2api.service.menu.MISMenuTabsService;
import com.iocl.dhruva2api.service.menu.MenuService;
import com.iocl.dhruva2api.util.AESCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MenuController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in","https://spandan.indianoil.co.in" })

@RequestMapping(path = "/menus")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private InputMenuTabsService inputMenuTabsService;

	@Autowired
	private MISMenuTabsService misMenuTabsService;

	@Autowired
	private MISMenuItemsService misMenuItemsService;

//	@Autowired
//	private LeaderboardMenuTabsService leaderboardMenuTabsService;

	@Autowired
	private AuditMenuTabsService auditMenuTabsService;

	@GetMapping("/input-tabs")
	public ResponseEntity<ArrayList<InputMenuTabs>> getInputTabs(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(inputMenuTabsService.getInputMenuTabs(Integer.parseInt(userId)));
	}

	@GetMapping("/mis-tabs")
	public ResponseEntity<ArrayList<MISMenuTabs>> getMISTabs(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		ArrayList<MISMenuTabs> returnedList = misMenuTabsService.getTabsAndMenus(Integer.parseInt(userId));
		for (MISMenuTabs temp : returnedList) {
			Collections.sort(temp.getMenuItems());
		}
		return ResponseEntity.ok(returnedList);
	}

	@GetMapping("/mis-tab/report/{id}")
	public MISMenuItems getMISTabReport(@PathVariable String id) {
		return misMenuItemsService.getReport(Long.parseLong(id));
	}

//	@GetMapping("/leaderboard-tabs")
//	public ResponseEntity<ArrayList<LeaderboardMenuTabs>> getLeaderboardTabs(@RequestHeader("X-Auth-User") String userId)
//			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
//			NoSuchAlgorithmException, NoSuchPaddingException {
//		userId = AESCrypt.decrypt(userId);
//		if (!AESCrypt.isValidUserid(userId)) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//		}
//		return ResponseEntity.ok(leaderboardMenuTabsService.getLeaderboardMenuTabs(Integer.parseInt(userId)));
//	}

	@GetMapping("/audit-tabs")
	public ResponseEntity<ArrayList<AuditMenuTabs>> getAuditorMenuTabs(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(auditMenuTabsService.getAuditMenuTabs());
	}

	@GetMapping("/menu-tabs")
	public ResponseEntity<ArrayList<Menu>> getMenus(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(menuService.getTabsAndMenus(Integer.parseInt(userId)));
	}

}
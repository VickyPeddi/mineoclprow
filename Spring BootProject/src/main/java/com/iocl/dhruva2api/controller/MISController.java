package com.iocl.dhruva2api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iocl.dhruva2api.model.SOMaster;
import com.iocl.dhruva2api.model.mis.ArchetypeMaster;
import com.iocl.dhruva2api.model.mis.MISReportWrapper;
import com.iocl.dhruva2api.model.mis.ParameterMaster;
import com.iocl.dhruva2api.model.mis.PhaseMaster;
import com.iocl.dhruva2api.service.SOMasterService;
import com.iocl.dhruva2api.service.mis.ArchetypeMasterService;
import com.iocl.dhruva2api.service.mis.MISReportService;
import com.iocl.dhruva2api.service.mis.ParameterMasterService;
import com.iocl.dhruva2api.service.mis.PhaseMasterService;
import com.iocl.dhruva2api.util.AESCrypt;

/**
 * MISController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://uat.indianoil.co.in", "https://spandan.indianoil.co.in" })

@RequestMapping("/mis")
public class MISController {

	@Autowired
	private SOMasterService soMasterService;

	@Autowired
	private ArchetypeMasterService archetypeMasterService;

	@Autowired
	private PhaseMasterService phaseMasterService;

	@Autowired
	private ParameterMasterService parameterMasterService;

	@Autowired
	private MISReportService misReportsService;

	@GetMapping("/so-do-sa-list")
	public ArrayList<SOMaster> getSOList(@RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return soMasterService.getSoList(Integer.parseInt(userId));
	}

	@GetMapping("/archetype-list")
	public ArrayList<ArchetypeMaster> getArchetypeMasters() {
		return archetypeMasterService.getArchetypeMasters();
	}

	@GetMapping("/phase-list")
	public ArrayList<PhaseMaster> getPhaseMasters() {
		return phaseMasterService.getPhaseMasters();
	}

	@GetMapping("/parameter-list")
	public ArrayList<ParameterMaster> getParameters() {
		return parameterMasterService.getParameters();
	}

	@GetMapping(value = "/show-mis-report/{reportId}/{salesOrg}/{salesOff}/{salesArea}")
	public MISReportWrapper getMIsReport(@PathVariable String reportId, @PathVariable String salesOrg,
			@PathVariable String salesOff, @PathVariable String salesArea, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId));
	}

	@GetMapping(value = "/show-mis-report/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{fromDate}/{toDate}")
	public MISReportWrapper getMIsReport(@PathVariable String reportId, @PathVariable String salesOrg,
			@PathVariable String salesOff, @PathVariable String salesArea, @RequestHeader("X-Auth-User") String userId,
			@PathVariable String fromDate, @PathVariable String toDate)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), fromDate, toDate);
	}

	@GetMapping(value = "/show-mis-report/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{fromDate}/{toDate}/{filterType}")
	public MISReportWrapper getMIsReport(@PathVariable String reportId, @PathVariable String salesOrg,
			@PathVariable String salesOff, @PathVariable String salesArea, @RequestHeader("X-Auth-User") String userId,
			@PathVariable String fromDate, @PathVariable String toDate, @PathVariable String filterType)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), fromDate, toDate, filterType);
	}

	@GetMapping(value = "/show-mis-report/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{filterType}")
	public MISReportWrapper getMIsReport(@PathVariable String reportId, @PathVariable String salesOrg,
			@PathVariable String salesOff, @PathVariable String salesArea, @RequestHeader("X-Auth-User") String userId,
			@PathVariable String filterType) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), filterType);
	}

	@GetMapping(value = "/show-mis-report/{reportId}")
	public MISReportWrapper getMIsReportWithArchetypePhase(@PathVariable String reportId,
			@RequestParam("salesOrg") String salesOrg, @RequestParam("salesOff") String salesOff,
			@RequestParam("salesArea") String salesArea, @RequestParam("archetypeCode") String archetypeCode,
			@RequestParam("phase") String phase, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode),
				phase);
	}

	@GetMapping(value = "/show-mis-report/{reportId}/{salesOrg}/{salesOff}")
	public MISReportWrapper getMIsReportWithFromTodate(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), Integer.parseInt(userId), fromDate, toDate);
	}

	@GetMapping(value = "/show-mis-report/{reportId}/{salesOrg}")
	public MISReportWrapper getMIsReportWithSiteType(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @RequestParam("salesOff") String salesOff,
			@RequestParam("salesArea") String salesArea, @RequestParam("filterType") String filterType,
			@RequestParam("filterSite") String filterSite, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), filterType,
				Integer.parseInt(filterSite));
	}

	@GetMapping(value = "/show-mis-report-class-ten/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassTen(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("financialYear") String financialYear,
			@RequestParam("financialQuarter") String financialQuarter, @RequestParam("filterIndex") String filterIndex,
			@RequestParam("filterSite") String filterSite, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}
		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode), phase,
				financialYear, Integer.parseInt(financialQuarter), Integer.parseInt(filterIndex),
				Integer.parseInt(filterSite));
	}

	@GetMapping(value = "/show-mis-report-class-eleven/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassEleven(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("financialYear") String financialYear,
			@RequestParam("financialQuarter") String financialQuarter, @RequestParam("filterIndex") String filterIndex,
			@RequestParam("filterSite") String filterSite, @RequestParam("filterParameter") String filterParameter,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		MISReportWrapper misReportWrapper = misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId),
				Integer.parseInt(salesOrg), Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId),
				Integer.parseInt(archetypeCode), phase, financialYear, Integer.parseInt(financialQuarter),
				Integer.parseInt(filterIndex), Integer.parseInt(filterSite), Integer.parseInt(filterParameter));
		return misReportWrapper;
	}

	@GetMapping(value = "/show-mis-report-class-twelve/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassTwelve(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("financialYear") String financialYear,
			@RequestParam("financialQuarter") String financialQuarter, @RequestParam("filterSite") String filterSite,
			@RequestParam("filterType") String filterType, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode), phase,
				financialYear, Integer.parseInt(financialQuarter), Integer.parseInt(filterSite), filterType);
	}

	@GetMapping(value = "/show-mis-report-class-thirteen/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassThirteen(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("financialYear") String financialYear,
			@RequestParam("financialQuarter") String financialQuarter, @RequestParam("filterSite") String filterSite,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode), phase,
				financialYear, Integer.parseInt(financialQuarter), Integer.parseInt(filterSite));
	}

	@GetMapping(value = "/show-mis-report-class-fourteen/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassFourteen(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("filterSite") String filterSite,
			@RequestParam("filterIndex") String filterIndex, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode), phase,
				Integer.parseInt(filterSite), Integer.parseInt(filterIndex));
	}

	@GetMapping(value = "/show-mis-report-class-fifteen/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassFifteen(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("filterSite") String filterSite,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode), phase,
				Integer.parseInt(filterSite));
	}

	@GetMapping(value = "/show-mis-report-class-sixteen/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassSixteen(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("filterIndex") String filterIndex,
			@RequestParam("filterParameter") String filterParameter, @RequestParam("filterSite") String filterSite,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode), phase,
				Integer.parseInt(filterIndex), Integer.parseInt(filterParameter), Integer.parseInt(filterSite));
	}

	@GetMapping(value = "/show-mis-report-class-seventeen/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassSeventeen(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("financialYear") String financialYear,
			@RequestParam("filterSite") String filterSite, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode), phase,
				financialYear, Integer.parseInt(filterSite));
	}

	@GetMapping(value = "/show-mis-report-class-eighteen/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassEighteen(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("financialYear") String financialYear,
			@RequestParam("filterSite") String filterSite, @RequestParam("filterType") String filterType,
			@RequestHeader("X-Auth-User") String userId) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		return misReportsService.getReportHeadersAndDatas(Long.parseLong(reportId), Integer.parseInt(salesOrg),
				Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId), Integer.parseInt(archetypeCode), phase,
				financialYear, Integer.parseInt(filterSite), filterType);
	}

	@GetMapping(value = "/show-mis-report-class-nineteen/{reportId}/{salesOrg}/{salesOff}/{salesArea}/{archetypeCode}/{phase}")
	public MISReportWrapper getMISReportClassNineteen(@PathVariable String reportId,
			@PathVariable("salesOrg") String salesOrg, @PathVariable("salesOff") String salesOff,
			@PathVariable("salesArea") String salesArea, @PathVariable("archetypeCode") String archetypeCode,
			@PathVariable("phase") String phase, @RequestParam("financialYear") String financialYear,
			@RequestParam("filterIndex") String filterIndex, @RequestParam("filterSite") String filterSite,
			@RequestParam("filterParameter") String filterParameter, @RequestHeader("X-Auth-User") String userId)
			throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		userId = AESCrypt.decrypt(userId);
		if (!AESCrypt.isValidUserid(userId)) {
			return null;
		}

		MISReportWrapper misReportWrapper = misReportsService.getReportHeadersAndDatasNineteen(Long.parseLong(reportId),
				Integer.parseInt(salesOrg), Integer.parseInt(salesOff), salesArea, Integer.parseInt(userId),
				Integer.parseInt(archetypeCode), phase, financialYear, Integer.parseInt(filterIndex),
				Integer.parseInt(filterSite), Integer.parseInt(filterParameter));
		return misReportWrapper;
	}
}
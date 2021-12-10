package com.iocl.dhruva2api.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.iocl.dhruva2api.model.DODhruvaCompliantScore;
import com.iocl.dhruva2api.model.common.MstLeaderboardWeightage;
import com.iocl.dhruva2api.model.leaderboard.DOAWESUMScore;
import com.iocl.dhruva2api.model.leaderboard.DOFITScore;
import com.iocl.dhruva2api.model.leaderboard.DOLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.DOManagerLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.DOSEVAScore;
import com.iocl.dhruva2api.model.leaderboard.DoEnggLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.FOLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.SAAWESUMScore;
import com.iocl.dhruva2api.model.leaderboard.SADhruvaCompliant;
import com.iocl.dhruva2api.model.leaderboard.SAFITScore;
import com.iocl.dhruva2api.model.leaderboard.SASEVAScore;
import com.iocl.dhruva2api.model.leaderboard.SOAWESUMScore;
import com.iocl.dhruva2api.model.leaderboard.SODhruvaCompliantScore;
import com.iocl.dhruva2api.model.leaderboard.SOLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.SOManagerLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.SOSEVAScore;
import com.iocl.dhruva2api.model.leaderboard.SoEnggLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.SOFITScore;
import com.iocl.dhruva2api.service.dashboard.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DashboardController and lederboard tab controller
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in"  })
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/state-dhruva-index")
	public ArrayList<SOLeaderboard> getStateDhruvaIndex() {
		return dashboardService.getStateDhruvaIndex();
	}

	@GetMapping("/state-dhruva-index/{soMaster}")
	public SOLeaderboard getStateDhruvaIndex(@PathVariable String soMaster) {
		return dashboardService.getSoLeaderboard(soMaster);
	}

	@GetMapping("/state-fit-score")
	public ArrayList<SOFITScore> getStateFITScore() {
		return dashboardService.getSOFITScores();
	}

	@GetMapping("/state-seva-score")
	public ArrayList<SOSEVAScore> getStateSEVAScore() {
		return dashboardService.getSOSEVAScores();
	}

	@GetMapping("/division-fit-score/{soName}")
	public ArrayList<DOFITScore> getDivisionFITScoreBySoName(@PathVariable String soName) {
		return dashboardService.getDOFITScoresBySoName(soName);
	}

	@GetMapping("/division-seva-score/{soName}")
	public ArrayList<DOSEVAScore> getDivisionSevaScoreBySoName(@PathVariable String soName) {
		return dashboardService.getDOSEVAScores(soName);
	}

	@GetMapping("/state-awesum-score")
	public ArrayList<SOAWESUMScore> getStateAWESUMScore() {
		return dashboardService.getSOAWESUMScores();
	}

	@GetMapping("/state-awesum-score/{soName}")
	public SOAWESUMScore getStateAWESUMScore(@PathVariable String soName) {
		return dashboardService.getSOAWESUMScore(soName);
	}

	@GetMapping("/division-awesum-score/{soName}")
	public ArrayList<DOAWESUMScore> getDivisionAWESUMScore(@PathVariable String soName) {
		return dashboardService.getDOAWESUMScores(soName);
	}

	@GetMapping("/division-awesum-score/division/{doName}")
	public DOAWESUMScore getDivisionAWESUMScoreByDO(@PathVariable String doName) {
		return dashboardService.getDOAWESUMScore(doName);
	}

	@GetMapping("/sa-awesum-score/{doName}")
	public ArrayList<SAAWESUMScore> getSaAWESUMScoreBySoCode(@PathVariable String doName) {
		return dashboardService.getSAAWESUMScores(doName);
	}

	@GetMapping("/sa-awesum-score/sa/{saName}")
	public SAAWESUMScore getSaAWESUMScoreBySaCode(@PathVariable String saName) {
		return dashboardService.getSAAWESUMScore(saName);
	}

	@GetMapping("/sa-fit-score/{doName}")
	public ArrayList<SAFITScore> getSaFITcoreBySoCode(@PathVariable String doName) {
		return dashboardService.getSAFITScores(doName);
	}

	@GetMapping("/sa-seva-score/{doName}")
	public ArrayList<SASEVAScore> getSaSEVAcoreBySoCode(@PathVariable String doName) {
		return dashboardService.getSASEVAScores(doName);
	}

	@GetMapping("/sa-dhruva-compliant-score/{doName}")
	public ArrayList<SADhruvaCompliant> getSaDhruvaCompliantcoreBySoCode(@PathVariable String doName) {
		return dashboardService.getSADhruvaCompliant(doName);
	}

	@GetMapping("/state-dhruva-compliant-score")
	public ArrayList<SODhruvaCompliantScore> getStateDhruvaCompliantScore() {
		return dashboardService.gSODhruvaCompliantScores();
	}

	@GetMapping("/division-dhruva-compliant-score/{soName}")
	public ArrayList<DODhruvaCompliantScore> getDivisionDhruvaCompliantScoreBySoName(@PathVariable String soName) {
		return dashboardService.getDoDhruvaCompliantScores(soName);
	}

	@GetMapping("/division-dhruva-index")
	public ArrayList<DOLeaderboard> getDivisionDhruvaIndex() {
		return dashboardService.getDivisionDhruvaIndex();
	}

	@GetMapping("/division-dhruva-index/{soMaster}")
	public ArrayList<DOLeaderboard> getDivisionDhruvaIndex(@PathVariable String soMaster) {
		return dashboardService.getDoLeaderboard(soMaster);
	}

	@GetMapping("/division-dhruva-index-by-doname/{doMaster}")
	public DOLeaderboard getDivisionDhruvaIndexByDoName(@PathVariable String doMaster) {
		return dashboardService.getDoLeaderboardByDoName(doMaster);
	}

	@GetMapping("/field-dhruva-index-by-saname/{saMaster}")
	public FOLeaderboard getFieldDhruvaIndexBySaName(@PathVariable String saMaster) {
		return dashboardService.getFoLeaderboardBySaName(saMaster);
	}

	@GetMapping("/field-dhruva-index-by-doname/{doMaster}")
	public ArrayList<FOLeaderboard> getFieldDhruvaIndexByDoName(@PathVariable String doMaster) {
		return dashboardService.getFoLeaderboardByDoName(doMaster);
	}

	@GetMapping("/field-dhruva-index")
	public ArrayList<FOLeaderboard> getFieldDhruvaIndex() {
		return dashboardService.getFieldDhruvaIndex();
	}

	@GetMapping("/division-engg-index")
	public ArrayList<DoEnggLeaderboard> getDoEnggIndex() {
		return dashboardService.getDoEnggIndex();
	}

	@GetMapping("/state-engg-index")
	public ArrayList<SoEnggLeaderboard> getSoEnggIndex() {
		return dashboardService.getSoEnggIndex();
	}

	@GetMapping("/do-manager-index")
	public ArrayList<DOManagerLeaderboard> getDoManagerIndex() {
		return dashboardService.getDoManagerIndex();
	}

	@GetMapping("/so-manager-index")
	public ArrayList<SOManagerLeaderboard> getSoManagerIndex() {
		return dashboardService.getSoManagerIndex();
	}

	@GetMapping("/weightage-data")
	public MstLeaderboardWeightage getWeightage() {
		return dashboardService.getWeightage();
	}

	@GetMapping("/do-list")
	public ArrayList<String> getDoList() {
		return dashboardService.getDoList();
	}

	@GetMapping("/so-indices/{soName}")
	public HashMap<String, Integer> getIndicesBySoName(@PathVariable String soName) {
		return dashboardService.getIndicesBySoName(soName);
	}

	@GetMapping("/do-indices/{doName}")
	public HashMap<String, Integer> getIndicesByDoName(@PathVariable String doName) {
		return dashboardService.getIndicesByDoName(doName);
	}

	@GetMapping("/sa-indices/{saName}")
	public HashMap<String, Integer> getIndicesBySaName(@PathVariable String saName) {
		return dashboardService.getIndicesBySaName(saName);
	}
}
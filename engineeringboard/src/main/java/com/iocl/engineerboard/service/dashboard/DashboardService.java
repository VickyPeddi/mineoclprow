package com.iocl.dhruva2api.service.dashboard;

import java.util.ArrayList;
import java.util.HashMap;

import com.iocl.dhruva2api.dao.dashboard.DOAWESUMScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.DODhruvaCompliantScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.DOFITScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.DOLeaderboardDAO;
import com.iocl.dhruva2api.dao.dashboard.DOManagerLeaderboardDAO;
import com.iocl.dhruva2api.dao.dashboard.DOSEVAScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.DoEnggLeaderboardDAO;
import com.iocl.dhruva2api.dao.dashboard.FOLeaderboardDAO;
import com.iocl.dhruva2api.dao.dashboard.MstLeaderBoardWeightageDAO;
import com.iocl.dhruva2api.dao.dashboard.SAAWESUMScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.SADhruvaCompliantScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.SAFITScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.SASEVAScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.SOAWESUMScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.SODhruvaCompliantScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.SOFITScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.SOLeaderboardDAO;
import com.iocl.dhruva2api.dao.dashboard.SOManagerLeaderboardDAO;
import com.iocl.dhruva2api.dao.dashboard.SOSEVAScoreDAO;
import com.iocl.dhruva2api.dao.dashboard.SoEnggLeaderboardDAO;
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
import com.iocl.dhruva2api.model.leaderboard.SOFITScore;
import com.iocl.dhruva2api.model.leaderboard.SOLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.SOManagerLeaderboard;
import com.iocl.dhruva2api.model.leaderboard.SOSEVAScore;
import com.iocl.dhruva2api.model.leaderboard.SoEnggLeaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DashboardService
 */
@Service
public class DashboardService {

	@Autowired
	private SOLeaderboardDAO soLeaderboardDAO;

	@Autowired
	private DOLeaderboardDAO doLeaderboardDAO;

	@Autowired
	private SoEnggLeaderboardDAO soEnggLeaderboardDAO;

	@Autowired
	private DoEnggLeaderboardDAO doEnggLeaderboardDAO;

	@Autowired
	private DOManagerLeaderboardDAO doManagerLeaderboardDAO;

	@Autowired
	private SOManagerLeaderboardDAO soManagerLeaderboardDAO;

	@Autowired
	private FOLeaderboardDAO foLeaderboardDAO;

	@Autowired
	private MstLeaderBoardWeightageDAO mstWeightageDao;

	@Autowired
	private SOFITScoreDAO sofitScoreDAO;

	@Autowired
	private SOSEVAScoreDAO sosevaScoreDAO;

	@Autowired
	private SOAWESUMScoreDAO soawesumScoreDAO;

	@Autowired
	private SODhruvaCompliantScoreDAO soDhruvaCompliantScoreDAO;

	@Autowired
	private DOAWESUMScoreDAO doawesumScoreDAO;

	@Autowired
	private SAAWESUMScoreDAO saawesumScoreDAO;

	@Autowired
	private SAFITScoreDAO safitScoreDAO;

	@Autowired
	private SASEVAScoreDAO sasevaScoreDAO;

	@Autowired
	private SADhruvaCompliantScoreDAO saDhruvaCompliantScoreDAO;

	@Autowired
	private DOFITScoreDAO doFitScoreDAO;

	@Autowired
	private DOSEVAScoreDAO doSevaScoreDAO;

	@Autowired
	private DODhruvaCompliantScoreDAO doDhruvaCompliantDao;

	public ArrayList<SOLeaderboard> getStateDhruvaIndex() {
		return soLeaderboardDAO.findAllByOrderByRank();
	}

	public ArrayList<DOLeaderboard> getDivisionDhruvaIndex() {
		return doLeaderboardDAO.findAllByOrderByRank();
	}

	public ArrayList<FOLeaderboard> getFieldDhruvaIndex() {
		return foLeaderboardDAO.findAllByOrderByRank();
	}

	public ArrayList<SoEnggLeaderboard> getSoEnggIndex() {
		return soEnggLeaderboardDAO.findAllByOrderByRank();
	}

	public ArrayList<DoEnggLeaderboard> getDoEnggIndex() {
		return doEnggLeaderboardDAO.findAllByOrderByRank();
	}

	public ArrayList<DOManagerLeaderboard> getDoManagerIndex() {
		return doManagerLeaderboardDAO.findAllByOrderByRank();
	}

	public ArrayList<SOManagerLeaderboard> getSoManagerIndex() {
		return soManagerLeaderboardDAO.findAllByOrderByRank();
	}

	public MstLeaderboardWeightage getWeightage() {
		return mstWeightageDao.findById(1).orElse(new MstLeaderboardWeightage());
	}

	public SOLeaderboard getSoLeaderboard(String soMaster) {
		return soLeaderboardDAO.findBySoMaster(soMaster);
	}

	public ArrayList<DOLeaderboard> getDoLeaderboard(String soMaster) {
		return doLeaderboardDAO.findBySoMasterOrderByRank(soMaster);
	}

	public DOLeaderboard getDoLeaderboardByDoName(String doMaster) {
		return doLeaderboardDAO.findByDoMasterOrderByRank(doMaster);
	}

	public ArrayList<SOFITScore> getSOFITScores() {
		return sofitScoreDAO.findAllByOrderByFitDesc();
	}

	public ArrayList<SOSEVAScore> getSOSEVAScores() {
		return sosevaScoreDAO.findAllByOrderBySevaDesc();
	}

	public ArrayList<SOAWESUMScore> getSOAWESUMScores() {
		return soawesumScoreDAO.findAllByOrderByAwesumDesc();
	}

	public SOAWESUMScore getSOAWESUMScore(String soMaster) {
		return soawesumScoreDAO.findBySoMaster(soMaster);
	}

	public ArrayList<SODhruvaCompliantScore> gSODhruvaCompliantScores() {
		return soDhruvaCompliantScoreDAO.findAllByOrderByDhruvaCompliantDesc();
	}

	public ArrayList<DOAWESUMScore> getDOAWESUMScores(String soName) {
		return doawesumScoreDAO.getDOAWESUMScoreBySalesorgNameOrderByAwesumDesc(soName);
	}

	public DOAWESUMScore getDOAWESUMScore(String doName) {
		return doawesumScoreDAO.findById(doName).orElse(new DOAWESUMScore());
	}

	public ArrayList<DOFITScore> getDOFITScoresBySoName(String soName) {
		return doFitScoreDAO.getDOFITScoreBySalesOrgNameOrderByFitDesc(soName);
	}

	public ArrayList<DOSEVAScore> getDOSEVAScores(String soName) {
		return doSevaScoreDAO.getDOSEVAScoreBySalesOrgNameOrderBySevaDesc(soName);
	}

	public ArrayList<DODhruvaCompliantScore> getDoDhruvaCompliantScores(String soName) {
		return doDhruvaCompliantDao.getDODhruvaCompliantScoreBySalesOrgNameOrderByDhruvaCompliantDesc(soName);
	}

	public ArrayList<SAAWESUMScore> getSAAWESUMScores(String doName) {
		return saawesumScoreDAO.getSAAWESUMScoreBySalesoffNameOrderByAwesumDesc(doName);
	}

	public SAAWESUMScore getSAAWESUMScore(String saMaster) {
		return saawesumScoreDAO.findById(saMaster).orElse(new SAAWESUMScore());
	}

	public ArrayList<SAFITScore> getSAFITScores(String doName) {
		return safitScoreDAO.getSAFITScoreBySalesoffNameOrderByFitDesc(doName);
	}

	public ArrayList<SASEVAScore> getSASEVAScores(String doName) {
		return sasevaScoreDAO.getSASEVAScoreBySalesoffNameOrderBySevaDesc(doName);
	}

	public ArrayList<SADhruvaCompliant> getSADhruvaCompliant(String doName) {
		return saDhruvaCompliantScoreDAO.getSADhruvaCompliantBySalesoffNameOrderByDhruvaCompliantDesc(doName);
	}

	public FOLeaderboard getFoLeaderboardBySaName(String saMaster) {
		return foLeaderboardDAO.getFOLeaderboardBySaMaster(saMaster);
	}

	public ArrayList<FOLeaderboard> getFoLeaderboardByDoName(String doMaster) {
		return foLeaderboardDAO.getFOLeaderboardByDoMasterOrderByRank(doMaster);

	}

	public ArrayList<String> getDoList() {
		return doLeaderboardDAO.getAllDo();
	}

	public HashMap<String, Integer> getIndicesBySoName(String soName) {
		SOLeaderboard soIndices = soLeaderboardDAO.findBySoMaster(soName);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("fit", soIndices.getFit());
		map.put("seva", soIndices.getSeva());
		map.put("awesum", soIndices.getAwesum());
		map.put("compliance", soIndices.getDhruvaCompliant());
		map.put("index", soIndices.getFinalDhruvaIndex());
		return map;
	}

	public HashMap<String, Integer> getIndicesByDoName(String doName) {
		DOLeaderboard doIndices = doLeaderboardDAO.findByDoMasterOrderByRank(doName);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("fit", doIndices.getFit());
		map.put("seva", doIndices.getSeva());
		map.put("awesum", doIndices.getAwesum());
		map.put("compliance", doIndices.getDhruvaCompliant());
		map.put("index", doIndices.getFinalDhruvaIndex());
		return map;
	}

	public HashMap<String, Integer> getIndicesBySaName(String saName) {
		FOLeaderboard saIndices = foLeaderboardDAO.getFOLeaderboardBySaMaster(saName);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("fit", saIndices.getFit());
		map.put("seva", saIndices.getSeva());
		map.put("awesum", saIndices.getAwesum());
		map.put("compliance", saIndices.getDhruvaCompliant());
		map.put("index", saIndices.getFinalDhruvaIndex());
		return map;
	}
}

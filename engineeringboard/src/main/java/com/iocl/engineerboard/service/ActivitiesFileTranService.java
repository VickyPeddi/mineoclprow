package com.iocl.dhruva2api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.iocl.dhruva2api.dao.ActivitiesFileTranDAO;
import com.iocl.dhruva2api.model.activity.ActivityFileId;
import com.iocl.dhruva2api.model.activity.ActivityFileTran;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * ActivitiesFileTranService
 */
@Service
public class ActivitiesFileTranService {

	@Autowired
	private ActivitiesFileTranDAO fileTranDAO;
	@Autowired
	private EmployeeMasterService emMasterService;

	public void saveActivityFileData(MultipartFile file, int activityCode, int roCode, int empId) {

		ActivityFileTran fileTranData = new ActivityFileTran();
		ActivityFileId fileId = new ActivityFileId(roCode,activityCode);
		fileTranData.setEmbeddedKey(fileId);
		fileTranData.setDocName(
				roCode + "_" + activityCode + "_" + new Date().getTime() + "_" + file.getOriginalFilename());
		EmployeeMaster em = emMasterService.getEmployeeMaster(empId);
		fileTranData.setUserDetails(em.getEmpCode() + "---" + em.getEmpName() + "---" + em.getDesignation());
		fileTranData.setUpdatedOn(new Date());
		try {
			fileTranData.setData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileTranDAO.save(fileTranData);
	}

	public ArrayList<String> getActivityFiles(int roCode) {
		return fileTranDAO.getDocNameByRoCode(roCode);
	}

	public ActivityFileTran getActivityFile(String filename) {
		try {
			return fileTranDAO.getByDocName(filename);
		} catch (Exception e) {
			e.printStackTrace();
			return new ActivityFileTran();
		}
	}

}
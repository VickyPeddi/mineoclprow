package com.iocl.dhruva2api.service.help;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.help.DhruvaHelpDAO;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.model.help.DhruvaHelpResponsePayload;
import com.iocl.dhruva2api.service.EmployeeMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DhruvaHelpService
 */
@Service
public class DhruvaHelpService {

	@Autowired
	private DhruvaHelpDAO dhruvaHelpDAO;

	@Autowired
	private EmployeeMasterService employeeMasterService;

	public ArrayList<DhruvaHelpResponsePayload> getDhruvaHelpContents() {

		ArrayList<DhruvaHelpResponsePayload> payloads = new ArrayList<>();

		dhruvaHelpDAO.findByActiveFlag('A').forEach(dhruvaHelp -> {
			EmployeeMaster master = employeeMasterService.getEmployeeMaster(dhruvaHelp.getEmpCode());
			DhruvaHelpResponsePayload payload = new DhruvaHelpResponsePayload(master.getEmpCode(), master.getEmpName(),
					master.getEmailId(), master.getMobileNo(), dhruvaHelp.getUserType());
			payloads.add(payload);
		});

		return payloads;
	}

}
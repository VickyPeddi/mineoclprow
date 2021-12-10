package com.iocl.dhruva2api.service.mis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.audit.TPCAuditImagesDAO;
import com.iocl.dhruva2api.dao.sqc.SQCAuditImagesDAO;
import com.iocl.dhruva2api.model.audit.TPCAuditImages;
import com.iocl.dhruva2api.model.audit.TPCAuditImagesID;
import com.iocl.dhruva2api.model.sqc.SQCAuditImages;
import com.iocl.dhruva2api.model.sqc.SQCAuditImagesID;

@Service
public class AuditImagesDownloadService {

	@Autowired
	SQCAuditImagesDAO sqcAuditImagesDAO;

	@Autowired
	TPCAuditImagesDAO tPCAuditImagesDAO;

	public byte[] getAuditImages(String auditType, long auditId, int mappingId) {
		if (auditType.equals("sqc")) {
			SQCAuditImagesID sqcAuditImagesID = new SQCAuditImagesID(auditId, mappingId);
			return sqcAuditImagesDAO.findById(sqcAuditImagesID).orElse(new SQCAuditImages()).getImageData();
		}
		if (auditType.equals("tpc")) {
			TPCAuditImagesID tpcAuditImagesID = new TPCAuditImagesID(auditId, mappingId);
			return tPCAuditImagesDAO.findById(tpcAuditImagesID).orElse(new TPCAuditImages()).getImageData();
		}
		return null;
	}

}

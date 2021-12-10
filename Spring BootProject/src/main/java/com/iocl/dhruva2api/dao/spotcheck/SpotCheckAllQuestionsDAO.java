package com.iocl.dhruva2api.dao.spotcheck;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.spotcheck.ModuleQuestionMaster;
import com.iocl.dhruva2api.model.spotcheck.ModuleQuestionMasterId;
//import com.iocl.dhruva2api.model.spotcheck.SpotcheckAllquestions;

@Transactional
public interface SpotCheckAllQuestionsDAO extends CrudRepository<ModuleQuestionMaster, ModuleQuestionMasterId>{

}

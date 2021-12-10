package com.iocl.dhruva2api.dao.procedureDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.iocl.dhruva2api.model.common.StoredProcedureParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@SuppressWarnings("rawtypes")
public class GenericProcedureCallDAO {

	@Autowired
	private EntityManager entityManager;

	public Object callProcAndReturnObejct(String procedureName, Class procedureModel, StoredProcedureParameter param) {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery(procedureName, procedureModel);
		procedureQuery.registerStoredProcedureParameter("insp_cursor", void.class, ParameterMode.REF_CURSOR);
		procedureQuery.registerStoredProcedureParameter(param.getParameterName(), param.getClassType(), param.getMode());
		procedureQuery.setParameter(param.getParameterName(), param.getParameterValue());
		procedureQuery.execute();

		return procedureQuery.getResultList().get(0);
	}

	public Object callProcAndReturnOutParam(String procedureName, String outParamName, Class outParamDataType,
			StoredProcedureParameter param) {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery(procedureName);
		procedureQuery.registerStoredProcedureParameter(outParamName, outParamDataType, ParameterMode.OUT);
		procedureQuery.registerStoredProcedureParameter(param.getParameterName(), param.getClassType(), param.getMode());
		procedureQuery.setParameter(param.getParameterName(), param.getParameterValue());
		return procedureQuery.getOutputParameterValue(outParamName);
	}

	public Object callProcAndReturnOutParam(String procedureName, String outParamName, Class outParamDataType,
			List<StoredProcedureParameter> parameterList) {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery(procedureName);
		procedureQuery.registerStoredProcedureParameter(outParamName, outParamDataType, ParameterMode.OUT);
		parameterList.forEach(param -> {
			procedureQuery.registerStoredProcedureParameter(param.getParameterName(), param.getClassType(), param.getMode());
			procedureQuery.setParameter(param.getParameterName(), param.getParameterValue());
		});
		return procedureQuery.getOutputParameterValue(outParamName);
	}

	// This is a generic method which will be called for all procedures, just keep
	// in mind that all procedures should have "insp_cursor" as cursor

	public List<?> callProcAndReturnList(String procedureName, Class procedureModel,
			List<StoredProcedureParameter> parameterList) {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery(procedureName, procedureModel);
		procedureQuery.registerStoredProcedureParameter("insp_cursor", void.class, ParameterMode.REF_CURSOR);
		parameterList.forEach(param -> {
			procedureQuery.registerStoredProcedureParameter(param.getParameterName(), param.getClassType(), param.getMode());
			procedureQuery.setParameter(param.getParameterName(), param.getParameterValue());
		});
		return procedureQuery.getResultList();
	}

	public List<?> callProcAndReturnList(String procedureName, Class procedureModel, StoredProcedureParameter param) {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery(procedureName, procedureModel);
		procedureQuery.registerStoredProcedureParameter("insp_cursor", void.class, ParameterMode.REF_CURSOR);
		procedureQuery.registerStoredProcedureParameter(param.getParameterName(), param.getClassType(), param.getMode());
		procedureQuery.setParameter(param.getParameterName(), param.getParameterValue());
		return procedureQuery.getResultList();
	}

	public void callProcedureWithNoReturnValue(String procedureName, StoredProcedureParameter param) {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery(procedureName);
		procedureQuery.registerStoredProcedureParameter(param.getParameterName(), param.getClassType(), param.getMode());
		procedureQuery.setParameter(param.getParameterName(), param.getParameterValue());
		procedureQuery.execute();
	}

	public void callProcedureWithNoReturnValue(String procedureName, List<StoredProcedureParameter> parameterList) {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery(procedureName);
		parameterList.forEach(param -> {
			procedureQuery.registerStoredProcedureParameter(param.getParameterName(), param.getClassType(), param.getMode());
			procedureQuery.setParameter(param.getParameterName(), param.getParameterValue());
		});
		procedureQuery.execute();
	}

}

package com.iocl.dhruva2api.service.catraining;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.catraining.CATrainingInputDataDAO;
import com.iocl.dhruva2api.model.catraining.CATrainingInputData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CATrainingInputDataService
 */
@Service
public class CATrainingInputDataService {

    @Autowired
    private CATrainingInputDataDAO caTrainingInputDataDAO;

    public ArrayList<CATrainingInputData> saveCaData(ArrayList<CATrainingInputData> entity) {
        return (ArrayList<CATrainingInputData>) caTrainingInputDataDAO.saveAll(entity);
    }
}
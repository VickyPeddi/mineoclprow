package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.ArchetypeWiseActivityDao;
import com.iocl.dhruva2api.model.activity.MstArchetypeWiseActivity;
import com.iocl.dhruva2api.model.activity.MstFacilityWiseActivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ArcheTypeWiseActivityService
 */
@Service
public class ArcheTypeWiseActivityService {

    @Autowired
    private ArchetypeWiseActivityDao archetypeWiseDao;

    @Autowired
    private MstFacilityWiseActivityService facilityWiseActivityService;

    public ArrayList<Integer> getActivityNos(String archetypeCode, boolean isBrandedFuel, boolean isAttainer,
            boolean isSks, boolean isKSK) {
        ArrayList<Integer> activityNos = new ArrayList<>();
        ArrayList<String> archetypes = new ArrayList<>();
        ArrayList<String> parameterList = new ArrayList<>();
        archetypes.add("*");
        archetypes.add(archetypeCode);

        for (MstArchetypeWiseActivity item : archetypeWiseDao.getActivityNoByArchetypeCodeIn(archetypes)) {
            activityNos.add(item.getActivityNo());
        }

        if (isBrandedFuel) {
            parameterList.add("BF");
        }
        if (isAttainer) {
            parameterList.add("AT");
        }
        if (isSks) {
            parameterList.add("SK");
        }
        if (isKSK) {
            parameterList.add("KS");
        }
        for (MstFacilityWiseActivity item : facilityWiseActivityService.getActivityNoByParameterNameIn(parameterList)) {
            activityNos.add(item.getActivityNo());
        }
        return activityNos;
    }

}
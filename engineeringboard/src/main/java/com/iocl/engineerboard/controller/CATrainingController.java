package com.iocl.dhruva2api.controller;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.catraining.CATrainingInputData;
import com.iocl.dhruva2api.payload.ApiResponse;
import com.iocl.dhruva2api.service.catraining.CATrainingInputDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * CATrainingController
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200","https://uat.indianoil.co.in","https://spandan.indianoil.co.in"  })

@RequestMapping("/ca-training")
public class CATrainingController {

    @Autowired
    private CATrainingInputDataService caTrainingInputDataService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> saveCADatas(@RequestBody ArrayList<CATrainingInputData> entity) {
        if (caTrainingInputDataService.saveCaData(entity).size() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "CA training details capture successful"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "CA training details capture failed"));
        }
    }

}
package com.iocl.dhruva2api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iocl.dhruva2api.model.TelecallCadenceData;

public interface TelecallCadenceDao extends JpaRepository<TelecallCadenceData, String> {

}

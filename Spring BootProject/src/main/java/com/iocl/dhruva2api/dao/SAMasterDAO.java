/**
 * 
 */
package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.SAMaster;

/**
 * @author 00511172
 *
 */
public interface SAMasterDAO extends CrudRepository<SAMaster, String> {

	public ArrayList<SAMaster> getSAMasterBySalesOff(String salesOff);

}

package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.DhruvaCustomerDAO;
import com.iocl.dhruva2api.model.DhruvaCustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DhruvaCustomerService
 */
@Service
public class DhruvaCustomerService {

	@Autowired
	public DhruvaCustomerDAO customerDAO;

	public ArrayList<DhruvaCustomer> getDhruvaCustomersBySalesArea(String salesAreaCode) {
		return customerDAO.getDhruvaMasterBySalesAreaCodeOrderByRoCode(salesAreaCode);
	}

	public ArrayList<Integer> getRoCodesBySalesArea(String salesAreaCode) {
		return customerDAO.getRoCodeBySalesAreaCodeOrderByRoCode(salesAreaCode);
	}

	public ArrayList<DhruvaCustomer> getDhruvaMasterByDoCode(int divOffCode) {
		return customerDAO.getDhruvaMasterByDoCodeOrderByRoCode(divOffCode);
	}

	public ArrayList<DhruvaCustomer> getDhruvaMasterBySoCode(int stateOffCode) {
		return customerDAO.getDhruvaMasterBySoCodeOrderByRoCode(stateOffCode);
	}

	public ArrayList<DhruvaCustomer> findAll() {
		return customerDAO.findAllByOrderByRoCode();
	}

	public ArrayList<DhruvaCustomer> getDhruvaMasterByRegion(String firstCharacterOfSoCode) {
		return customerDAO.getDhruvaMasterByFirstCharacterOfSoCode(firstCharacterOfSoCode);
	}

	public ArrayList<Integer> getDistinctArchetype() {
		return customerDAO.findDistinctArchetypeCode();
	}

	public ArrayList<Integer> getRoCodesByDoCode(int locationCode) {
		return customerDAO.findRoCodeByDoCodeOrderByRoCode(locationCode);
	}

	public ArrayList<Integer> getRoCodesBySoCode(int soCode) {
		return customerDAO.findRoCodeBySoCodeOrderByRoCode(soCode);
	}

	public ArrayList<Integer> getRoCodesByRegion(String firstCharacterOfSoCode) {
		return customerDAO.getRoCodeByFirstCharacterOfSoCode(firstCharacterOfSoCode);
	}

	public ArrayList<Integer> findRoCode() {
		return customerDAO.findRoCode();
	}

	public DhruvaCustomer getDhruvaCustomer(int roCode) {
		return customerDAO.findById(roCode).orElse(new DhruvaCustomer());
	}

	public ArrayList<DhruvaCustomer> findRcaCustomers() {
		return customerDAO.findRcaCustomers();
	}

}
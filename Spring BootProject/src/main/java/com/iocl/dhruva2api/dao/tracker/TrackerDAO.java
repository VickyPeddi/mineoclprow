package com.iocl.dhruva2api.dao.tracker;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.tracker.TrackerROMaster;

import org.springframework.data.repository.CrudRepository;

public interface TrackerDAO extends CrudRepository<TrackerROMaster, Long> {

	ArrayList<TrackerROMaster> findTrackerROMasterBySalesArea(String salesArea);

	ArrayList<TrackerROMaster> findTrackerROMasterBySalesOff(int salesOff);

	ArrayList<TrackerROMaster> findTrackerROMasterBySalesOrg(int salesOrg);
}

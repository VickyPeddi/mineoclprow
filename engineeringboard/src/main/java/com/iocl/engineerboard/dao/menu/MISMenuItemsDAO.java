package com.iocl.dhruva2api.dao.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.MISMenuItems;

import org.springframework.data.repository.CrudRepository;

/**
 * MISMenuItemsDAO
 */
public interface MISMenuItemsDAO extends CrudRepository<MISMenuItems, Long> {

	public MISMenuItems findByActiveFlagAndRepId(short activeFlag, long repId);

	ArrayList<MISMenuItems> findByTabIdAndFoAccessAndActiveFlagOrderByRepId(long tabId, short flag, short flag2);

	ArrayList<MISMenuItems> findByTabIdAndAdminAccessAndActiveFlagOrderByRepId(long tabId, short flag, short flag2);

	ArrayList<MISMenuItems> findByTabIdAndSrhAccessAndActiveFlagOrderByRepId(long tabId, short flag, short flag2);

	ArrayList<MISMenuItems> findByTabIdAndDrsmAccessAndActiveFlagOrderByRepId(long tabId, short flag, short flag2);

	ArrayList<MISMenuItems> findByTabIdAndHoAccessAndActiveFlagOrderByRepId(long tabId, short flag, short flag2);

	ArrayList<MISMenuItems> findByTabIdAndRoAccessAndActiveFlagOrderByRepId(long tabId, short flag, short flag2);

	ArrayList<MISMenuItems> findByTabIdAndSoAccessAndActiveFlagOrderByRepId(long tabId, short flag, short flag2);

	ArrayList<MISMenuItems> findByTabIdAndDoAccessAndActiveFlagOrderByRepId(long tabId, short flag, short flag2);

}
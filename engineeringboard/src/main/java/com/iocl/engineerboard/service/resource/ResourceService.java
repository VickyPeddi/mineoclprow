package com.iocl.dhruva2api.service.resource;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.resource.DhruvaResourceCategoryDAO;
import com.iocl.dhruva2api.dao.resource.DhruvaResourceFileDAO;
import com.iocl.dhruva2api.model.resource.DhruvaResourceCategory;
import com.iocl.dhruva2api.model.resource.DhruvaResourceFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ResourceService
 */
@Service
public class ResourceService {

	@Autowired
	private DhruvaResourceCategoryDAO resourceCategoryDAO;

	@Autowired
	private DhruvaResourceFileDAO resourceFileDAO;

	public ArrayList<DhruvaResourceCategory> getDhruvaResourceCategories() {
		return resourceCategoryDAO.findAllByActiveFlagByOrderByCategoryId('1');
	}

	public byte[] getDhruvaResourceFile(long resourceId) {
		// return resourceFileDAO.findByResourceIdAndActiveFlag(resourceId, '1');
		return resourceFileDAO.findResourceFile(resourceId, '1');
	}

}
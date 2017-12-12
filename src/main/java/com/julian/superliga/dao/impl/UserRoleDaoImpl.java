package com.julian.superliga.dao.impl;

import java.util.List;

import com.julian.superliga.dao.inter.UserRoleDao;
import com.julian.superliga.model.UserRole;

public class UserRoleDaoImpl extends AbstractDao<Long, UserRole> implements UserRoleDao {

	@Override
	public UserRole findById(Long id) {
		return super.findObjectById(id);
	}

	@Override
	public List<UserRole> findAll() {
		return super.findAllObjects();
	}

}

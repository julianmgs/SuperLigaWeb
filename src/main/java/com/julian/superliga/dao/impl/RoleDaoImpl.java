package com.julian.superliga.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.julian.superliga.dao.inter.RoleDao;
import com.julian.superliga.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Serializable, Role> implements RoleDao {

	@Override
	public Role findById(Long id) {
		return super.findObjectById(id);
	}

	@Override
	public List<Role> findAll() {
		return super.findAllObjects();
	}

}

package com.julian.superliga.dao.inter;

import java.util.List;

import com.julian.superliga.model.Role;

public interface RoleDao {

	Role findById(Long id);

	List<Role> findAll();
}

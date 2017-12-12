package com.julian.superliga.dao.inter;

import java.util.List;

import com.julian.superliga.model.UserRole;

public interface UserRoleDao {

	UserRole findById(Long id);

	List<UserRole> findAll();
}

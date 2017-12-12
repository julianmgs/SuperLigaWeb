package com.julian.superliga.dao.inter;

import com.julian.superliga.model.User;

public interface UserDao {

	User findByUserName(String username);

	void save(User user);
}

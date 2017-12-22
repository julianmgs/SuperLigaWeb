package com.julian.superliga.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.dao.inter.RoleDao;
import com.julian.superliga.dao.inter.UserDao;
import com.julian.superliga.model.Role;
import com.julian.superliga.model.User;
import com.julian.superliga.model.UserRole;
import com.julian.superliga.service.inter.UserService;
import com.julian.superliga.utils.Constants;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService, UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		User user = userDao.findByUserName(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Usuario " + username + " no encontrado.");
		}
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());

		return buildUserForAuthentication(user, authorities);
	}

	@Override
	public void saveNewUser(User user) {
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role role = roleDao.findById(Constants.ROLE_TO);
		UserRole ur = new UserRole(user, role);
		Set<UserRole> uRoles = new HashSet<UserRole>(0);
		uRoles.add(ur);
		user.setUserRoles(uRoles);

		userDao.save(user);
	}

	// Converts User user to
	// org.springframework.security.core.userdetails.User
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(
			User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				user.isEnabled(),
				true,
				true,
				true,
				authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}

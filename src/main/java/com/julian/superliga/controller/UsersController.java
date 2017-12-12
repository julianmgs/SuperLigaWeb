package com.julian.superliga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.julian.superliga.model.User;
import com.julian.superliga.service.inter.UserService;

@Controller
public class UsersController {

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/users/new" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {

		model.addAttribute("user", new User());

		return "users/new-user";
	}

	@RequestMapping(value = { "/users/save" }, method = RequestMethod.POST)
	public String saveUser(ModelMap model,
			@ModelAttribute("user") User user,
			BindingResult result) {

		userService.saveNewUser(user);

		return "redirect:/index";
	}

}

package com.check.v3.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.check.v3.domain.User;
import com.check.v3.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="/users/new",method=RequestMethod.GET)
	public String newUser(Model model)
	{
		model.addAttribute("user", new User());
		return "users/new";
	}
	@RequestMapping(value="/users",method = RequestMethod.POST)
	public String create(
			@ModelAttribute User user,
			Model model) {
		System.out.println(user.getName().toString());
		userService.save(user);
		return "redirect:users/show";
	}

}

package com.check.v3.rest.controller;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.check.v3.dto.SessionDTO;
import com.check.v3.dto.UserPasswordDTO;


@Controller
public class SessionsRestController {
	
	@RequestMapping(value = "/api/v1/sessions/create", method = RequestMethod.POST)
	@ResponseBody
	public SessionDTO create(@Valid @RequestBody UserPasswordDTO userPassword)
	{
		UsernamePasswordToken token = new UsernamePasswordToken(userPassword.getName(), userPassword.getPassword());
		Subject currentUser = SecurityUtils.getSubject();
		
		currentUser.login(token);
		currentUser.getSession().getId();
		return new SessionDTO(currentUser.getSession().getId().toString());
	}
	
}

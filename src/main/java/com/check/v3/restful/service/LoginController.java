package com.check.v3.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.check.v3.domain.User;
import com.check.v3.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	//TODO::通过添加配置让spring mvc识别json请求。
	//TODO::入参支持json数据
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User login()
	{
		return null;
	}

}

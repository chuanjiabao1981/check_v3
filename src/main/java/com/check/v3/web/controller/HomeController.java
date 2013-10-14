package com.check.v3.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.check.v3.repository.UserRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserRepository userRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest httpServletRequest,Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		for (String i: httpServletRequest.getParameterMap().keySet()){
			logger.info(i);
		}
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		Subject subject = SecurityUtils.getSubject();
		logger.info(SecurityUtils.getSubject().getSession().getId().toString());
		logger.info(subject.getPrincipal().toString());
		logger.info(String.valueOf(userRepository.findByAccount("test") == null));
		return "home";
	}
	
}

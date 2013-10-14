package com.check.v3.tools;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.check.v3.domain.User;
import com.check.v3.service.UserService;

public class UserTool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("application-context.xml");
		ctx.refresh();
		
		UserService 					    userService 			= (UserService) 		ctx.getBean("userService");
		DefaultWebSecurityManager			securityManager			=  (DefaultWebSecurityManager) ctx.getBean("securityManager");
		/*
		 *  由于AbstractShiroFilter默认不会设置SecurityMananger给当前线程，每次请求来才设置。(staticSecurityManagerEnabled)
		 *  且ShiroFilterFactoryBean也没有接口设置staticSecurityManagerEnabled，所以在非请求模式下，只能手动设置securityManager了。
		 */
		SecurityUtils.setSecurityManager((org.apache.shiro.mgt.SecurityManager) securityManager);
		User		user		= new User();
		user.setAccount("test");
		user.setPassword("12345");
		userService.save(user);
		ctx.close();
	}

}

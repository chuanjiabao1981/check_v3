package com.check.v3.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.check.v3.domain.User;
import com.check.v3.service.UserService;

public class CheckRealm extends AuthorizingRealm{
	private static final Logger Logger = LoggerFactory.getLogger(CheckRealm.class);

	@Autowired
	UserService userService;
	
	public CheckRealm()
	{
		this.setCredentialsMatcher(new PasswordMatcher());
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException 
	{
        UsernamePasswordToken upToken 	= (UsernamePasswordToken) token;
        String account 					= upToken.getUsername();
        User   user 					= userService.findByAccount(account);
        
        if (user != null ){
        	Logger.info(account);
        	Logger.info(String.valueOf(upToken.getPassword()));
        	return new SimpleAuthenticationInfo(user,user.getPassword_cryp().toCharArray(),account);
        }
		return null;
	}
	
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

}

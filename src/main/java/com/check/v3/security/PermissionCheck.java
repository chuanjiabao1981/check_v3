package com.check.v3.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class PermissionCheck {
	private static final Logger logger = LoggerFactory.getLogger(PermissionCheck.class);

    @Around("execution(* com.check.v3.web.controller.HomeController.home(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    	
        Object result = joinPoint.proceed();
        return result;
//        return "redirect:" + "http://www.baidu.com";
    }
}

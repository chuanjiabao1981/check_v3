package com.check.v3.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserPasswordDTO implements Serializable
{
	private static final long serialVersionUID = -5153172561781323374L;

	@NotEmpty
	@Size(min=4, max=20)
	String name;
	
	@NotEmpty
	String password;
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

package com.check.v3.dto;

import java.io.Serializable;

public class FieldErrorDTO implements Serializable{
	
	private static final long serialVersionUID = -7176313927481280858L;
	private String field;
	private String message;
	
	
	public FieldErrorDTO(String field,String message)
	{
		this.field  		= field;
		this.message		= message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setMessage(String message) {
		this.message = message;
	}	

}

package com.check.v3.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorsDTO implements Serializable{
	
	private static final long serialVersionUID = -3100656665600367544L;
	private List<FieldErrorDTO> errors = new ArrayList<FieldErrorDTO>();
	
	public void addFieldError(String path,String message)
	{
		FieldErrorDTO fieldError = new FieldErrorDTO(path,message);
		errors.add(fieldError);
	}

	public List<FieldErrorDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldErrorDTO> errors) {
		this.errors = errors;
	}

	
	
	
	
}

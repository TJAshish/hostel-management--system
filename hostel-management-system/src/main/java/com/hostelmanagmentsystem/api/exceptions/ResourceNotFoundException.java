package com.hostelmanagmentsystem.api.exceptions;

import lombok.Getter; 
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	String resourceName;
	String FieldName;
	Integer fieldValue;
	Long fieldValuel;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Integer id) {
		super(String.format("%s not found with %s : %i",resourceName,fieldName,id));
		this.resourceName = resourceName;
		FieldName = fieldName;
		this.fieldValue = id;
	}
	public ResourceNotFoundException(String resourceName, String fieldName, Long id) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,id));
		this.resourceName = resourceName;
		FieldName = fieldName;
		this.fieldValuel = id;
	}
	public ResourceNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}

}


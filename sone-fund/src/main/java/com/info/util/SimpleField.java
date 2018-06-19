package com.info.util;

import org.springframework.validation.FieldError;

/**
 * 构建验证字段简易描述信息
 * @author v-dongdm
 *
 */
public class SimpleField {
	
	private String filed;
	
	private String message;
	
	public SimpleField() {}
	
	public SimpleField(String field, String message) {
		this.filed = field;
		this.message = message;
	}
	
	public SimpleField(FieldError fieldError) {
		if(null != fieldError) {
			this.filed = fieldError.getField();
			this.message = fieldError.getDefaultMessage();
		}
	}
	
	public String getFiled() {
		return filed;
	}
	
	public void setFiled(String filed) {
		this.filed = filed;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

package com.swjtu.roadCheck.web.exception.base;

/**
 * 
 * <p>Title: CustomException</p>
 * <p>Description: 系统自定义异常类型，实际开发中可能要定义多种异常类型</p>
 */
public class CustomException extends RuntimeException {

	//异常信息
	private String message;

	public CustomException(){}

	public CustomException(String message){
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}

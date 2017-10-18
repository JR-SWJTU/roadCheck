package com.swjtu.roadCheck.web.exception.base;


public class ServletRequestBindingException extends CustomException {
    public ServletRequestBindingException(){

    }
    public ServletRequestBindingException(String message){
        super(message);
    }
}

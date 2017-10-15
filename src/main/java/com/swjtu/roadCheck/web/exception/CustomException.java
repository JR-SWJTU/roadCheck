package com.swjtu.roadCheck.web.exception;

/**
 * Created by Administrator on 2017/10/15.
 */
public class CustomException extends Exception{

    //异常信息
    private String message;

    public CustomException(String message)
    {
        super(message);
        this.message=message;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

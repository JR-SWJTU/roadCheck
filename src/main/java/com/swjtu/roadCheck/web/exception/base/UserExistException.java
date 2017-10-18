package com.swjtu.roadCheck.web.exception.base;

/**
 * Created by PC on 2017/7/27.
 */
public class UserExistException extends CustomException {
    public UserExistException() {
    }

    public UserExistException(String message) {
        super(message);
    }
}

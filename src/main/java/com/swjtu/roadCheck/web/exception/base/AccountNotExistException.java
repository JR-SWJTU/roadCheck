package com.swjtu.roadCheck.web.exception.base;

/**
 * Created by PC on 2017/7/27.
 */
public class AccountNotExistException extends CustomException {

    public AccountNotExistException(String message) {
        super(message);
    }
    public AccountNotExistException() { }
}

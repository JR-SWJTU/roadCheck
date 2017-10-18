package com.swjtu.roadCheck.web.exception.base;

/**
 * Created by PC on 2017/7/27.
 */
public class NotAuthException extends CustomException {
    public NotAuthException() {
    }

    public NotAuthException(String message) {
        super(message);
    }
}

package com.swjtu.roadCheck.web.exception;

import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.enums.StatusCode;
import com.swjtu.roadCheck.web.exception.base.*;
import com.swjtu.roadCheck.web.exception.base.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/10/15.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = AccountNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JsonResult handUserNotFountException(AccountNotExistException e) {
        return JsonResult.build(StatusCode.FAIL_ACCOUNT_NOT_EXIST);
    }

    @ExceptionHandler(value = NotAuthException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JsonResult handNotAuthException(NotAuthException e) {
        return JsonResult.build(StatusCode.FAIL_NOT_AUTH);
    }

    @ExceptionHandler(value = PasswdIncorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JsonResult handPasswdIncorException(PasswdIncorException e) {
        return JsonResult.build(StatusCode.FAIL_PASSWD_INCOR);
    }

    @ExceptionHandler(value = PicValiIncorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JsonResult handPicValiIncorException(PicValiIncorException e) {
        return JsonResult.build(StatusCode.FAIL_PIC_VALI_INCOR);
    }

    @ExceptionHandler(value = ReqParmIncorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handReqParmIncorException(ReqParmIncorException e) {
        return JsonResult.build(StatusCode.FAIL_REQ_PRAM_INCOR);
    }

    @ExceptionHandler(value = ServerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handServerException(ServerException e) {

        return JsonResult.build(StatusCode.FAIL_SERVER_EXCEPT);
    }

    @ExceptionHandler(value = TokenInvaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handTokenInvaException(TokenInvaException e) {
        return JsonResult.build(StatusCode.FAIL_TOKEN_INVA);
    }

    @ExceptionHandler(value = UserExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handUserExistException(UserExistException e) {
        return JsonResult.build(StatusCode.FAIL_USER_EXIST);
    }

    @ExceptionHandler(value = ServletRequestBindingException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handServletRequestBindingException(ServletRequestBindingException e) {
        return JsonResult.build(StatusCode.FAIL_TOKEN_INVALID);
    }

    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handSQLException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return JsonResult.customBuild("数据库异常");
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JsonResult handCustomException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return JsonResult.customBuild(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return JsonResult.customBuild("服务器异常");
    }
}

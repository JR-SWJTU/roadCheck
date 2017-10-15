package com.swjtu.roadCheck.util.enums;

/**
 * Created by Administrator on 2017/10/15.
 */
public enum StatusCode {


    SUCCESS(200,"请求成功"),
    FAIL_REQ_PRAM_INCOR(40001,"请求参数不正确，请对照接口参数列表填写参数"),
    FAIL_NEED_PIC_VALI(40002,"需要图片验证码"),
    FAIL_PIC_VALI_INCOR(40003,"图片验证码不正确"),
    FAIL_ACCOUNT_NOT_EXIST(40101,"username is not exit"),
    FAIL_PASSWD_INCOR(40102,"passwd error"),
    FAIL_DYNA_CODE_INCOR(40103,"动态码不正确"),
    FAIL_DYNA_CODE_INVA(40104,"动态码已失效"),
    FAIL_TOKEN_INVA(40105,"token失效，需要重新登录"),
    FAIL_USER_EXIST(40106,"用户已经存在"),
    FAIL_RES_NOT_FOUND(40107,"结果未找到"),
    FAIL_NOT_AUTH(40301,"没有权限修改该用户信息"),
    FAIL_REQU_MANY_BORBID(40302,"请求次数过多，被禁⽌"),
    FAIL_SERVER_EXCEPT(50000,"服务器异常，联系账号网关系统管理员"),
    FAIL_USERNAME_INVALID(40304,"账号必须在6到10位之间"),
    FAIL_TOKEN_INVALID(40303,"没有登录"),
    FAIL_DATA_EXIT(40305,"数据已经存在！");



    private int code;
    private String message;

    StatusCode(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

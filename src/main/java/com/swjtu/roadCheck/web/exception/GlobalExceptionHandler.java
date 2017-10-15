package com.swjtu.roadCheck.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/10/15.
 */

@ControllerAdvice
public class GlobalExceptionHandler implements HandlerExceptionResolver{

    //前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
    //handler最终要执行的Handler，它的真实身份是HandlerMethod
    //Exception ex就是接收到异常信息
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //输出异常
        ex.printStackTrace();

        //统一异常处理代码
        //针对系统自定义的CustomException异常，就可以直接从异常类中获取异常信息，将异常处理在错误页面展示
        //异常信息
        String message = null;
        CustomException customException = null;
        //如果ex是系统 自定义的异常，直接取出异常信息
        if(ex instanceof CustomException){
            customException = (CustomException)ex;
        }else{
            //针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”

            customException = new CustomException("未知错误");
        }

        //错误 信息
        message = customException.getMessage();

        request.setAttribute("message", message);
        request.setAttribute("code", 400004);
        return new ModelAndView();
    }
}

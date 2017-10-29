package com.swjtu.roadCheck.util;

import javax.servlet.http.HttpServletRequest;


import org.springframework.util.StringUtils;

public class RequestUtil {
    /**
     * 获取IP地址
     * @paramr req
     * @return String IP地址
     */
    public static String getIP(HttpServletRequest request) {
          String ip = "";
          ip = request.getHeader("Cdn-Src-Ip");
          if(StringUtils.isEmpty(ip)||ip.equalsIgnoreCase("unknown")){
          ip = request.getHeader("X-Forwared-For");
          if(StringUtils.isEmpty(ip)||ip.equalsIgnoreCase("unknown")){
                        ip = request.getHeader("X-Real-IP");
                        if("unknown".equalsIgnoreCase(ip)){
                            return  request.getRemoteAddr();
                        }else{
                            return ip;
                        }
          }else{
              return ip;
          }
          }else{
              return ip;
          }
    }
} 

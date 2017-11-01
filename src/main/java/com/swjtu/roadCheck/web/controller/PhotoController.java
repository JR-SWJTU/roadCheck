package com.swjtu.roadCheck.web.controller;


import com.swjtu.roadCheck.util.JsonResult;
import com.swjtu.roadCheck.util.PhotoUtil;
import com.swjtu.roadCheck.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user on 2017/8/3.
 */
@Controller
@RequestMapping("api/v1/videos")
@ResponseBody
public class PhotoController {

    private final String route = "http://172.18.99.253:8080/roadCheck/";

    /**
     * 图片上传
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public JsonResult activityPhotoUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session){

        System.out.println("文件上传开始");
        String picUrl = "";
        response.setContentType("text/html;charset=UTF-8");
        if(request instanceof MultipartHttpServletRequest) {
            picUrl = null;
            try {
                picUrl = PhotoUtil.photoUpload(request, response)[0];
            } catch (IOException e) {
                e.printStackTrace();
                return JsonResult.build(StatusCode.FAIL_SERVER_EXCEPT);
            }
        }else{
            return JsonResult.build(StatusCode.FAIL_REQ_PRAM_INCOR);
        }

//        String ip = PhotoUtil.getServerIp();
//        System.out.println(ip);
        return JsonResult.ok(route + picUrl);
    }
}

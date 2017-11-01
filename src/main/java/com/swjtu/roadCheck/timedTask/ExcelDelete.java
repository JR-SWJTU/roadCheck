package com.swjtu.roadCheck.timedTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/1.
 */
public class ExcelDelete {

    private static  final String rootPath = "E:\\roadCheck\\";

    private static Logger _log = LoggerFactory.getLogger(ExcelDelete.class);

    //定时任务
    public void execute() throws Exception{

        //File既可以代表文件也可以代表目录
        File temp = new File(rootPath);
        //如果目录不存在
        if (temp.exists()) {

        }

        System.out.println("定时任务执行了");

        _log.info("定时任务删除excel文件夹: " + new Date());
    }

}


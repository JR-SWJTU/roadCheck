package com.swjtu.roadCheck.util;

import com.swjtu.roadCheck.web.exception.base.CustomException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by windows on 2017/10/21.
 */
 public final class ExportExcel {

    private static  final String rootPath = ConfigUtil.excelSavedPos;

    /***
     * 构造方法
     */
    private ExportExcel() {

    }

    /***
     * 工作簿
     */
    private static HSSFWorkbook workbook;

    /***
     * sheet
     */
    private static HSSFSheet sheet;
    /***
     * 标题行开始位置
     */
    private static final int TITLE_START_POSITION = 0;

//    /***
//     * 表头行开始位置
//     */
    private static final int HEAD_START_POSITION = 1;

    /***
     * 文本行开始位置
     */
    private static final int CONTENT_START_POSITION = 2;


    /**
     *
     * @param dataList
     *        对象集合
     * @param titleMap
     *        表头信息（对象属性名称->要显示的标题值)[按顺序添加]
     * @param sheetName
     *        sheet名称和表头值
     */
    public static String excelExport(List<?> dataList, Map<String, String> titleMap, String sheetName) throws CustomException {
        // 初始化workbook
        initHSSFWorkbook(sheetName);
//        // 标题行
//        createTitleRow(titleMap, sheetName);
//        // 时间行
//        createDateHeadRow(titleMap);
        // 表头行
        createHeadRow(titleMap,0);
        // 文本行
        createContentRow(dataList, titleMap,0);
        //设置自动伸缩
        //autoSizeColumn(titleMap.size());
        // 写入处理结果
        try {
            //File既可以代表文件也可以代表目录
            File temp = new File(rootPath);
            //如果目录不存在
            if (!temp.exists()) {
                //创建目录
                temp.mkdirs();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
            Date date = new Date( System.currentTimeMillis());
            String fileName = sdf.format(date).toString()+ "黑点分析数据.xls";
            String filedisplay = rootPath + fileName;
            //如果web项目，1、设置下载框的弹出（设置response相关参数)；2、通过httpservletresponse.getOutputStream()获取
            OutputStream out = new FileOutputStream(filedisplay);
            workbook.write(out);
            out.close();

            return fileName;
        }
        catch (Exception e) {
            throw new CustomException("导出失败");
        }
    }

    public static String excelExport2(List<?> dataList, Map<String, String> resultMap, Map<String, Object> conditionMap, Map<String, String> titleMap, String sheetName, HttpServletResponse res) throws CustomException {
        // 初始化workbook
        initHSSFWorkbook(sheetName);
        // 标题行
        createTitleRow("查询条件",0);
        // 表头行
        createHeadRow(titleMap,0);
        // 文本行
        createConditionContentRow(conditionMap, titleMap);

       createTitleRow( "查询结果",4);
       createHeadRow(resultMap,4);
       createContentRow(dataList, resultMap,4);
        // 写入处理结果
        try {
            //File既可以代表文件也可以代表目录
            File temp = new File(rootPath);
            //如果目录不存在
            if (!temp.exists()) {
                //创建目录
                temp.mkdirs();
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
            Date date = new Date( System.currentTimeMillis());
            String fileName = sdf.format(date).toString()+ "空间分析数据.xls";
            String filedisplay = rootPath + fileName;
            //如果web项目，1、设置下载框的弹出（设置response相关参数)；2、通过httpservletresponse.getOutputStream()获取
            OutputStream out = new FileOutputStream(filedisplay);
            workbook.write(out);
            out.close();
            return fileName;

//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            workbook.write(os);
//            byte[] content = os.toByteArray();
//            InputStream is = new ByteArrayInputStream(content);
//            // 设置response参数，可以打开下载页面
//            res.reset();
//            res.setContentType("application/vnd.ms-excel;charset=utf-8");
//            res.setHeader("Content-Disposition", "attachment;filename=空间数据导出.xls" );
//            ServletOutputStream out = res.getOutputStream();
//            BufferedInputStream bis = null;
//            BufferedOutputStream bos = null;
//            try {
//                bis = new BufferedInputStream(is);
//                bos = new BufferedOutputStream(out);
//                byte[] buff = new byte[2048];
//                int bytesRead;
//                // Simple read/write loop.
//                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                    bos.write(buff, 0, bytesRead);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (bis != null) bis.close();
//                if (bos != null) bos.close();
//            }

//            res.reset();
//            res.setContentType("application/vnd.ms-excel;charset=utf-8");
//            res.setHeader("Content-Disposition", "attachment;filename=" +
//                    URLEncoder.encode(filedisplay, "UTF-8"));
//            res.addHeader("Pargam", "no-cache");
//            res.addHeader("Cache-Control", "no-cache");
//
//            OutputStream  output = res.getOutputStream();
//            workbook.write(output);
//            output.flush();
//            output.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("导出失败");
        }
    }

    /***
     *
     * @param sheetName
     *        sheetName
     */
    private static void initHSSFWorkbook(String sheetName) {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
    }

    /**
     * 生成标题（第零行创建）
     * @param titleName sheet名称
     */
    private static void createTitleRow(String titleName,int i) {
        //CellRangeAddress titleRange = new CellRangeAddress(0, 0, 0, titleMap.size() - 1);
        //sheet.addMergedRegion(titleRange);
        HSSFRow titleRow = sheet.createRow(TITLE_START_POSITION+i);
        HSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(titleName);
    }

    /**
     * 创建时间行（第一行创建）
     * @param titleMap 对象属性名称->表头显示名称
     */
//    private static void createDateHeadRow(Map<String, String> titleMap) {
//        CellRangeAddress dateRange = new CellRangeAddress(1, 1, 0, titleMap.size() - 1);
//        sheet.addMergedRegion(dateRange);
//        HSSFRow dateRow = sheet.createRow(DATEHEAD_START_POSITION);
//        HSSFCell dateCell = dateRow.createCell(0);
//        dateCell.setCellValue(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
//    }

    /**
     * 创建表头行（第二行创建）
     * @param titleMap 对象属性名称->表头显示名称
     */
    private static void createHeadRow(Map<String, String> titleMap,int s) {
        // 第1行创建
        HSSFRow headRow = sheet.createRow(HEAD_START_POSITION+s);
        int i = 0;
        for (String entry : titleMap.keySet()) {
            HSSFCell headCell = headRow.createCell(i);
            headCell.setCellValue(titleMap.get(entry));
            i++;
        }
    }

    /**
     *
     * @param dataList 对象数据集合
     * @param titleMap 表头信息
     */
    private static void createContentRow(List<?> dataList, Map<String, String> titleMap,int s) {
        try {
            int i=s;
            for (Object obj : dataList) {
                HSSFRow textRow = sheet.createRow(CONTENT_START_POSITION + i);
                int j = 0;
                for (String entry : titleMap.keySet()) {
                    String method = "get" + entry.substring(0, 1).toUpperCase() + entry.substring(1);
                    Method m = obj.getClass().getMethod(method, null);
                    Object o =   m.invoke(obj, null);
                    String value = "";
                    if(o == null){
                        value = "未知";
                    }else{
                        value = o.toString();
                    }
                    HSSFCell textcell = textRow.createCell(j);
                    textcell.setCellValue(value);
                    j++;
                }
                i++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createConditionContentRow(Map<String, Object> conditionMap, Map<String, String> titleMap) {
        try {
                HSSFRow textRow = sheet.createRow(CONTENT_START_POSITION);
                int j = 0;
                for (String key : titleMap.keySet()) {
                    String value="";
                    if(key.equals("teamName")){
                        String[] teams = (String[])conditionMap.get(key);
                        StringBuilder sb = new StringBuilder();
                        for(String s : teams){
                            sb.append(s+" ");
                        }
                        value = sb.toString().trim();
                    }else if(key.equals("isWorkDay")){
                        Integer isWorkday = (Integer)conditionMap.get(key);
                        if(isWorkday == 1){
                            value = "是";
                        }else{
                            value = "否";
                        }

                    }else if(key.equals("yType")){
                        Boolean b = (Boolean)conditionMap.get(key);
                        if(b){
                            value="以事故数为纵轴";
                        }else{
                            value = "以事故严重程度为纵轴";
                        }
                    }else {
                        value = conditionMap.get(key).toString();
                    }
                    HSSFCell textcell = textRow.createCell(j);
                    textcell.setCellValue(value);
                    j++;
                }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 自动伸缩列（如非必要，请勿打开此方法，耗内存）
     * @param size 列数
     */
    private static void autoSizeColumn(Integer size) {
        for (int j = 0; j < size; j++) {
            sheet.autoSizeColumn(j);
        }
    }

}

package com.swjtu.roadCheck.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Map;
import java.util.UUID;

public class PhotoUtil {

    //图片的文件存储目录
    public static String savePath = "";

    /**
     * 表单图片上传到服务器，位置在seewo-bbs/images目录下
     * @param
     * @param request
     * @param response
     * @return  图片在项目目录下的位置,为空则证明没有文件
     * @throws IOException
     */
    public static String[] photoUpload( HttpServletRequest request, HttpServletResponse response) throws IOException {

        //内部不包含文件，则返回
        if(! (request instanceof MultipartHttpServletRequest)){
            return null;
        }

        //提出request中的文件对象
        Map<String, MultipartFile> fileMap = ((MultipartHttpServletRequest) request).getFileMap();

        //初始化存储的文件名数组
        String picUrl[] = new String[fileMap.entrySet().size()];
        //消息提示
        String message = "";

        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = request.getSession().getServletContext().getRealPath("");
        PhotoUtil.savePath = savePath;

        int i = 0 ;
        for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
            MultipartFile item = entry.getValue();
            //得到上传的文件名称，
            String filename = item.getOriginalFilename();
            System.out.println(filename);
            if (filename == null || filename.trim().equals("")) {
                continue;
            }
            //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
            //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
            filename = filename.substring(filename.lastIndexOf("\\") + 1);
            //得到上传文件的扩展名
            String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
            //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
            System.out.println("上传的文件的扩展名是：" + fileExtName);
            //判断文件类型
            if (!(fileExtName.length() != 0 && ("MP4".equals(fileExtName.toUpperCase()) || "JPG".equals(fileExtName.toUpperCase())))) {
                message = "文件类型不符合";
                return picUrl;
            }
            //为防止文件覆盖的现象发生，为上传文件产生一个唯一的文件名
            String saveFilename = makeFileName(filename);
            System.out.println(saveFilename);
            //为防止一个目录下面出现太多文件，要使用hash算法打散存储,得到文件的保存目录
            String docPos = makePath(saveFilename);
            //拼接路径形成图片的绝对路径
            String realSavePath = savePath + "\\" +"images" + docPos +  "\\" + saveFilename;
            //File既可以代表文件也可以代表目录
            File temp = new File(realSavePath);
            //如果目录不存在
            if (!temp.exists()) {
                //创建目录
                temp.mkdirs();
            }
            System.out.println("文件绝对路径:"+ realSavePath);
            item.transferTo(new File(realSavePath));
            //拼接形成文件的相对路径，即文件在项目中的位置
            picUrl[i] = "images" + docPos +  "\\" + saveFilename;
            message = "文件上传成功！";
        }
        System.out.println(message);
        return picUrl;
    }

    /**
     * @param filename 文件的原始名称
     * @return uuid+"_"+文件的原始名称
     * @Method: makeFileName
     * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
     */
    private static String makeFileName(String filename) {  //2.jpg
        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
    }

    /**
     * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
     * @param filename 文件名，要根据文件名生成存储目录
     * @return 新的存储目录
     * @Method: makePath
     * @Description:
     */
    private static String makePath(String filename) {
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = filename.hashCode();
        int dir1 = hashcode & 0xf;  //0--15
        int dir2 = (hashcode & 0xf0) >> 4;  //0-15
        //构造新的保存目录
        String dir = "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        return dir;
    }

    public static String savePathchange(String path){

        return path;
    }

    public static String  getServerIp(){
        String SERVER_IP = "";
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces
                        .nextElement();
                ip = (InetAddress) ni.getInetAddresses().nextElement();
                SERVER_IP = ip.getHostAddress();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {
                    SERVER_IP = ip.getHostAddress();
                    break;
                } else {
                    ip = null;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return SERVER_IP;
    }
}

package com.baizhi.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/kindeditor")
public class KindeditorController {

    @RequestMapping("/uploadImage")
    public Map<String, Object> upload(HttpServletRequest request, MultipartFile img) throws Exception {

        //穿件集合
        HashMap<String, Object> map = new HashMap<>();
        //创建上传文件夹
        String realPath = request.getSession().getServletContext().getRealPath("/upload/img");
        //获取文件对象
        File file = new File(realPath);
        //判断文件夹是否存在
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFilename = img.getOriginalFilename();
        String imgstrtime = new Date().getTime() + "_" + originalFilename;
        //可以试试用Buffer字节流读取一下，封装一下transferTo这个方法
        img.transferTo(new File(realPath, imgstrtime));
        //获取文件大小
        long length = file.length();

        // uploadJson
        /*http://kindeditor.net/ke4/php/upload_json.php?dir=image
         * //kindeditor页面响应Response的值，一个Json串
         * {"error":0,"url":"http://localhost/8787/cmfz/upload/img/xxx"}
         *
         *
         *
         * */
        //把图片响应到服务器
        map.put("error", 0);
        //设置路径
        // 静态： map.put("url","http://localhost/8787/cmfz/upload/img/"+s);
        //需要动态获取
        //获取服务器的请求地址url
        String scheme = request.getScheme(); //http  scheme:"http"
        InetAddress localHost = InetAddress.getLocalHost();//获取去主机IP地址 localhost:"HIAPAD-2019H31G/172.16.13.2"
        String slocalHost = localHost.toString(); //转换成字符串
        String splitLocalHost = slocalHost.split("/")[1];
        int serverPort = request.getServerPort();//获取端口号  serverPort:8787
        String contextPath = request.getContextPath();//获取请求路径，项目的相对路径contextPath:"/cmfz"
        String url = scheme + "://" + splitLocalHost + ":" + serverPort + contextPath + "/upload/img/" + imgstrtime;
        map.put("url", url); // 获取到的是
        return map;
    }

    /*

        "moveup_dir_path": "",
        "current_dir_path": "",
        "current_url": "\/ke4\/php\/..\/attached\/",
        "total_count": 5,
        "file_list":
    * [{"is_dir": false,
        "has_file": false,
        "filesize": 26094,
        "dir_path": "",
        "is_photo": true,
        "filetype": "jpg",
        "filename": "W020091124524510014093.jpg",
        "datetime": "2018-06-06 00:36:39"
    *
    *
    * */
    //所有网络图片回显,思路，map集合形式返回，里边存储的固定的key-String；value-ArrayList(图片信息)
    //ArrayList中存储的还是一个map1集合（key1，value）
    @RequestMapping("/getAll")
    public Map<String, Object> getAll(HttpServletRequest request) throws Exception {

        HashMap<String, Object> map = new HashMap<>();
       String realPath = request.getSession().getServletContext().getRealPath("/upload/img");
        File file = new File(realPath);
        List listArray = new ArrayList();//新建集合不知道干什么用
        String[] imgs = file.list(); //说去文件夹下的所有图片

        for (String img : imgs) {
            Map<String, Object> map1 = new HashMap<>();
            File imgfile = new File(file, img); //获取图片对象
            long imglength = imgfile.length();//获取图片的大小
            String extension = FilenameUtils.getExtension(img); //获取图片的拓展名
            //思路把之前存的时间戳，读取出来-转字符串-转long类型-秒-时间格式
            String s = img.split("_")[0];//获取—前面的时间戳
            long lt = new Long(s);//字符串转换成Long类型的包装类
            Date date = new Date(lt);//把long类型转换成时间类型
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //创建格式化对象
            String imgformat = simpleDateFormat.format(date);//调用格式化方法-时间格式化
            map1.put("is_dir", false);
            map1.put("has_file", false);
            map1.put("filesize", imglength);
            map1.put("dir_path", false);
            map1.put("is_photo", true);
            map1.put("filetype", extension);
            map1.put("filename", img);
            map1.put("datetime", imgformat);
            listArray.add(map1);
        }

        String scheme = request.getScheme();//http  scheme:"http"
        InetAddress localHost = InetAddress.getLocalHost();//获取去主机IP地址 localhost:"HIAPAD-2019H31G/172.16.13.2"
        String slocalHost = localHost.toString(); //转换成字符串
        String splitLocalHost = slocalHost.split("/")[1];
        int serverPort = request.getServerPort();//获取端口号  serverPort:9999
        String contextPath = request.getContextPath();//获取请求路径，项目的相对路径contextPath:"/cmfz"
        String url = scheme + "://" + splitLocalHost + ":" + serverPort + contextPath + "/upload/img/";
        long total=imgs.length; //图片数量

        //获取图片响应的url
        map.put("file_list", listArray); //查询本都图片文件夹所有图片
        map.put("moveup_dir_path", "");
        map.put("current_dir_path", realPath);
        map.put("current_url",url);
        map.put("total_count",total);
        return map;
    }


    @RequestMapping("/addKindeditor")
    public void addKindeditor(String content) {
        //指定响应的编码
        System.out.println(content);
    }

}

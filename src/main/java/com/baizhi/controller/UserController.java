package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {

        return "";
    }

    @RequestMapping("/getUserByPager")
    public Map<String, Object> getUserByPager(Integer page, Integer rows) {
        Map<String, Object> map = userService.queryAllUser(page, rows);
        return map;
    }

    @RequestMapping("/easyPoiOut")
    public void easyPoiOut(HttpSession session, HttpServletResponse response) throws Exception {
        //丛本地磁盘读取  图片
        String realPath = session.getServletContext().getRealPath("/upload/img/");
        //获取后台数据
        List<User> list = userService.getAll();
        //获取 照片的路径
        for (User user : list) {
            user.setHeadPic(realPath + user.getHeadPic());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("150班学生信息表", "学生信息表"), User.class, list);
        String encode= URLEncoder.encode("150.xls","UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + encode);
        workbook.write(response.getOutputStream());
    }
}

package com.baizhi.controller;

import com.baizhi.util.ValidateImageCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/iemageCode")
public class ImageCodeController {
    @RequestMapping("/getCode")
    public void getImageCode(HttpSession session, HttpServletResponse response){
        //1生成4位验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //2生成图片，把验证码放到图片里
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //3写出图片输出流
        ServletOutputStream outputStream=null;
        try {
            outputStream=response.getOutputStream();

            ImageIO.write(image,"png",outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //验证码传到session中，后台验证
        session.setAttribute("securityCode",securityCode);


    }

}

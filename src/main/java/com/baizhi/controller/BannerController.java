package com.baizhi.controller;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannnerService;
    @RequestMapping("queryByPager")
    public Map<String, Object> queryByPager(Integer page,Integer rows){
        Map<String, Object> map= bannnerService.selectAllBanner(page, rows);
        return map;
    }
}

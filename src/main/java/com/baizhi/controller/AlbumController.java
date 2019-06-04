package com.baizhi.controller;


import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/getAlbumByPager")
    public Map<String,Object> getAlbumByPager(Integer page, Integer rows) {

        Map<String, Object> map = albumService.selectByPrimaryKey(page, rows);
        return map;
    }
}

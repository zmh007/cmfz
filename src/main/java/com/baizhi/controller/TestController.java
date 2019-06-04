package com.baizhi.controller;

import com.baizhi.entity.Album;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/first_page")
    public Map<String, List<Object>> first(String all, String wen, String si, String ssyj, String xmfy) {
        Map<String, List<Object>> map = new HashMap<String, List<Object>>();
        if (all == null && wen == null && si == null) {
            return null;
        } else {
            if (all != null) {
                List<Object> banners = new ArrayList<Object>(); //轮播图集合
                List<Object> albums = new ArrayList<Object>();//专辑集合
                List<Object> articles = new ArrayList<Object>();//文章集合
                //添加到map轮播图集合
                map.put("banner", banners);
                map.put("album", albums);
                map.put(" article", articles);
                return map;
            } else if (wen != null) {
                List<Object> albums = new ArrayList<Object>();//专辑集合
                map.put("album", albums);
                return map;
            } else if (si != null) {
                if (ssyj != null) {
                    List<Object> articles = new ArrayList<Object>();//文章集合
                    map.put(" article", null);
                    return map;
                } else if (xmfy != null) {
                    List<Object> chapter = new ArrayList<Object>();//所有文章结合
                    map.put("xmfy", chapter);
                    return map;
                }
            }
        }
        return null;
    }

    @RequestMapping("/album")
    public Object selectAlbum(String albumId) {
        Album album = new Album();
        return album;
    }


}
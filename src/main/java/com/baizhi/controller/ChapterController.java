package com.baizhi.controller;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/getChapterByPager")
    public Map<String,Object> getAlbumByPager(String albumId,Integer page, Integer rows) {
        Map<String, Object> map = chapterService.selectAllChapter(albumId ,page, rows);
        return map;
    }

}

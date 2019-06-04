package com.baizhi.service;
import java.util.Map;

public interface ChapterService {
    //查询所有
    public Map<String,Object> selectAllChapter(String albumId ,Integer page, Integer totil);

}

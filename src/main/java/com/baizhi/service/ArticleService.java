package com.baizhi.service;
import java.util.Map;

public interface ArticleService {
    //查询所有
    public Map<String,Object> selectAllArticle(Integer page, Integer total);
}

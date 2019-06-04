package com.baizhi.controller;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @RequestMapping("getAllArticle")
    public Map<String, Object> getAllArticle(Integer page,Integer rows){
        Map<String, Object> map= articleService.selectAllArticle(page,rows);
        return map;
    }
    @RequestMapping("/edit")
    public void edit(Article article){
        System.out.println(article);


    }
}

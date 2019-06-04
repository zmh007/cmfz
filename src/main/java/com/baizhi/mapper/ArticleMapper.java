package com.baizhi.mapper;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    //查询所有
    List<Article> selectAllArticle(@Param("page") Integer page, @Param("rows") Integer rows);
    //统计总条数
    Integer selectCount();
    //添加文章
    void insertOne(Article article);


//    int deleteByPrimaryKey(String id);
//
//    int insert(Article record);
//
//    int insertSelective(Article record);
//
//    int updateByPrimaryKeySelective(Article record);
//
//    int updateByPrimaryKeyWithBLOBs(Article record);
//
//    int updateByPrimaryKey(Article record);
}
package com.baizhi.mapper;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ChapterMapper {
    List<Chapter> selectAllChapter(@Param("albumId")String albumId,@Param("start") Integer start,@Param("rows") Integer rows  );
    Integer selectCount(String albumId);

//    int deleteByPrimaryKey(String id);
//
//    int insert(Chapter record);
//
//    int insertSelective(Chapter record);
//
//    int updateByPrimaryKeySelective(Chapter record);
//
//    int updateByPrimaryKey(Chapter record);
}
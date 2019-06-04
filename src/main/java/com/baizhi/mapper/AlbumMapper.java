package com.baizhi.mapper;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {

    List<Album> selectByPrimaryKey(@Param("page")Integer page, @Param("rows")Integer rows);
    Integer selectCount();

//    int deleteByPrimaryKey(String id);
//
//    int insert(Album record);
//
//    int insertSelective(Album record);
//
//    int updateByPrimaryKeySelective(Album record);
//
//    int updateByPrimaryKey(Album record);
}
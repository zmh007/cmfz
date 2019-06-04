package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    //查询所有
    public List<Banner> selectAllBanner(@Param("start")Integer start,@Param("rows")Integer rows);
    //查询总条数分页使用
    public Integer selectCount();

//    int deleteByPrimaryKey(String id);
//
//    int insert(Banner record);
//
//    int insertSelective(Banner record);
//
//    Banner selectByPrimaryKey(String id);
//
//    int updateByPrimaryKeySelective(Banner record);
//
//    int updateByPrimaryKey(Banner record);
}
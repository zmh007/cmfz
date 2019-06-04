package com.baizhi.service;
import java.util.Map;

public interface AlbumService {
    //查询所有
    public Map<String,Object> selectByPrimaryKey(Integer page, Integer rows);
}

package com.baizhi.service;
import java.util.Map;
public interface BannerService  {
    //查询所有
    public Map<String,Object> selectAllBanner (Integer page, Integer totil);
}

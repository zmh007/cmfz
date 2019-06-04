package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {
    public User queryOneUser(String name,String Password);
    public Map<String,Object> queryAllUser(Integer page, Integer rows);
    //查询所有，用于到处excel
    public List<User> getAll();
}

package com.baizhi.mapper;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface UserMapper {
    //用户登录
    public User queryOneUser(String name);
    //查询所有用户
    public List<User> queryAllUser(@Param("page")Integer page,@Param("rows") Integer rows);
    //统计用户数量
    public Integer selectCount();
    //查询所有，用于到处excel
    public List<User> getAll();
}

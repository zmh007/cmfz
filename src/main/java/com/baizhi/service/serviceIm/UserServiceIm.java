package com.baizhi.service.serviceIm;

import com.baizhi.mapper.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceIm implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User queryOneUser(String name, String password) {
        User user = null;
        user = userMapper.queryOneUser(name);
        if (user == null) {
            throw new RuntimeException("用户不存在！");
        } else if (user != null && !user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public Map<String, Object> queryAllUser(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        Integer start = (page - 1) * rows;
        List<User> users = userMapper.queryAllUser(start, rows);
        Integer count = userMapper.selectCount();
        Integer total = count % rows == 0 ? count / rows : count / rows + 1;
        map.put("page", page);
        map.put("rows", users);
        map.put("total", total);
        map.put("records", count);
        return map;
    }

    //查询所有，用于到处excel
    public List<User> getAll(){
        List list=userMapper.getAll();
        return list;
    }

}

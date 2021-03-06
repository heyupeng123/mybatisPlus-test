package com.itheima.springbootmybatisplus.service;

import com.itheima.springbootmybatisplus.entity.User;
import com.itheima.springbootmybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.selectList(null);
    }

}

package com.itheima.springbootmybatisplus.controller;

import com.itheima.springbootmybatisplus.entity.User;
import com.itheima.springbootmybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/findAll")
    public String findAll(){
        List<User> userList = userService.findAll();
        if (userList != null){
            return "查询成功,用户列表:"+userList;
        }else {
            return "查询失败！";
        }
    }

}

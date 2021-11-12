package com.itheima.springbootmybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.springbootmybatisplus.entity.User;
import com.itheima.springbootmybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setName("xiaoqao");
        user.setAge(15);
        user.setEmail("qshihuan@qq.com");
        int number = userMapper.insert(user);
        System.out.println("number:"+number);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1459075023087087618L);
        user.setAge(18);
        int number = userMapper.updateById(user);
        System.out.println(number);
    }

    @Test
    public void deleteUser(){
        int i = userMapper.deleteById(1458754024131125250L);
        System.out.println(i);
    }

    @Test
    public void test(){
        User user = userMapper.selectById(1458966073087934466L);
        user.setAge(99);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    /**
     * 根据多个id查询用户信息
     */
    @Test
    public void findBatchIds(){
        List list = new ArrayList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
//        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        List users = userMapper.selectBatchIds(list);
        System.out.println(users);
    }

    @Test
    public void testFindPage(){
        Page<User> page = new Page<User>(1,3);
        userMapper.selectPage(page,null);
    }
}

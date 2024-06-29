
package com.cqdx.springbootdemo2.controller;

import com.cqdx.springbootdemo2.entity.User;
import com.cqdx.springbootdemo2.mapper.UserMapper;
import com.cqdx.springbootdemo2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @GetMapping("/user/add")
    public String add() {
        User user = new User();
        user.setUsername("admin");
        user.setNickname("管理员");
        user.setPassword("123456");
        userService.save(user);
        return "添加成功";
    }

    @GetMapping("/user/getall")
    public List<User> getAll() {
        return userService.list();
    }
}

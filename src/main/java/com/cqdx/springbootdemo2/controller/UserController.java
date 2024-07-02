
package com.cqdx.springbootdemo2.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cqdx.springbootdemo2.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cqdx.springbootdemo2.entity.User;
import com.cqdx.springbootdemo2.mapper.UserMapper;
import com.cqdx.springbootdemo2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/user/findall")
    public List<User> findAll() {
        return userMapper.selectList(null);
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

    @GetMapping ("/user/index")
    public String index(Model model)
    {
        List<User> list=userService.list();
        model.addAttribute("userList",list);
        return "index";

    }

    //删除用户
    @RequestMapping("/user/delete")
    public String delete(int id) {
        userService.removeById(id);
        return "redirect:/user/index";
    }



    @GetMapping("/user/login")
    public String showLoginForm() {
        // 显示登录表单
        return "login";
    }
    @PostMapping("/user/getlogin")
    public ResponseEntity<String> handleLogin(@RequestParam int id, @RequestParam String password) {
        // 这里简化处理，仅检查用户名和密码非空即视为登录成功
        if(userService.getById(id) != null &&userService.getById(id).getPassword().equals(password) ){
            return ResponseEntity.ok("Login successful");// 如果需要，可以返回错误信息
        }
        else{
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }









}

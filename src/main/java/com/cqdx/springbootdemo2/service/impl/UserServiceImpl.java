package com.cqdx.springbootdemo2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.springbootdemo2.entity.User;
import com.cqdx.springbootdemo2.mapper.UserMapper;
import com.cqdx.springbootdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

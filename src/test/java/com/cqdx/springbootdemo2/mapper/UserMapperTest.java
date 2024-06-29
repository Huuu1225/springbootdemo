package com.cqdx.springbootdemo2.mapper;

import com.cqdx.springbootdemo2.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper usermapper;
    @Test
    public void getListTest(){
        List<User> user=usermapper.selectList(null);
        user.forEach(System.out::println);
    }
}

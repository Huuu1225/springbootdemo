package com.cqdx.springbootdemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqdx.springbootdemo2.mapper")
public class SpringBootdemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootdemo2Application.class, args);
    }

}

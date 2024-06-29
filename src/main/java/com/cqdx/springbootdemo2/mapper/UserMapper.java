package com.cqdx.springbootdemo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqdx.springbootdemo2.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user")
    List<User> selectAll();
}
package com.example.demo.dao;

import com.example.demo.entity.Manage;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ManageDao {

    @Select(value = "SELECT * FROM manage")
    List<Manage> getAllManage();
}

package com.example.demo.dao;

import com.example.demo.entity.Regist;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RegistDao {

    @Select(value = "SELECT * FROM regist")
    List<Regist> getAllRegist();


    @Insert(value = "INSERT INTO regist(regist.`username`,regist.`password`,regist.`name`,regist.`sex`,regist.birthday,regist.number,regist.`units`)\n"
            + "VALUE(#{username},#{password},#{name},#{sex},#{birthday},#{number},#{units})")
    int insert(Regist regist);
    @Delete(value= "DELETE FROM regist WHERE regist.username=#{username}")
    int delete(String username);
}
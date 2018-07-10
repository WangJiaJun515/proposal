package com.example.demo.dao;

import com.example.demo.entity.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface MemberDao {

    @Select(value = "SELECT * FROM member")
    List<Member> getAllMember();


    @Insert(value = "INSERT INTO Member(Member.username,Member.password,Member.`name`,Member.`sex`,Member.birthday,Member.number,Member.`units`)\n"
            + "VALUE(#{username},#{password},#{name},#{sex},#{birthday},#{number},#{units})")
    int insert(Member member);

    @Update(value = "UPDATE member SET member.password = #{password} , member.name = #{name} , member.sex = #{sex} , member.birthday = #{birthday} , member.number = #{number} , member.units = #{units} WHERE member.username = #{username}")
    int update(@Param("username") String username,
               @Param("password") String password,
               @Param("name") String name,
               @Param("sex") String sex,
               @Param("birthday") String birthday,
               @Param("number") String number,
               @Param("units") String units  );


}
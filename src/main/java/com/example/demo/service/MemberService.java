package com.example.demo.service;

import com.example.demo.entity.Member;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface MemberService {

    List<Member> getAllMember();

    boolean insert(Member member);

    boolean juggIndex(Member member, HttpServletRequest request);
    boolean update(@Param("username") String username,
               @Param("password") String password,
               @Param("name") String name,
               @Param("sex") String sex,
               @Param("birthday") String birthday,
                   @Param("number") String number,
               @Param("units") String units  );
}
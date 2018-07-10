package com.example.demo.service;

import com.example.demo.entity.Manage;
import com.example.demo.entity.Member;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ManageService {

    List<Manage> getAllManage();


    boolean juggIndex(Member member, HttpServletRequest request);
}
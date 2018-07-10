package com.example.demo.service;

import com.example.demo.entity.Regist;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface RegistService {

    List<Regist> getAllRegist();

    boolean insert(Regist regist);
    boolean delete(String username);
}

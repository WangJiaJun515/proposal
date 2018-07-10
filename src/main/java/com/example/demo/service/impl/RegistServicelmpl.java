package com.example.demo.service.impl;

import com.example.demo.dao.RegistDao;
import com.example.demo.entity.Regist;
import com.example.demo.service.RegistService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

import java.util.List;


@Service
public class RegistServicelmpl implements RegistService {

    @Autowired
    private RegistDao registDao;

    public List<Regist> getAllRegist() {
        return registDao.getAllRegist();
    }


    public boolean insert(Regist regist) {
        if (null == regist) {
            return false;
        }
        // do something...
        registDao.insert(regist);
        return true;
    }
    public boolean delete(String username) {
        if (null == username) {
            return false;
        }
        // do something...
        registDao.delete(username);
        return true;
    }
}
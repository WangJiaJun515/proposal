package com.example.demo.service.impl;

import com.example.demo.dao.ManageDao;
import com.example.demo.entity.Manage;
import com.example.demo.service.ManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import com.example.demo.entity.Member;
import java.util.List;


@Service
public class ManageServicelmpl implements ManageService {

    @Autowired
    private ManageDao manageDao;

    public List<Manage> getAllManage() {
        return manageDao.getAllManage();
    }


    public boolean juggIndex(Member member, HttpServletRequest request) {
        List<Manage> managers = (List<Manage>) request.getAttribute("managers");
        boolean flag = false;

        for (Manage m : managers) {
            if ( m.getUsername() != null) {
                if (m.getUsername().equals(member.getUsername())) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag)
            return true;
        else
            return false;
    }
}
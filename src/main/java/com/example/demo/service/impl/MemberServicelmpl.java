package com.example.demo.service.impl;

import com.example.demo.dao.MemberDao;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

import java.util.List;


@Service
public class MemberServicelmpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    public List<Member> getAllMember() {
        return memberDao.getAllMember();
    }


    public boolean insert(Member member) {
        if (null == member){
            return false;
        }
        // do something...
        memberDao.insert(member);
        return true;
    }

    public boolean juggIndex(Member member, HttpServletRequest request){
        List<Member> members = (List<Member>)request.getAttribute("members");
        boolean flag = false;
        //System.out.println(member.getUsername());
        for (Member m: members)
        {
          //  System.out.println(m.getUsername()+ m.getPassword());
            if (m.getPassword()!=null && m.getUsername()!=null) {
                if (m.getPassword().equals(member.getPassword()) && m.getUsername().equals(member.getUsername())) {
                    System.out.println("!!!");
                    flag = true;
                    break;
                }
            }
        }

        if (flag)
            return  true;
        else
            return  false;
    }
    @Override
    public boolean update(@Param("username") String username,
                          @Param("password") String password,
                          @Param("name") String name,
                          @Param("sex") String sex,
                          @Param("birthday") String birthday,
                          @Param("number") String number,
                          @Param("units") String units ) {
        if (null == username || null == password || null == name || null == sex || null == birthday || null == number || null == units) {
            return false;
        }
        // do something...
        memberDao.update(username, password, name, sex, birthday, number, units);
        return true;
    }

}

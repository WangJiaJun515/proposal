package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.entity.Manage;
import com.example.demo.entity.Proposal;
import com.example.demo.entity.Regist;
import com.example.demo.service.MemberService;
import com.example.demo.service.ManageService;
import com.example.demo.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.service.ManageService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private ManageService manageService;
    @Autowired
    private RegistService registService;
    private List<Member> thismember = new ArrayList<Member>();
    //private List<Member> thismember1 = new ArrayList<Member>();
    private List<Regist> list2 = new ArrayList<Regist>();


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getAllMember(HttpServletRequest request,@ModelAttribute("member") Member member,Model model) {
        List<Member> list = memberService.getAllMember();
       // System.out.println(list);
        request.setAttribute("members", list);
        if (memberService.juggIndex(member, request)) {
                for (Member m:list)
                {
                    if(m.getUsername().equals(member.getUsername()))
                    {
                        System.out.println(m);
                        thismember.add(m);
                        break;
                    }
                }
           // System.out.println(thismember);
            return "main.html";
        }
        else return "indexlose.html";
    }



    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String indexb(Model model){
        model.addAttribute("member",new Member());
        return "index.html";
    }
    @RequestMapping(value = "/check",method = RequestMethod.GET)
    public String check(HttpServletRequest request,@ModelAttribute Member member,Model model)
    {
        List<Member> list=thismember;
        request.setAttribute("thismember", list);
        model.addAttribute("member",new Member());
        //System.out.println(list);
       // model.addAttribute("member",new Member());
        return "check.html";
    }


    @RequestMapping(value = "/submit1", method = RequestMethod.GET)
    public String update(@ModelAttribute("member") Member member,Model model){
        memberService.update(member.getUsername(),member.getPassword(),member.getName(),member.getSex(),member.getBirthday(),member.getNumber(),member.getUnits());
        System.out.println(member);
        return "main.html";
    }




    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String verify(HttpServletRequest request,Member member,Model model) {
        Member mem = thismember.get(thismember.size()-1);
       List<Manage> list = manageService.getAllManage();
        System.out.println(thismember);
        request.setAttribute("managers", list);
        if (manageService.juggIndex(mem, request)) {
            List<Regist> list1 = registService.getAllRegist();
            request.setAttribute("regists", list1);
            return "verify.html";
        }
        else return "noAuth.html";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model){
        model.addAttribute("member",new Member());
        thismember.clear();
        return "index.html";
    }



    @RequestMapping(value = "/prodetail1", method = RequestMethod.GET)
    public String getRegist(@RequestParam("p_id") int p_id, Model model, HttpServletRequest request) {
        List<Regist> list = registService.getAllRegist();
        // request.setAttribute("comlist", list);

        for (Regist a : list) {
            if (a.getId() == p_id) {
                list2.add(a);
                request.setAttribute("Regist", list2);
                return "verify1.html";

            }
        }
        return "verify.html";
    }

    @RequestMapping(value = "/verify2", method = RequestMethod.GET)
    public String verify2(HttpServletRequest request,Regist regist,Model model,Member member) {
        Regist reg = list2.get(list2.size()-1);
        Member m = new Member();
        m.setUsername(reg.getUsername());
        m.setPassword(reg.getPassword());
        m.setName(reg.getName());
        m.setSex(reg.getSex());
        m.setBirthday(reg.getBirthday());
        m.setNumber(reg.getNumber());
        m.setUnits(reg.getUnits());
        registService.delete(reg.getUsername());
        memberService.insert(m);
        list2.clear();
        List<Regist> list1 = registService.getAllRegist();
        request.setAttribute("regists", list1);
        return "verify.html";
    }

}
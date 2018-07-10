package com.example.demo.controller;


import com.example.demo.entity.Member;
import com.example.demo.entity.Regist;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.service.RegistService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistController {
    @Autowired
    private RegistService registService;

    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String regist(Model model){
        model.addAttribute("regist",new Regist());
        return "regist.html";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public String insert(@ModelAttribute("regsit") Regist regist, Model model){
        model.addAttribute("member",new Member());
        registService.insert(regist);
        // System.out.println(member);
        return "index.html";
    }

    @RequestMapping(value = "/backtoindex",method = RequestMethod.GET)
    public String backtoindex(Model model){
        model.addAttribute("member",new Member());
        return "index.html";
    }

    @RequestMapping(value = "/backtomain",method = RequestMethod.GET)
    public String backtomain(){
        return "main.html";
    }
}

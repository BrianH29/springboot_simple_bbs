package com.bh.bbs.controller;

import com.bh.bbs.domain.Member;
import com.bh.bbs.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class memberController {

    @Autowired
    private MemberService ms;

    public memberController(MemberService ms) {
        this.ms = ms;
    }

    @RequestMapping("loginView.me")
    public String login(){
        return "loginView";
    }

    @GetMapping("login.me")
    public String login(HttpSession session, Member member){
        Member loginUser = ms.findOne(member.getId());
        System.out.println(member);

        session.setAttribute("loginUser", loginUser);
        return "redirect:/";
    }

    @RequestMapping("enrollForm.me")
    public String enroll(){
        return "enrollFormView";
    }

    @PostMapping(value = "/enrollForm.me")
    public String insertForm(Member member){
        ms.join(member);
        return "redirect:/";
    }
}

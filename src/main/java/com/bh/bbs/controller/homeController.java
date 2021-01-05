package com.bh.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("mainPage")
    public String mainPage(){
        return "home";
    }

    @GetMapping("bbsList.bo")
    public String bbsList(){
        return "bbsListView";
    }

    @GetMapping("enrollForm.me")
    public String enrollForm(){
        return "enrollFormView";
    }
}

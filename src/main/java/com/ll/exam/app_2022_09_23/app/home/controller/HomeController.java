package com.ll.exam.app_2022_09_23.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/main")
    public String showMain() {
        return "/home/main";
    }
}
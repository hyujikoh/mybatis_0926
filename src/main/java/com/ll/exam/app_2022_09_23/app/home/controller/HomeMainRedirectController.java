package com.ll.exam.app_2022_09_23.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeMainRedirectController {
    @RequestMapping("/")
    public String redirectToMain() {
        return "redirect:/home/main";
    }
}
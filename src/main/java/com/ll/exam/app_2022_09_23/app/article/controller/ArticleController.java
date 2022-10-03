package com.ll.exam.app_2022_09_23.app.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public String showList() {
        return "article/list";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable Long id) {
        return "article/detail";
    }
}
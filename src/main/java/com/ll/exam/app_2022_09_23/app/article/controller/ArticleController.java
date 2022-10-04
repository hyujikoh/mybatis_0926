package com.ll.exam.app_2022_09_23.app.article.controller;

import com.ll.exam.app_2022_09_23.app.article.dto.Article;
import com.ll.exam.app_2022_09_23.app.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Article> articles = articleService.getForPrintArticles();
        log.debug("articles : " + articles);

        model.addAttribute("articles", articles);

        return "article/list";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable Long id) {
        return "article/detail";
    }
    @GetMapping("/write")
    public String showWrite() {
        return "article/write";
    }
}
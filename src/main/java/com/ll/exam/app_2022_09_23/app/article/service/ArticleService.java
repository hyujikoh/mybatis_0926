package com.ll.exam.app_2022_09_23.app.article.service;

import com.ll.exam.app_2022_09_23.app.article.dto.Article;
import com.ll.exam.app_2022_09_23.app.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }

    public long write(String subject, String content) {
        articleRepository.write(subject, content);

        return articleRepository.getLastInsertId();
    }

    public Article getArticleById(long id) {
        return articleRepository.getArticleById(id);
    }

    public List<Article> search(String kwType, String kw) {
        return articleRepository.search(kwType, kw);
    }
}

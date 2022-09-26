package com.ll.exam.app_2022_09_23;

import com.ll.exam.app_2022_09_23.app.article.dto.Article;
import com.ll.exam.app_2022_09_23.app.article.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AppTest {
    @Autowired
    private ArticleService articleService;

    @Test
    @DisplayName("게시물들 조회")
    void t1() {
        List<Article> articles = articleService.getArticles();
        assertThat(articles.size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("게시물 단건 조회")
    void t3() {
        Article article = articleService.getArticleById(2L);
        assertThat(article).isNotNull();
    }


    @Test
    @DisplayName("게시물 제목 검색")
    void t4() {
        List<Article> articles = articleService.search("subject", "1");
        assertThat(articles.size()).isEqualTo(1);

        articles = articleService.search("subject", "제목");
        assertThat(articles.size()).isEqualTo(2);

        articles = articleService.search("subject", "2");
        assertThat(articles.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("게시물 작성")
    void t2() {
        long id = articleService.write("제목3", "내용3");

        assertThat(id).isGreaterThan(0);
    }
}

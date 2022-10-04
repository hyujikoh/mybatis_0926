package com.ll.exam.app_2022_09_23.app.article.dto;

import lombok.Data;

@Data
public class Article {
    private long id;
    private String subject;
    private String content;
    private long memberId;
}

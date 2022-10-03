package com.ll.exam.app_2022_09_23.app.base.rq;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@ApplicationScope// 스프링부트 앱 당 1개
@SessionScope//브라우저 당 1개
public class Rq {
    @Getter
    private int count;

    @Getter
    @Setter
    private String name;
    public void increaseCount() {
        count++;
    }
}
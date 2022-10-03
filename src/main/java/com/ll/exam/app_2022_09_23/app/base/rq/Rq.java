package com.ll.exam.app_2022_09_23.app.base.rq;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Rq {
    @Getter
    private int count;

    public void increaseCount() {
        count++;
    }
}
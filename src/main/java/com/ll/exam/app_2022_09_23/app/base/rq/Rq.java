package com.ll.exam.app_2022_09_23.app.base.rq;

import com.ll.exam.app_2022_09_23.app.member.dto.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
//@ApplicationScope// 스프링부트 앱 당 1개
//@SessionScope//브라우저 당 1개
@RequestScope// 요청할때 마다 수행
@RequiredArgsConstructor
public class Rq {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;
    private final HttpSession session;

    @Getter
    private String alertMsg;

    public String getCurrentUrl() {
        String url = req.getRequestURL().toString();
        String queryString = req.getQueryString();

        if (queryString != null && queryString.length() > 0) {
            url += "?" + queryString;
        }

        return url;
    }

    public boolean isLogined() {
        return getLoginedMemberId() > 0;
    }

    public boolean isLogout() {
        return isLogined() == false;
    }

    public long getLoginedMemberId() {
        Long loginedMemberId = (Long) session.getAttribute("loginedMemberId");

        if (loginedMemberId == null) return 0;

        return loginedMemberId;
    }

    public String getLoginedMemberUsername() {
        return (String) session.getAttribute("loginedMemberUsername");
    }

    public String getLoginedMemberName() {
        return (String) session.getAttribute("loginedMemberName");
    }

    public String getLoginedMemberEmail() {
        return (String) session.getAttribute("loginedMemberEmail");
    }

    public Member getLoginedMember() {
        long id = getLoginedMemberId();
        String username = getLoginedMemberUsername();
        String name = getLoginedMemberName();
        String email = getLoginedMemberEmail();

        return Member
                .builder()
                .id(id)
                .username(username)
                .name(name)
                .email(email)
                .build();
    }

    public void setLoginDone(Member member) {
        session.setAttribute("loginedMemberId", member.getId());
        session.setAttribute("loginedMemberUsername", member.getUsername());
        session.setAttribute("loginedMemberName", member.getName());
        session.setAttribute("loginedMemberEmail", member.getEmail());
    }

    public void setLogoutDone() {
        session.removeAttribute("loginedMemberId");
        session.removeAttribute("loginedMemberUsername");
        session.removeAttribute("loginedMemberName");
        session.removeAttribute("loginedMemberEmail");
    }

    public String historyBackTemplate(String msg) {
        alertMsg = msg;

        return "common/js";
    }
}
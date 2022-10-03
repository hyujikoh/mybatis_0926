package com.ll.exam.app_2022_09_23.app.member.service;

import com.ll.exam.app_2022_09_23.app.member.dto.Member;
import com.ll.exam.app_2022_09_23.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMemberByUsername(String username) {
        return memberRepository.getMemberByUsername(username);
    }
}
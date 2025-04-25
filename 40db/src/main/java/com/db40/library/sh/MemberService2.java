package com.db40.library.sh;

import org.springframework.security.crypto.password.PasswordEncoder; // 임포트 변경
import org.springframework.stereotype.Service;

import com.db40.library.member.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService2 {

    private final Member2Repository memberRepository;
    private final PasswordEncoder passwordEncoder; // PasswordEncoder 주입

    public Member create(String memberId, String email, String password) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setEmail(email);
        // 주입받은 passwordEncoder 사용
        member.setMemberPass(passwordEncoder.encode(password));
        this.memberRepository.save(member);
        return member;
    }
}
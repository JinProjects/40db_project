package com.db40.library.sh;

import org.springframework.security.crypto.password.PasswordEncoder; // 임포트 변경
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder; // PasswordEncoder 주입

    public Member create(String memberId, String email, String password) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setEmail(email);
        // 주입받은 passwordEncoder 사용
        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member);
        return member;
    }
}
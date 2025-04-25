package com.db40.library.sh;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User; // UserDetails 구현체 변경
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException; // UsernameNotFoundException 사용
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        try {
            Optional<Member> member = this.memberRepository.findByMemberId(memberId);
            if (member.isEmpty()) {
                throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
            }
            Member _member = member.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            if ("admin".equals(_member.getMemberId())) {
                authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
            } else {
                authorities.add(new SimpleGrantedAuthority(MemberRole.MEMBER.getValue()));
            }
            return new User(_member.getMemberId(), _member.getPassword(), authorities);
        } catch (Exception e) {
            // 예외 발생 시 로그 출력
            e.printStackTrace();
            throw new UsernameNotFoundException("사용자 인증 중 오류가 발생했습니다.");
        }
    }
}
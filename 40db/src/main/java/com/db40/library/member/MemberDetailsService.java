package com.db40.library.member;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberDetailsService implements UserDetailsService{

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		 Member member = memberRepository.findByMemberId(memberId).orElseThrow(()-> 
		 					new UsernameNotFoundException("memberId를 찾을 수 없습니다"+memberId));
		 Set<GrantedAuthority> authorities = member.getMemberRole().stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName())) // Role 엔티티의 이름(예: "ROLE_ADMIN") 사용
	                .collect(Collectors.toSet());
		return new User(member.getMemberId(),member.getMemberPass());
	}
	
}

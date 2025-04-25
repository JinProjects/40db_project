package com.db40.library.member;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service  //##1
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository   memberRepository;
	private final PasswordEncoder    passwordEncoder;  // SecurityConfig
	private final MemberStatusRepository memberStatusRepository;
	
	//insert
	public Member insertMember(Member member) {
		try {
			member.setJoinIp(InetAddress.getLocalHost().getHostAddress());
			member.setMemberStatus(memberStatusRepository.findById(1).get());
			member.setMemberPass(passwordEncoder.encode( member.getMemberPass()  ));
		} catch (UnknownHostException e) { e.printStackTrace();}
		return memberRepository.save(member);
	}
	
	// 실명과 휴대폰 번호로 id찾기
	public Long forFindId(String name, String mobile) {
		Long findid = memberRepository.findIdByRealNameAndMobile(name, mobile);
		return findid;
	}
	// 아이디 실명 휴대폰 번호로 id찾기
	public Long forFindPass(String id, String name, String mobile) {
		Long findid = memberRepository.findIdByMemberIdNameAndMobile(id, name, mobile);
		return findid;
	}
	// id로 비밀번호 변경하기
	public void updatePass(Long id, String pass) {
		pass = passwordEncoder.encode(pass);
		memberRepository.updatePasswordById(id, pass);
	}
	
	//selectAll
	public List<Member> selectMemberAll(){  
		return memberRepository.findAll();
	}
	
	//select
	public Member selectMember(Long id) {  
		return memberRepository.findById(id).get();
	}
	 
	//update / updatePass
	public int updateByPass( Member member, String old  ) {
		return memberRepository.updateByIdAndPassword(
					member.getMemberPass(), old, member.getId()
			   ); 
	}
	public Member updateByEmail(Member member) {
		Member find = memberRepository.findById(member.getId()).get();
		find.setEmail(member.getEmail());
		return memberRepository.save(find);
	} 
	//delete
	public void deleteMember(Long id) {
		Member find = memberRepository.findById(id).get();
		memberRepository.delete(find);
	}
	
	
	// 중복체크
	// 아이디
	public Member selectUserMemberId(String memberId) {
		return memberRepository.findByMemberId(memberId).get();
	}
	
	// 이메일
	public Member selectUserEmail(String email) {
		return memberRepository.findByEmail(email).get();
	}
	
	// displayName 가져오기 
	public String selectdisplayNameByMemberId(String memberId) {
		return memberRepository.findByMemberId(memberId).map(Member::getDisplayName).orElse("");
	}
	
	
}

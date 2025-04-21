package com.db40.library.member;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@Autowired MemberService service;
	@Autowired KaKaoLogin kakao;
	@Autowired NaverLogin naver;

	/* 기본 회원가입 페이지 */
	@GetMapping("/member/join")
	public String join(MemberForm memberForm) {	
		return "member/join"; }
	
	/* 기본 회원가입 기능 */
	@PostMapping("/member/join")
	public String join(@Valid MemberForm memberForm , BindingResult bindingResult) {  
		
		if(bindingResult.hasErrors()) { return "member/join"; }
		if( !memberForm.getMemberPass().equals(  memberForm.getPassword2()) ) {
			//bindingResult.rejectValue(필드명 , 오류코드, 에러메시지)
			bindingResult.rejectValue("password2", "pawordInCorrect","패스워드를 확인해주세요");
			return "member/join"; 
		} 
		
		try {
			Member  member = new Member();
			member.setMemberId(memberForm.getMemberId());
			member.setMemberPass(memberForm.getMemberPass());
			member.setEmail(memberForm.getEmail());
			member.setBirthDate(memberForm.getBirthDate());
			member.setAddressPost(memberForm.getAddressPost());
			member.setAddressJibun(memberForm.getAddressJibun());
			member.setAddressRoad(memberForm.getAddressRoad());
			member.setAddressDetail(memberForm.getAddressDetail());
			member.setDisplayName(memberForm.getDisplayName());
			member.setMobileNumber(memberForm.getMobileNumber());
			member.setGender(memberForm.getGender());
			member.setRealName(memberForm.getRealName());
			service.insertMember(member);
		}catch(DataIntegrityViolationException e) { // 무결성- 중복키, 외래키제약, 데이터형식불일치
			e.printStackTrace();
			bindingResult.reject("failed" , "등록된 유저입니다.");
			return "member/join"; 
		} catch(Exception e) {
			e.printStackTrace();
			bindingResult.reject("failed" , e.getMessage());
			return "member/join"; 
		}
		return "member/login"; 
	}
	
	/* 통합 회원가입 ( 일반, 카카오, 네이버 ) */
	/* 통합 회원가입 ( 일반, 카카오, 네이버 ) */
	// 통합 로그인 / 회원가입
	@GetMapping("/member/login") 
		public String identify(Model model) {
			model.addAttribute("kakao", kakao.identify());	// 카카오
			model.addAttribute("naver", naver.identify());	// 네이버
			return "member/login";
		}
	
	// localhot:8080/kakao 사용자 정보 가져오기 - 카카오
	@GetMapping("/kakao")
	public String  kakaouser(@RequestParam("code") String code, Model model) {
		List<String>  infos = kakao.identified(code);
		model.addAttribute("nickname"  , infos.get(0));  
		model.addAttribute("profile_image"  , infos.get(1));
		
		MemberForm memberForm = new MemberForm();
		memberForm.setDisplayName(infos.get(0)); // nickname -> displayName으로 매핑
		model.addAttribute("memberForm", memberForm);
		return "member/join";
	}
//	@GetMapping("/naver")
//	public String naveruser(@RequestParam("code") String code, Model model) {
//		List<String>  info = naver.identified(code);
//		model.addAttribute("nickname"  , info.get(0));  
//		
//		MemberForm memberForm = new MemberForm();
//		memberForm.setDisplayName(info.get(0)); // nickname -> displayName으로 매핑
//		model.addAttribute("memberForm", memberForm);
//		return "member/join";
//	}
	
	/* 통합 회원가입 ( 일반, 카카오, 네이버 ) */	

	/* 아이디 찾기 */
	/* 아이디 찾기 */
	/* 아이디 찾기 페이지 */
	@GetMapping("/member/findid")
	public String findid() { return "member/findid";}
	
	@PostMapping("/member/findid")
	public String findid(String realName, String mobileNumber, Model model) {
		Long find = service.forFindId(realName, mobileNumber);
		Member member = new Member();
		
		if (find==null) {
			model.addAttribute("error", "계정이 존재하지 않습니다");
			return "member/findid";
		}
		member = service.selectMember((long)find);
		model.addAttribute("found", member.getMemberId());
		model.addAttribute("realName", member.getRealName());
		return "member/foundid";
	}
	
	@GetMapping("/member/foundid")
	public String foundid() { return "member/foundid";}
	/* 아이디 찾기 */
	/* 아이디 찾기 */
		
	
	/* 비밀번호 찾기 */
	/* 비밀번호 찾기 */
	@GetMapping("/member/findpw")
	public String findpw() { return "member/findpw"; }
	
	@PostMapping("/member/findpw")
	public String findpw(String memberId, String realName, String mobileNumber, Model model) {
		Long findpw = service.forFindPass(memberId, realName, mobileNumber);
		System.out.println(findpw);
		if (findpw == null) {
			model.addAttribute("error", "일치하는 계정 없음");
			return "member/findpw";
		}
		model.addAttribute("success", findpw);
		return "member/foundpw";
		}
	
	@GetMapping("/member/foundpw")
	public String foundpw() { return "member/foundpw";}
	
	@PostMapping("/member/foundpw")
	public String foundpw(Long id, String memberPass) { 
		service.updatePass(id, memberPass);
		return "member/login";
	}
	/* 비밀번호 찾기 */
	/* 비밀번호 찾기 */
	
	
	/* 마이페이지 */
	@GetMapping("/member/member")
	public String member() {  return "member/member"; }
}

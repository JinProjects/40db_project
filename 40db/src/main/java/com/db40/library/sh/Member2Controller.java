package com.db40.library.sh;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Member2Controller {
	
	private final MemberService2 memberService;
	
	@GetMapping("/signup")
	public String signup(Member2CreateForm memberCreateForm) {
		return "signup_form";
	}
	
    @PostMapping("/signup")
    public String signup(@Valid Member2CreateForm memberCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!memberCreateForm.getPassword1().equals(memberCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        try {
        memberService.create(memberCreateForm.getMemberId(), 
        		memberCreateForm.getEmail(), memberCreateForm.getPassword1());} catch(DataIntegrityViolationException e) {
                    e.printStackTrace();
                    bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
                    return "signup_form";
                }catch(Exception e) {
                    e.printStackTrace();
                    bindingResult.reject("signupFailed", e.getMessage());
                    return "signup_form";
                }

        return "redirect:/";
    }
    
    
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

}

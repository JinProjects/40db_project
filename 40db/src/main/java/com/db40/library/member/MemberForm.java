package com.db40.library.member;
 
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
public class MemberForm { // memberForm	 
	//@NotEmpty(message="사용자 ID는 필수 항목입니다.")
	@Size(min=4, max=20)
	private String memberId;

	//@NotEmpty(message="비밀번호 필수 항목입니다.")
	private String memberPass;

	//@NotEmpty(message="비밀번호 확인은 항목입니다.")
	private String password2; 
	
	//@NotEmpty(message="실명은 필수 항목입니다.")
	private String realName;
	
	//@NotEmpty(message="휴대폰 번호는 필수 항목입니다.")
	private String mobileNumber;
	
	//@NotEmpty(message="이메일은 필수 항목입니다.")
	private String email;
	
	//@NotNull(message="성별")
	private char gender;
	
	//@NotNull(message="우편번호는 필수 항목입니다.")
	private String addressPost;
	
	private String addressJibun;
	
	private String addressRoad;
	
	//@NotEmpty(message="상세주소는 필수 항목입니다.")
	private String addressDetail;
	
	//@NotNull(message="생년월일은 필수 항목입니다")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	//@NotEmpty(message="별명은 필수 항목입니다.")
	private String displayName;
}

//https://beanvalidation.org/
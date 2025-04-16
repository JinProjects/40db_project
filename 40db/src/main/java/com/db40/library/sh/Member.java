package com.db40.library.sh;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity  @Getter  @Setter
public class Member {
	// DB id
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// 계정 정보
	@Column(unique=true, name="member_id", nullable=false) private String memberId; // 아이디
	
	// 사용자 정보
	@Column(name="member_email", unique=true, nullable=false) private String email; 	// 이메일

	@Column(name="member_warning", nullable=false)private Integer memberWarning = 0;										// 회원경고:0


}
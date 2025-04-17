package com.db40.library.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository  extends JpaRepository<Member, Long>{
	Optional<Member>	  findByMemberId(String memberId);
	
	@Modifying  
	@Transactional  
	@Query("update Member m set m.memberPass=:password where m.memberPass=:old  and m.id=:id")
	int updateByIdAndPassword(String password, String old, Long id);
	
	/* 사용자의 본명과 휴대폰 번호로 id찾기 */
	 @Query("select m.id from Member m where m.realName=:name and m.mobileNumber=:mobile")
	 Long findIdByRealNameAndMobile(String name, String mobile);
	 
	/* 사용자의 아이디와 본명, 휴대폰 번호로 id찾기 */
	 @Query("select m.id from Member m where m.memberId=:id and m.realName=:name and m.mobileNumber=:mobile")
	 Long findIdByMemberIdNameAndMobile(String id, String name, String mobile);
		 
	@Modifying @Transactional
	@Query("update Member m set m.memberPass=:pass where m.id=:id")
	void updatePasswordById(Long id, String pass);
		
}








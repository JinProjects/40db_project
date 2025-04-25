package com.db40.library.sh;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db40.library.member.Member;


public interface Member2Repository extends JpaRepository<Member, Long>{

	Optional<Member> findByMemberId(String memberId);

}

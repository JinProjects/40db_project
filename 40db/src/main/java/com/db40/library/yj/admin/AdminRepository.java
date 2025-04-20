package com.db40.library.yj.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db40.library.member.Member;

public interface AdminRepository extends JpaRepository<Member, Long>{

}

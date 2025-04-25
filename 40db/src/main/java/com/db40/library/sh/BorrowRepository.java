package com.db40.library.sh;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.db40.library.member.*;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

	List<Borrow> findByMemberId(Member memberId);
	List<Borrow> findByBorrowState(String string);
	

	
}

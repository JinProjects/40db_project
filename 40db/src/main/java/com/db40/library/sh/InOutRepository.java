package com.db40.library.sh;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InOutRepository extends JpaRepository<InOut, Long> {

	List<InOut> findByMemberId(Member memberId);
	List<InOut> findByBorrowState(String string);


	
}

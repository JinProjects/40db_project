package com.db40.library.sh;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import com.db40.library.member.*;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

	List<Borrow> findByMemberId(Member memberId);
	List<Borrow> findByBorrowState(String string);
=======


public interface InOutRepository extends JpaRepository<InOut, Long> {

	List<InOut> findByMemberId(Member memberId);
	List<InOut> findByBorrowState(String string);
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
	

	
}

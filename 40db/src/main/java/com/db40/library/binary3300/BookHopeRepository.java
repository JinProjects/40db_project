package com.db40.library.binary3300;

import java.util.List;
<<<<<<< HEAD
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======

>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD



public interface BookHopeRepository extends JpaRepository<BookHope,Long>{

	 //Page...
	Page<BookHope> findAll(Pageable pageable);
		
		
	@Query("select b from BookHope b order by b.bookHopeNo desc")
=======

public interface BookHopeRepository extends JpaRepository<BookHope,Long>{

	@Query("select b from BookHope b order by book_hope_no desc")
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
	List<BookHope> findAllByOrderByDesc();
	
	@Modifying 
	@Transactional 
<<<<<<< HEAD
	@Query("update BookHope b set b.book_hope_stat = :book_hope_stat    where b.bookHopeNo = :book_hope_no")
=======
	@Query("update BookHope b set b.book_hope_stat = :book_hope_stat    where b.book_hope_no = :book_hope_no")
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
	int updateByNo( String book_hope_stat, Long book_hope_no );
	
	//insert into BookHope b 
	
}
 
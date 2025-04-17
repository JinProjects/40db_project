package com.db40.library.binary3300;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookHopeRepository extends JpaRepository<BookHope,Long>{

	@Query("select b from BookHope b order by book_hope_no desc")
	List<BookHope> findAllByOrderByDesc();
	
	@Modifying 
	@Transactional 
	@Query("update BookHope b set b.book_hope_stat = :book_hope_stat    where b.book_hope_no = :book_hope_no")
	int updateByNo( String book_hope_stat, Long book_hope_no );
	
}
 
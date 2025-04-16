package com.db40.library.yj;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db40.library.sh.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{
	
}

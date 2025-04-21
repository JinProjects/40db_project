package com.db40.library.sh;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<Books, Integer> {

	Books findByBookNo(Integer bookNo);

}

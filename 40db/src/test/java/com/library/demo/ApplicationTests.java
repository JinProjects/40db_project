package com.library.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db40.library.sh.Books;
import com.db40.library.yj.AdminBooksRepository;

@SpringBootTest
class ApplicationTests {
	@Autowired
	AdminBooksRepository booksRepository;
	
	@Test
	void contextLoads() {
		Books books = new Books();
		books.setBookAuthor("홍길동");
		books.setBookCover("홍길동.jpg");
		books.setBookDescription("홍길동");
		books.setBookIsbn("123135235234");
		books.setBookPublisher("한빛");
		books.setBookTitle("홍길동");
		booksRepository.save(books);
	}

}

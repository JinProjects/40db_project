package com.library.demo;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db40.library.Application;
import com.db40.library.sh.Books;
import com.db40.library.yj.BooksRepository;

@SpringBootTest(classes = Application.class)
class ApplicationTests {
	@Autowired
	BooksRepository booksRepository;
	
	@Test
	@Ignore
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
	@Test
	public void findBookAll() {
		List<Books> bookList =  booksRepository.findAll();
		for(Books book : bookList) {
			System.out.println(book.getBookTitle());
		}
	}

}

package com.db40.library.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db40.library.binary3300.BookHope;
import com.db40.library.binary3300.BookHopeRepository;

@SpringBootTest
class ApplicationTests {
	@Autowired BookHopeRepository bookHopeRepository;
	
	@Disabled //@Test
	public void writeBookHope() {
		BookHope bookhope = new BookHope();
		bookhope.setBook_title("cool bookname");
		bookhope.setBook_isbn("987654321");
		bookhope.setBook_auther("anna caranina");
		bookhope.setBook_publisher("weLbook");
		bookhope.setBook_published_date("2025-04-18");
		bookhope.setBook_reason("this is coolest book i ever seen that even blown my grammer");
		bookhope.setBook_hope_stat("NOPE");
		bookHopeRepository.save(bookhope);
	}
	//(book_title, book_isbn, book_auther, book_publisher, book_published_date, book_reason, book_hope_stat
	//('책 제목 1', '9781234567890', '작가 1', '출판사 1', '2023-01-01', '이 책을 읽고 싶어요.', '대기중'),
	
	@Disabled //@Test 
	public void findAllBookHope() {
		List<BookHope> list = bookHopeRepository.findAll();
		System.out.println(list.get(0).getBook_title());
	}
	
	@Disabled //@Test
	public void update() {
		Optional<BookHope> findHopeBook = bookHopeRepository.findById(1L);
		if(findHopeBook.isPresent()) {
			BookHope bookhope = findHopeBook.get();
			bookhope.setBook_hope_stat("Allow");
			bookHopeRepository.save(bookhope);
		}
	}
	
	@Disabled //@Test 
	public void findByIdBookHope() {
		Optional<BookHope> findHopeBook = bookHopeRepository.findById(1L);
		if(findHopeBook.isPresent()) {
			BookHope bookhope = findHopeBook.get();
			System.out.println(bookhope.getBook_title());
		}
	}
	

}

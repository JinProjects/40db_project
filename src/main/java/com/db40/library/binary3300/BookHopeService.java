package com.db40.library.binary3300;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class BookHopeService {
	@Autowired BookHopeRepository bookHopeRepository;
	
	//전체리스트
//	public List<BookHope> findAll() {
//		return bookHopeRepository.findAllByOrderByDesc();
//	}
	
	//상세보기
	@Transactional
	public BookHope find(Long id) {
		BookHope bookhope = bookHopeRepository.findById(id).get();
		bookHopeRepository.save(bookhope);
		return bookhope;
	}
	
	//임시 작성하기 
//	public void insert(BookHope bookhope, String member_id) {
//		Member member = new Member();
//		member.setMemberId(member_id);
//		bookhope.setMember(member);
//		bookHopeRepository.save(bookhope);
//	}
	
	//코파일럿이 일러주는대로
	public BookHopeService(BookHopeRepository bookHopeRepository) {
		this.bookHopeRepository = bookHopeRepository;
	}
	
	@Transactional
	public BookHope saveBookHope(BookHope bookHope) {
		bookHope.setBook_hope_stat("NOPE");
		return bookHopeRepository.save(bookHope);
	}
	public List<BookHope> findAll(){
		return bookHopeRepository.findAll();
	}
	
	
	
}
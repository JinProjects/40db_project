package com.db40.library.binary3300;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

=======
import org.springframework.stereotype.Service;

import com.db40.library.member.Member;



>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
@Service
public class BookHopeService {
	@Autowired BookHopeRepository bookHopeRepository;
	
<<<<<<< HEAD
	//PAGING
	//PAGING
	//1: 최신글 10		order by bno desc limit 0,10	0번째부터 10개
	//2: 최신글 10		order by bno desc limit 10,10	10번째부터 10개
	public Page<BookHope> getPaging(int page){ //어디서부터  ## 이거 테스트요~
		List<Sort.Order> sort = new ArrayList<>();
		sort.add(Sort.Order.desc("bookHopeNo"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
		return bookHopeRepository.findAll(pageable);//역순 안되면 여기와서찾기
	}
	
	
	//전체리스트
	public List<BookHope> findAllByOrderByDesc() {
=======
	//전체리스트
	public List<BookHope> findAll() {
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
		return bookHopeRepository.findAllByOrderByDesc();
	}
	
	//상세보기
	@Transactional
	public BookHope find(Long id) {
		BookHope bookhope = bookHopeRepository.findById(id).get();
		bookHopeRepository.save(bookhope);
		return bookhope;
	}
	
	//임시 작성하기 
<<<<<<< HEAD
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
=======
	public void insert(BookHope bookhope, String member_id) {
		Member member = new Member();
		member.setMemberId(member_id);
		bookhope.setMember(member);
		bookHopeRepository.save(bookhope);
	}
	
	//관리자가 반려하기-등록하기 폼
	
	//관리자가 반려하기-등록하기 기능
	
	
}
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430

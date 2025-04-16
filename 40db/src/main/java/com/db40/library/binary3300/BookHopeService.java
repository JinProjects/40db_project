package com.db40.library.binary3300;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookHopeService {
	@Autowired BookHopeRepository bookHopeRepository;
	
	//전체리스트
	public List<BookHope> findAll() {
		return bookHopeRepository.findAllByOrderByDesc();
	}
	
	//상세보기
	@Transactional
	public BookHope find(Long id) {
		BookHope bookhope = bookHopeRepository.findById(id).get();
		bookHopeRepository.save(bookhope);
		return bookhope;
	}
	
	//관리자가 반려하기-등록하기 폼
	
	//관리자가 반려하기-등록하기 기능
	
	
}

package com.db40.library.binary3300;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookHopeController {
	private final BookHopeService bookHopeService;
	@Autowired BookHopeApi bookHopeApi;
	
	// 희망도서 전체리스트 메인
	@GetMapping("/hopeBook/hope_now")
	public String hope_now(Model model) {
		return "/hopeBook/hope_now";
	} // http://localhost:8080/hopeBook/hope_now

	// 희망도서 작성하기
	@GetMapping("/hopeBook/hope_insert")
	public String insert_get() {
		return "/hopeBook/write";
	} // http://localhost:8080/bookhope/hope_insert

	@PostMapping("/hopeBook/hope_insert")
	public String insert_post(BookHope bookhope) {
		return "redirect:/hopeBook/hope_now";
	} // http://localhost:8080/bookhope/hope_insert

	
	// 희망조서 내용 자세히 보기 {book_hope_no}  	@PathVariable Long id, Model model	 model.addAttribute("dto",bookHopeService.find(id) ); 
	@GetMapping("/hopeBook/hope_detail") 
	public String detail(Model model) {
		 return "/hopeBook/hope_detail"; 
	}
	
	// 검색시 타이틀로 불러옴
	@GetMapping(value="/hopeBook/hope_usersearch/{search}", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String hope_usersearch( @PathVariable String search) throws IOException {
		System.out.println("실행");
		return  bookHopeApi.getApi(search);
	}
	
//	@GetMapping(value = "/hopeBook/hope_usersearch/{search}", produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public String booksJson( @PathVariable String search ) throws IOException {
//		return bookHopeApi.getApi(search);
//	}
//	
	 
	// 희망도서 반려하기/등록하기 업데이트에서 하나로 될거같음 (이건 관리자만 쓸수있는기능)
	//book_hope_no
	
	

}

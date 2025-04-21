package com.db40.library.yj.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.db40.library.sh.Books;
import com.db40.library.yj.BooksRepository;
import com.db40.library.yj.BooksService;

@Controller
public class AdminController {
	
	@Autowired
	BooksService booksService;
	@Autowired
	BooksRepository booksRepository;
	
	@GetMapping("/admin/membersManage")
	public String membersManage() {
		System.out.println("실행");
		return "admin/membersManage";
	}
	@GetMapping("/admin/booksManage")
	public String booksManage(Model model) {
		List<Books> bookList = booksRepository.findAll();
		model.addAttribute("list", bookList);
		return "admin/booksManage";
	}
	@GetMapping("/admin/findBook")
	public String findBook() {
		return ""; 
	}
	
}

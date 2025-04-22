package com.db40.library.yj.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.db40.library.member.Member;
import com.db40.library.member.MemberStatus;
import com.db40.library.member.MemberStatusRepository;
import com.db40.library.sh.Books;
import com.db40.library.sh.Category;
import com.db40.library.yj.BooksRepository;
import com.db40.library.yj.BooksService;
import com.db40.library.yj.CategoryRepository;

@Controller
public class AdminController {
	
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	MemberStatusRepository memberStatusRepository;
	
	@Autowired
	BooksService booksService;
	@Autowired
	BooksRepository booksRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/admin/membersManage")
	public String membersManage(Model model) {
		List<Member> memberList = adminRepository.findAll();
		
		for(Member member : memberList) {
			MemberStatus memberStatus = memberStatusRepository.findById(member.getMemberStatus().getId()).get();
			member.setMemberStatus(memberStatus);
		}
		
		
		model.addAttribute("list",memberList);
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
	@PostMapping("/admin/insertBook")
	public String insertBook(Books book, @RequestParam String bookCategoryName) {
		Category category = categoryRepository.findByBookCategoryName(bookCategoryName).get();
		category.setBookCategoryName(bookCategoryName);
		book.setCategory(category);
		
		booksRepository.save(book);
		
		return "redirect:booksManage";
	}
	
}

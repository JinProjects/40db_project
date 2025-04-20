package com.db40.library.yj.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/membersManage")
	public String membersManage() {
		System.out.println("실행");
		return "admin/membersManage";
	}
	@GetMapping("/admin/booksManage")
	public String booksManage() {
		System.out.println("실행");
		return "admin/booksManage";
	}
	@GetMapping("/admin/findBook")
	public String findBook() {
		return ""; 
	}
}

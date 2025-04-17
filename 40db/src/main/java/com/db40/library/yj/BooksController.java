package com.db40.library.yj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.db40.library.yj.util.BookApi;

@Controller
public class BooksController {
	@Autowired
	public BookApi bookApi;
	
	@GetMapping("/admin/main")
	public String test(Model model) {
		model.addAttribute("list", bookApi.findBooks("java"));
		return "adminMain";
	}
}

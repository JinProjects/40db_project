package com.db40.library.binary3300;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookHopeController {
	
	@GetMapping("/bookhope/hope_now")
	public String list(Model model) {
		return "/bookhope/hope_now";
	} //  http://localhost:8080/bookhope/hope_now
	
	
	@GetMapping("/bookhope/hope_insert")
	public String insert_get() {
		return "/bookhope/write";
	} //  http://localhost:8080/bookhope/hope_insert
	
	@PostMapping("/bookhope/hope_insert")
	public String insert_post(BookHope bookhope) {
		return "redirect:/bookhope/hope_now";
	} //  http://localhost:8080/bookhope/hope_insert
	
	
}

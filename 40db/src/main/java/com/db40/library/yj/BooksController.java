package com.db40.library.yj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksController {
	
	@GetMapping("/admin/bookreg")
	public String test() {
		
		return "";
	}
}

package com.db40.library.sh;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BooksController {

    private final BooksService booksService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Books> paging = this.booksService.getList(page);
        model.addAttribute("paging", paging);
        return "book_search";
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Books> paging = this.booksService.getList(page);
        model.addAttribute("paging", paging);
        return "book_search";
    }

}
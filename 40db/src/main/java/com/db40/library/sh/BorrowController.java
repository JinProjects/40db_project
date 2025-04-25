package com.db40.library.sh;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.db40.library.member.*;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BorrowController {
	
	private final BorrowRepository inOutRepository;
	private final MemberRepository memberRepository;
	private final BooksRepository booksRepository;
	
	@GetMapping("/borrow/alllist")
	public String allList (Model model) {
		List<Borrow> allList = inOutRepository.findAll();
		BorrowComparator inOutComparator = new BorrowComparator(); // Comparator 객체 생성
		allList.sort(inOutComparator);
		model.addAttribute("allList", allList);
		return "borrow/inout_admin";
	}
	
	@PostMapping("/borrow")
	public String borrow (@RequestParam("bookNo") Integer bookNo,
	                      @RequestParam("bookTitle") String bookTitle, 
	                      Principal principal) {

	    Member member = memberRepository.findByMemberId(principal.getName()).orElse(null);
	    if (member == null) {
			/* return "redirect:/member/login?error"; */
	        return "redirect:/member/login";
	    }
	    Books books = booksRepository.findByBookNo(bookNo);
	    if (books == null) {
	        // 책 정보가 없을 경우 예외 처리 (예: 오류 페이지로 리다이렉트)
	        return "redirect:/error_page?message=BookNotFound"; // 예시
	    }


	    Borrow inout = new Borrow();
	    inout.setMember(member);
	    inout.setBook(books); 


	    inout.setBookTitle(books.getBookTitle());


	    inout.setBorrowState("대출 중");
	    inOutRepository.save(inout);
	    return "redirect:/inoutUser";
	}
	@GetMapping("/borrow/inoutUser")
	public String userBorrowList(Model model, Principal principal) {
	    // 현재 로그인한 사용자의 대출 목록을 가져오는 로직 추가
	    // 예시:
	    Member member = memberRepository.findByMemberId(principal.getName()).orElse(null);
	    if (member != null) {
	    List<Borrow> borrowList = inOutRepository.findByMemberId(member); // InOutRepository에 메소드 추가 필요
	    model.addAttribute("borrowList", borrowList);
	     }
	    return "borrow/inout_user"; 
	}
	
	@PostMapping("/borrow/bookReturn")
	public String bookreturn (@RequestParam("bookNo") Long bookId, Principal principal) {

	    Member member = memberRepository.findByMemberId(principal.getName()).orElse(null);
	    if (member == null) {
	        return "redirect:member/login";
	    }

	    List<Borrow> userBorrows = inOutRepository.findByMemberId(member);
	    Borrow targetInout = null;
	    for (Borrow inout : userBorrows) {
	        if (inout.getBook() != null && inout.getBook().getBookNo() == bookId && inout.getReturnDate() == null) {
	            targetInout = inout;
	            break;
	        }
	    }


	    if (targetInout != null) {
	        if ("대출 중".equals(targetInout.getBorrowState())) {
	            targetInout.setReturnDate(LocalDateTime.now());
	            targetInout.setBorrowState("정상 반납");
	            inOutRepository.save(targetInout); 
	        } else if ("연체".equals(targetInout.getBorrowState())) {
	            targetInout.setReturnDate(LocalDateTime.now());
	            targetInout.setBorrowState("연체 반납");
	            inOutRepository.save(targetInout);  }
	        
	        
	            if (member != null) { 
	                int currentWarnings = member.getMemberWarning();
	                int newWarnings = currentWarnings + 1;
	                member.setMemberWarning(newWarnings);
	                memberRepository.save(member);
	            }

	   
	}
	    return "redirect:/inoutUser";
}
}

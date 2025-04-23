package com.db40.library.sh;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InOutController {
	
	private final InOutRepository inOutRepository;
	private final MemberRepository memberRepository;
	private final BooksRepository booksRepository;
	
	@PostMapping("/borrow")
	public String borrow (@RequestParam("bookNo") Integer bookNo,
	                      @RequestParam("bookTitle") String bookTitle, 
	                      Principal principal) {

	    System.out.println("전달받은 책 번호: " + bookNo);
	    System.out.println("전달받은 책 제목: " + bookTitle); 

	    Member member = memberRepository.findByMemberId(principal.getName()).orElse(null);
	    if (member == null) {
	        return "redirect:/login?error";
	    }
	    Books books = booksRepository.findByBookNo(bookNo);
	    if (books == null) {
	        // 책 정보가 없을 경우 예외 처리 (예: 오류 페이지로 리다이렉트)
	        return "redirect:/error_page?message=BookNotFound"; // 예시
	    }


	    InOut inout = new InOut();
	    inout.setMemberId(member);
	    inout.setBookNo(books); 


	    inout.setBookTitle(books.getBookTitle());


	    inout.setBorrowState("대출 중");
	    inOutRepository.save(inout);
	    return "redirect:/inout_user";
	}
	@GetMapping("/inout_user")
	public String userBorrowList(Model model, Principal principal) {
	    // 현재 로그인한 사용자의 대출 목록을 가져오는 로직 추가
	    // 예시:
	    Member member = memberRepository.findByMemberId(principal.getName()).orElse(null);
	    if (member != null) {
	    List<InOut> borrowList = inOutRepository.findByMemberId(member); // InOutRepository에 메소드 추가 필요
	    model.addAttribute("borrowList", borrowList);
	     }
	    return "inout_user"; 
	}
	
	@PostMapping("/bookReturn")
	public String bookreturn (@RequestParam("bookNo") Integer bookId, Principal principal) {

	    Member member = memberRepository.findByMemberId(principal.getName()).orElse(null);
	    if (member == null) {
	        return "redirect:/login";
	    }

	    List<InOut> userBorrows = inOutRepository.findByMemberId(member);
	    InOut targetInout = null;
	    for (InOut inout : userBorrows) {
	        if (inout.getBookNo() != null && inout.getBookNo().getBookNo() == bookId && inout.getReturnDate() == null) {
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
	    return "redirect:/inout_user";
}
}

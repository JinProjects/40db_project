package com.db40.library.sh;

import java.security.Principal;
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
	                      @RequestParam("bookTitle") String bookTitle, // <-- 책 제목 파라미터 추가!
	                      Principal principal) {

	    // 이제 bookTitle 변수로 상세 페이지에서 보낸 책 제목을 받을 수 있어요!
	    System.out.println("전달받은 책 번호: " + bookNo);
	    System.out.println("전달받은 책 제목: " + bookTitle); // 잘 받아졌는지 로그로 확인해 보세요!

	    Member member = memberRepository.findByMemberId(principal.getName()).orElse(null);
	    if (member == null) {
	        return "redirect:/login?error";
	    }

	    // 책 번호로 DB에서 책 정보를 가져오는 것은 그대로 유지하는 것이 좋아요!
	    // 왜냐하면 클라이언트(브라우저)에서 보낸 정보는 위변조될 가능성이 있기 때문이에요.
	    // DB에서 직접 가져온 정보가 가장 정확하고 안전해요.
	    Books books = booksRepository.findByBookNo(bookNo);
	    if (books == null) {
	        // 책 정보가 없을 경우 예외 처리 (예: 오류 페이지로 리다이렉트)
	        return "redirect:/error_page?message=BookNotFound"; // 예시
	    }


	    InOut inout = new InOut();
	    inout.setMemberId(member);
	    inout.setBookNo(books); // DB에서 조회한 Books 객체 사용

	    // InOut 엔티티에는 DB에서 조회한 책 제목을 넣어주는 것이 더 안전해요.
	    inout.setBookTitle(books.getBookTitle());
	    // 만약 정말로 폼에서 넘겨받은 bookTitle을 쓰고 싶다면 아래처럼 할 수도 있지만,
	    // 권장하지는 않아요!
	    // inout.setBookTitle(bookTitle);

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
	    return "inout_user"; // templates/inout_user.html 파일을 보여줌
	
	}
	
	
	

}

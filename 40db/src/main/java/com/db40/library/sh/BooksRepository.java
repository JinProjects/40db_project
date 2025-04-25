package com.db40.library.sh;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<Books, Integer> {

	Books findByBookNo(Integer bookNo);
<<<<<<< HEAD
	
	Page<Books> findByBookTitleContainingIgnoreCaseOrBookAuthorContainingIgnoreCaseOrBookPublisherContainingIgnoreCase(String bookTitleKeyword, String bookAuthorKeyword, String bookPublisherKeyword, Pageable pageable);

=======
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430

}

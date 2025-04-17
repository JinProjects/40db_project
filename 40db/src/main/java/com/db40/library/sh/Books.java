package com.db40.library.sh;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Books {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "book_no")
	    private Long bookNo;

	    @Column(name = "book_isbn", length = 100)
	    private String bookIsbn;

	    @Column(name = "book_intro", length = 300)
	    private String bookIntro;
	    
<<<<<<< HEAD
	    @Column(name = "book_category", length = 100)
	    private String bookCategory;
=======
	    @ManyToOne
	    @JoinColumn(name = "book_category_id")
	    private Category category;
>>>>>>> c6367ffd11dd24fe6b63cf9a40ba2798db0212c2

	    @Column(name = "book_title", nullable = false, length = 200)
	    private String bookTitle;

	    @Column(name = "book_cover", nullable = false, length = 100)
	    private String bookCover;
	    
	    @Column(name = "book_author", nullable = false, length = 100)
	    private String bookAuthor;

	    @Column(name = "book_publisher", length = 100)
	    private String bookPublisher;

	    @Column(name = "book_pulished_date", length = 100)
	    private String bookPublishedDate;

	    @Column(name = "book_total_page", length = 100)
	    private String bookTotalPage;

	    @Column(name = "book_writer_info", length = 200)
	    private String bookWriterInfo;

	    @Column(name = "book_entered_date", length = 100)
	    private String bookEnteredDate;

	    @Column(name = "book_hit")
	    private Integer bookHit;
	}



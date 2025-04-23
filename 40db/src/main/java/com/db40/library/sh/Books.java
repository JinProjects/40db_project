package com.db40.library.sh;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Books {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "book_no")
	    private Integer bookNo;

	    @Column(name = "book_isbn", length = 100)
	    private String bookIsbn;

	    @Column(name = "book_intro", length = 300)
	    private String bookIntro;

	    @Column(name = "book_category", length = 100)
	    private String bookCategory;

	    @Column(name = "book_title", nullable = false, length = 200)
	    private String bookTitle;

	    @Column(name = "book_author", nullable = false, length = 100)
	    private String bookAuthor;

	    @Column(name = "book_publisher", length = 100)
	    private String bookPublisher;

	    @Column(name = "book_pulished_date", length = 100)
	    private String bookPublishedDate;

       @Column(name = "book_entered_date", length = 100)
       @CreationTimestamp
	    private LocalDateTime bookEnteredDate;

	    @Column(name = "book_hit")
	    private Integer bookHit;
	    
	    @OneToMany (mappedBy = "bookNo")
	    private List<InOut> inout;
	}



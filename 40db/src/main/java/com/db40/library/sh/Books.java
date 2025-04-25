package com.db40.library.sh;

import java.time.LocalDateTime;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
<<<<<<< HEAD
=======

import com.db40.library.yj.admin.Hashtag;
=======
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
>>>>>>> f26081a05c14ba7170d255de46b61cdf2126b814
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430

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
	    
	    @ManyToOne
	    @JoinColumn(name = "book_category_no")
	    private  Category category;

	    @Column(name = "book_title", nullable = false, length = 200)
	    private String bookTitle;

	    @Column(name = "book_author", nullable = false, length = 100)
	    private String bookAuthor;

	    @Column(name = "book_publisher", length = 100)
	    private String bookPublisher;
	    
	    @Column(name = "book_cover", nullable = false, length = 100)
	    private String bookCover;
	    
	    @Column(name = "book_pulished_date", length = 100)
	    private String bookPublishedDate;
<<<<<<< HEAD
	    
	    @Column(name = "book_description", length = 100)
	    private String bookDescription;
	    
       @Column(name = "book_entered_date", length = 100)
       @CreationTimestamp
=======

<<<<<<< HEAD
	    @Column(name = "book_entered_date", length = 100)
	    @CreationTimestamp
=======
       @Column(name = "book_entered_date", length = 100)
       @CreationTimestamp
>>>>>>> f26081a05c14ba7170d255de46b61cdf2126b814
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
	    private LocalDateTime bookEnteredDate;

	    @Column(name = "book_hit")
	    @ColumnDefault("0")
	    private Integer bookHit;
	    
<<<<<<< HEAD
	    @OneToMany (mappedBy = "book")
	    private List<Borrow> inout = new ArrayList<>();
	    
	    @Override
=======
<<<<<<< HEAD
	    @OneToMany
	    @JoinColumn(name = "book_no")
	    private List<Hashtag> hashtag; 
	    
		@Override
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
		public String toString() {
			return "Books [bookNo=" + bookNo + ", bookIsbn=" + bookIsbn + ", bookDescription=" + bookDescription
					+ ", bookTitle=" + bookTitle + ", bookCover=" + bookCover + ", bookAuthor=" + bookAuthor
					+ ", bookPublisher=" + bookPublisher + ", bookPublishedDate=" + bookPublishedDate
					+ ", bookEnteredDate=" + bookEnteredDate + ", bookHit=" + bookHit + "]";
		}
<<<<<<< HEAD
=======
	    
=======
	    @OneToMany (mappedBy = "bookNo")
	    private List<InOut> inout;
>>>>>>> f26081a05c14ba7170d255de46b61cdf2126b814
>>>>>>> 5faebe21f54764c0654eedef47e912cfd2114430
	}



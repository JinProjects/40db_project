package com.db40.library.sh;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

	    @Column(name = "book_description", length = 300)
	    private String bookDescription;
	    
	    @ManyToOne
	    @JoinColumn(name = "book_category_no")
	    private Category category;

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

	    @Column(name = "book_entered_date", length = 100)
	    @CreationTimestamp
	    private LocalDateTime bookEnteredDate;

	    @Column(name = "book_hit")
	    @ColumnDefault("0")
	    private Integer bookHit;

		@Override
		public String toString() {
			return "Books [bookNo=" + bookNo + ", bookIsbn=" + bookIsbn + ", bookDescription=" + bookDescription
					+ ", bookTitle=" + bookTitle + ", bookCover=" + bookCover + ", bookAuthor=" + bookAuthor
					+ ", bookPublisher=" + bookPublisher + ", bookPublishedDate=" + bookPublishedDate
					+ ", bookEnteredDate=" + bookEnteredDate + ", bookHit=" + bookHit + "]";
		}
	    
	}

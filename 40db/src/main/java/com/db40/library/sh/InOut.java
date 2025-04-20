package com.db40.library.sh;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InOut {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long borrowNo;
	
	@ManyToOne
	@JoinColumn  (name = "member_id")
	private Member memberId;
	
	@ManyToOne
	@JoinColumn  (name = "book_no")
	private Books bookNo;
	
	@Column (name = "book_title")
	private String bookTitle;
	
	@Column (name = "borrow_state")
	private String borrowState;
	
	@Column (name = "borrow_date")
	private LocalDateTime  borrowDate = LocalDateTime.now();
	
	@Column(name = "due_date")
	private LocalDateTime dueDate;
	
	@Column (name = "overdue_days")
	private Long overdueDays; 
	
	@PrePersist
	public void setInitialDates() {
		this.dueDate = this.borrowDate.plusDays(15);
		this.overdueDays = ChronoUnit.DAYS.between(LocalDateTime.now(), this.dueDate);


	}
}
	
	

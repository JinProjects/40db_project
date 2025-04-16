package com.db40.library.sh;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
	private long borrow_no;
	
	@ManyToOne
	@JoinColumn  (name = "member_id")
	private Member member_id;
	
	@ManyToOne
	@JoinColumn  (name = "book_no")
	private Books book_no;
	
	private String book_title;
	
	private String borrow_state;
	
	private LocalDateTime  borrow_date = LocalDateTime.now();
	
	private LocalDateTime due_date;
	
	private Long overdue_days; 

	@PrePersist
	public void setInitialDates() {
		this.due_date = this.borrow_date.plusDays(15);
		this.overdue_days = ChronoUnit.DAYS.between(LocalDateTime.now(), this.due_date);
	}
}
	
	

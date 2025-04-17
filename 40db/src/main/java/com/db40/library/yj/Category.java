package com.db40.library.yj;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
	private String book_category_id;
	private String book_category_name;
}

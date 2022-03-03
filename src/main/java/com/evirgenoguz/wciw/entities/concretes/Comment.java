package com.evirgenoguz.wciw.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comment {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "post_id")
	private int postId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "comment_text")
	private String commentText;
	
}

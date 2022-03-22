package com.evirgenoguz.wciw.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
	int id;
	String description;
	String title;
	int userId;
}

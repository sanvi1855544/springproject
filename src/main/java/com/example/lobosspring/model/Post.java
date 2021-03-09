package com.example.lobosspring.model;

import lombok.*;

@Getter
@Setter
public class Post {
	private String username;
	private String date;
	private Long unixTimestamp;
	private String postData;
}

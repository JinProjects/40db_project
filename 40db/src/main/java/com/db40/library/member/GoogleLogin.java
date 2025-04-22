package com.db40.library.member;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleLogin {
	@Value("${google_client_id}")
	private String google_client_id;
	
	@Value("${google_client_secret}")
	private String google_client_secret;
	
	@Value("${google_api}")
	private String google_api;
	
//	public String identify() {
//		return 
//	}
}

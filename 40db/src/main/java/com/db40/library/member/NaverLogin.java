package com.db40.library.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class NaverLogin {
	@Value("${naver_redirect_url}") private String naver_redirect_url;
	@Value("${client_id}") private String client_id;
	@Value("${client_secret") private String client_secret;
	private String state="test";
	
	// 인증
	public String identify() {
		return "https://nid.naver.com/oauth2.0/authorize?response_type=code&"
				+ "client_id=" + client_id
				//+ "&client_secret="+ client_secret
				+ "&state="+ state
				+ "&redirect_uri="+ naver_redirect_url;
	}

}



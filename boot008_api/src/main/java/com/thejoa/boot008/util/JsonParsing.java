package com.thejoa.boot008.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;

public class JsonParsing {
	public static void main(String[] args) {
		//컨트롤러에서 isbn을 받아온다 - 받아온 isbn 호출
				//중앙 도서관api 이용 url
				String seojiUrl = "http://seoji.nl.go.kr/landingPage/SearchApi.do?"
							+ "cert_key=발급키&"	
							+ "result_style=xml&page_no=1&page_size=10&isbn="+isbn;
				//도서관 정보나루 api 이용 url
				String naruUrl = "http://data4library.kr/api/srchDtlList?"
						+ "authKey=발급키&isbn13="
						+ isbn;
		        //Dto 인스턴스화        
				try {
					//도서관 정보나루 api 호출
					Document naru = Jsoup.connect(naruUrl).data("isbn",isbn).get();
		            String bookName = seoji.select("TITLE").text();
					String bookPrice = seoji.select("PRE_PRICE").text();
					String seriesNo = seoji.select("SERIES_NO").text();
					String category = seoji.select("KDC").text();
		            
					//국립도서관 api 호출
					Document seoji = Jsoup.connect(seojiUrl).data("isbn",isbn).get();
					String writer = naru.select("authors").text();
					String publisher = naru.select("publisher").text();
					String bookDescription = naru.select("description").text();
					String bookImageURL = naru.select("bookImageURL").text();
					String bookPublishDate = naru.select("publication_date").text();
		            
		            //DTO setting
		            
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}

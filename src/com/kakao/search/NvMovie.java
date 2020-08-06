package com.kakao.search;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.kakao.dto.MovieDTO;

public class NvMovie {

	public static ArrayList<String> movie() throws IOException {
		
		Gson gson = new Gson();  // Gson 생성
		//타이틀 , url 담을 dto
		MovieDTO dto = new MovieDTO();
		
		//dto 넣을 리스트
		ArrayList<MovieDTO> dtolist = new ArrayList<MovieDTO>();
		ArrayList<String> jsonn = new ArrayList<String>();
		
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();

		System.out.println("Title : 네이버 영화 크롤링");

		// CSS 선택자를 사용해 링크 추출하기
		// 2~11까지 
		for(int i=2;i<12;i++) {
			//제목, 링크
			Elements menus = doc.select("#old_content > table > tbody > tr:nth-child("+i+") > td.title > div > a");
		for (Element menu : menus) {
			//위 링크에 각각 접속해서 이미지 주소를 가져온다.
			
			//위 선택자를 doc.select에 넣어서 이미지 주소 가져오기 ( menu.absUrl("src"))
			//주소 가져와서 html태그에 넣기
			
			
			// 링크의 "title" 속성 값 추출하기
			String title = menu.attr("title").trim();
			// 링크의 URL 추출하기 (절대경로)
			String nextUrl = menu.absUrl("href");
			
			dto.setTitle((i-1)+"위. "+ title);
			dto.setURL(nextUrl);
			dto.setImgurl(MovieImg.img(dto)); 
			
			
			// 이미지 셀렉터 #content > div.article > div.mv_info_area > div.poster > a > img
			
			String toJson = gson.toJson(dto);
			//System.out.println(toJson);
			jsonn.add(toJson);
			
			
			
			// log
			//System.out.println(String.format("%s\n\t%s\n%s", dto.getTitle(), dto.getURL(), dto.getImgurl()));
			
			
			//dtolist.add(dto); 어레이리스트에 dto 넣으려고 했는데 하나만 계속 들어감
			
			
			
			// 링크 대상 페이지에 접근하기
//			Document nextDoc = Jsoup.connect(nextUrl).get();
			// 상세 내용 추출하기
//			String content = nextDoc.select("div.mw-parser-output").html();
		}
		

		}
		return jsonn;
	}

}

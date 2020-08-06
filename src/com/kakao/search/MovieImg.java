package com.kakao.search;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.kakao.dto.MovieDTO;

public class MovieImg {

	public static String img(MovieDTO dto) throws IOException {
		
		String imgsrc= "";
		
		//타이틀 , url 담을 dto
//		MovieDTO dto = new MovieDTO();
		
		//dto 넣을 리스트
//		ArrayList<MovieDTO> dtolist = new ArrayList<MovieDTO>();
		String url = dto.getURL();
		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();

		System.out.println("이미지 불러옴");

			//이미지 셀렉터
			Elements menus = doc.select("#content > div.article > div.mv_info_area > div.poster > a > img");

		for (Element menu : menus) {
			//위 링크에 각각 접속해서 이미지 주소를 가져온다.
			
			//위 선택자를 doc.select에 넣어서 이미지 주소 가져오기 ( menu.absUrl("src"))
			//주소 가져와서 html태그에 넣기
			
			// 링크의 URL 추출하기 (절대경로)
			imgsrc = menu.absUrl("src");		
		}
		return imgsrc;
	}


}


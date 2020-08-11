package com.kakao.db;

import java.util.ArrayList;

import com.kakao.dto.ReviewDTO;
import com.kakao.dto.ReviewOutDTO;

public interface ReviewDAO {
	
	ReviewDTO dto = new ReviewDTO();
	//영화정보 입력
	public void review_insert(ReviewDTO dto);
	
	public ArrayList<ReviewOutDTO> review_load();
}

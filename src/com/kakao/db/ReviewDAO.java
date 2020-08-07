package com.kakao.db;

import com.kakao.dto.ReviewDTO;

public interface ReviewDAO {
	
	ReviewDTO dto = new ReviewDTO();
	//영화정보 입력
	public void review_insert(ReviewDTO dto);
}

package com.kakao.db;
import java.util.ArrayList;

import com.kakao.dto.MovieDTO;



public interface MovieDAO {
	MovieDTO dto = new MovieDTO();
	
	
	//영화정보 입력
	public void movie_insert(MovieDTO dto);
	
	//영화순위 조회
	public ArrayList<MovieDTO> movie_rank();
	

}

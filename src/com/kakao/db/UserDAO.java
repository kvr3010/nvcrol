package com.kakao.db;

import java.util.ArrayList;

import com.kakao.dto.UserDTO;


public interface UserDAO {
	UserDTO dto = new UserDTO();
	
	
	//정보 입력
	public void user_insert(UserDTO dto);
		
	//로그인
	public UserDTO user_select(String email,String pw);
	
	//email 검색
	public boolean select(String email);
	
	//전체 검색
	public ArrayList<UserDTO> user_select();
	
	//점수 정보 업데이트
	public void user_update(UserDTO dto);

}

package com.kakao.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.kakao.dto.ReviewDTO;

public class ReviewDAOImpl implements ReviewDAO{

	@Override
	public void review_insert(ReviewDTO dto) {
		
		Connection conn = null; // DB연결 
		PreparedStatement pstmt = null;

		try{
			conn = DB.conn(); 
			String sql = "INSERT INTO review (nae, title, pyung, mv_num, mb_num) VALUES (?, ?,'5','2','2307')";
			//제목이랑 내용만 db에 들어가는지 확인
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNae());
			pstmt.setString(2, dto.getTitle());
			
			int count = pstmt.executeUpdate();
			if( count == 0 ){
				System.out.println("입력 실패");
			}
			else{
				System.out.println("입력 성공");
			}

		}
		
		catch(Exception e){
			System.out.println("데이터 입력 에러3: " + e);
		}
		finally{
			try{
				if( conn != null && !conn.isClosed()){
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
					pstmt.close();
				}        
			}
			catch( SQLException e){
				e.printStackTrace();
			}
		}
		
		
	}

	}



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
			String sql = "INSERT INTO review (mv_num, mb_num, pyung, nae, title) VALUES ( ?, ?, 5, ?, ?)";
			//제목이랑 내용만 db에 들어가는지 확인
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getMv_num());
			pstmt.setInt(2, dto.getMb_num());
			pstmt.setString(3, dto.getNae());
			pstmt.setString(4, dto.getTitle());
			
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
			System.out.println(dto.getMv_num());
			System.out.println(dto.getMb_num());
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



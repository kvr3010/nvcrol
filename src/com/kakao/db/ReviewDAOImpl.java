package com.kakao.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kakao.dto.MovieDTO;
import com.kakao.dto.ReviewDTO;
import com.kakao.dto.ReviewOutDTO;

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

	@Override
	public ArrayList<ReviewOutDTO> review_load() {

			ArrayList<ReviewOutDTO> dtolist = new ArrayList<ReviewOutDTO>();
			Connection conn = null; 
			PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try {
	        	conn = DB.conn();
				StringBuffer sql = new StringBuffer(); //StringBuffer 문자열 연결
				sql.append("SELECT r.no, m.title, r.title, r.pyung , s.name AS '작성자'");
				sql.append("FROM movie m , review r, signup s ");
				sql.append("WHERE m.num = r.mv_num AND r.mb_num = s.num;");
				pstmt = conn.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
	      

	            
	            while(rs.next()){
	            	ReviewOutDTO rv = new ReviewOutDTO();
	            	rv.setNo(rs.getInt(1));
	            	rv.setJe(rs.getString(2));
	            	rv.setTitle(rs.getString(3));
	            	rv.setPyung(rs.getInt(4));
	            	rv.setName(rs.getString(5));
	            	
	            	dtolist.add(rv);
	            }
	            for (ReviewOutDTO list : dtolist) {
	            	System.out.println(list);
					
				}
	        }
	        
	        catch(Exception e){
	            System.out.println("에러2: " + e);
	        }
	        finally{
	            try{
	            	if( conn != null && !conn.isClosed()){
	                    conn.close();
	            	}
	            	if( pstmt != null && !pstmt.isClosed()){
	                      pstmt.close();
	                }
	            	if( rs != null && !rs.isClosed()){
	                      rs.close();
	                  }           
	            	}
	            catch( SQLException e){
	                e.printStackTrace();
	            	}
	        }

		return dtolist;
	}

}



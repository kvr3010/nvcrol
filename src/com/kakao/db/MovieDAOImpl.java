package com.kakao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kakao.dto.MovieDTO;

public class MovieDAOImpl implements MovieDAO {

	@Override
	public void movie_insert(MovieDTO dto) {
	
		Connection conn = null; // DB연결 
		PreparedStatement pstmt = null;
		// 디비 연결
		// 쿼리 만들고 실행
		//INSERT INTO movie(title,bae,gam, img) SELECT '반도', '배우','감독' ,'http://'  FROM DUAL WHERE NOT EXISTS (SELECT title, bae, gam, img FROM movie WHERE title = '3위. 반도')
		try{
			conn = DB.conn();
			// String sql = ;
			StringBuffer sql = new StringBuffer(); //StringBuffer 문자열 연결
			sql.append("INSERT INTO movie (title, bae, gam, img)");
			sql.append("SELECT ?, ?, ?, ?  FROM DUAL WHERE NOT EXISTS");
			sql.append("(SELECT title, bae, gam, img FROM movie WHERE title = ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getBae());
			pstmt.setString(3, dto.getGam());
			pstmt.setString(4, dto.getImg());
			pstmt.setString(5, dto.getTitle());
			
			
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

	@Override
	public ArrayList<MovieDTO> movie_rank() {

			ArrayList<MovieDTO> dtolist = new ArrayList<MovieDTO>();
			Connection conn = null; 
	        Statement stmt = null;
	        ResultSet rs = null;
	        
	        try {
	        	conn = DB.conn();
	        	String sql = "SELECT title,bae,gam,img,num FROM movie";
	        	stmt = conn.prepareStatement(sql);
	        	rs = stmt.executeQuery(sql);

	            
	            while(rs.next()){
	            	MovieDTO mv = new MovieDTO();
	            	mv.setTitle(rs.getString(1));
	            	mv.setBae(rs.getString(2));
	            	mv.setGam(rs.getString(3));
	            	mv.setImg(rs.getString(4));
	            	mv.setNum(rs.getInt(5));
	            	
	            	dtolist.add(mv);
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
	            	if( stmt != null && !stmt.isClosed()){
	                      stmt.close();
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

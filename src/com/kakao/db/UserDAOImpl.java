package com.kakao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kakao.dto.UserDTO;


public class UserDAOImpl implements UserDAO {
	UserDTO dto = new UserDTO();
	//입력 회원가입
	@Override
	public void user_insert(UserDTO dto) {
		
		Connection conn = null; // DB연결 
		PreparedStatement pstmt = null;
		// 디비 연결
		// 쿼리 만들고 실행
		
		try{
			conn = DB.conn();
			String sql = "INSERT INTO signup (email, pw, name, phone) VALUES (?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			
			
			int count = pstmt.executeUpdate();
			if( count == 0 ){
				System.out.println("사용자 입력 실패");
			}
			else{
				System.out.println("사용자 입력 성공");
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
	
	//점수 업데이트
	@Override
	public void user_update(UserDTO dto) {
		Connection conn = null; // DB연결 
		PreparedStatement pstmt = null;
		// 디비 연결
		// 쿼리 만들고 실행
		
		try{
			conn = DB.conn();
			String sql = "UPDATE signup SET score= ? WHERE id= ?";
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1, dto.getJumsu());
			
			
			int count = pstmt.executeUpdate();
			if( count == 0 ){
				System.out.println("사용자 입력 실패");
			}
			else{
				System.out.println("사용자 입력 성공");
			}
			
			
		}
		
		catch(Exception e){
			System.out.println("데이터 입력 에러4: " + e);
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
	
	
	
	//로그인 조회
	@Override
	public UserDTO user_select(String email,String pw) {
		UserDTO user = null;
		Connection conn = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
        	conn = DB.conn();
        	String sql = "SELECT * FROM signup WHERE email=? AND pw=?" ;
        	stmt = conn.prepareStatement(sql);
        	stmt.setString(1, email);
        	stmt.setString(2, pw);
        	rs = stmt.executeQuery();

            
            if(rs.next()){
            	user = new UserDTO();
            	user.setEmail(rs.getString("email")); 
            	user.setPw(rs.getString("pw"));
            	user.setName(rs.getString("name"));
            	user.setNum(rs.getInt("num"));
            }
            else {
            	System.out.println("일치하는 정보 없음");
            }
        }
        catch(Exception e){
            System.out.println("에러1: " + e);
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
		return user;
	}
	
	//전체 검색
	@Override
	public ArrayList<UserDTO> user_select() {
		
		ArrayList<UserDTO> dtolist = new ArrayList<UserDTO>();
		Connection conn = null; 
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
        	conn = DB.conn();
        	String sql = "SELECT * FROM signup";
        	stmt = conn.prepareStatement(sql);
        	rs = stmt.executeQuery(sql);

            
            while(rs.next()){
            	UserDTO user = new UserDTO();
            	user.setName(rs.getString(2));
            	user.setNum(rs.getInt("num"));
            	
            	dtolist.add(user);
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

	@Override
	public boolean select(String email) {
		Connection conn = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isEmail = false;
        
        try {
        	conn = DB.conn();
        	String sql = "SELECT * FROM signup WHERE email=?" ;
        	stmt = conn.prepareStatement(sql);
        	stmt.setString(1, email);
        	rs = stmt.executeQuery();
            
            if(rs.next()){
            	isEmail=true;
            }
        }
        catch(Exception e){
            System.out.println("에러1: " + e);
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
        
        return isEmail;
		
	}



}

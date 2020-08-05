package com.kakao.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	//DB연결
	public static Connection conn() throws Exception {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER,DBConfig.DB_PW);
        System.out.println("연결 성공");
        return conn;
	}
}

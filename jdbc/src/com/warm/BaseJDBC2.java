package com.warm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseJDBC2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new BaseJDBC2().test();
	}
	
    
	public void test() throws ClassNotFoundException, SQLException {
		String dburl = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8"; 
        String user = "root"; 
        String password = "123456"; 
        
		//1：注册驱动类 
		Class.forName("com.mysql.jdbc.Driver");
		//2：创建数据库连接 
		Connection conn = DriverManager.getConnection(dburl, user, password);
		
		String sql = "select * from teacher where id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, 1);// 从1开始
		ResultSet resultSet = stmt.executeQuery();
//		stmt.executeUpdate()

		while(resultSet.next()) {
			System.out.print(resultSet.getLong("id") + "\t");
			System.out.print(resultSet.getString("name") + "\t");
			System.out.print(resultSet.getInt("salary") + "\t");
			System.out.print(resultSet.getString("remark") + "\t");
		}
		
		stmt.close();
	}
}

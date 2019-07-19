package com.warm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseJDBC1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new BaseJDBC1().test();
	}
	
	

	public void test() throws ClassNotFoundException, SQLException {
		String dburl = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8"; 
        String user = "root"; 
        String password = "123456"; 
		
		//1：注册驱动类 
		Class.forName("com.mysql.jdbc.Driver");
		//2：创建数据库连接 
		Connection conn = DriverManager.getConnection(dburl, user, password);
		//3：创建执行SQL的对象 
		Statement stmt = conn.createStatement();
		
		String sql = "select t.id,t.name,t.salary,t.remark from teacher t \n" + "where t.salary>300";
		//4：执行SQL，并获取返回结果 
		ResultSet rs = stmt.executeQuery(sql);
		//5：处理返回结果，此处打印查询结果 
		while (rs.next()) {
			System.out.print(rs.getLong("id") + "\t");
			System.out.print(rs.getString("name") + "\t");
			System.out.print(rs.getInt("salary") + "\t");
			System.out.print(rs.getString("remark") + "\t");
			System.out.println();
		}
	    //6：关闭数据库连接 
		conn.close();
	}
}

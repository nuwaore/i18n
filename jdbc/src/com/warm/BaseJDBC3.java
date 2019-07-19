package com.warm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseJDBC3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new BaseJDBC3().test();
	}
    
    public void test() throws ClassNotFoundException, SQLException {
    	String dburl = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8"; 
        String user = "root"; 
        String password = "123456";
    	
        //1：注册驱动类 
  		Class.forName("com.mysql.jdbc.Driver");
  		//2：创建数据库连接 
  		Connection conn = DriverManager.getConnection(dburl, user, password);
        
  		Statement stmt = conn.createStatement();
    	stmt.addBatch("update teacher set salary=3000 where name='aaa'");
    	stmt.addBatch("update teacher set salary=4000 where name='bbb'");
    	stmt.addBatch("update teacher set salary=5000 where name='ccc'");
    	stmt.addBatch("update teacher set salary=6000 where name='ddd'");
    	int[] results = stmt.executeBatch();

    	int total = 0;
    	for( int result : results ){
    		total += result;
    	}
    	System.out.println( "total records updated by batch " + total );
    }
}

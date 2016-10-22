package com.oracle.dao;
import java.sql.*;
public class TestConnectDBA {
    /**
     * JDBC:java database connectivity
     * @param args
     */
	public static void main(String[] args) {
		try {
			//1加载驱动--oracle11g
			Class.forName("oracle.jdbc.OracleDriver");
			//2连接数据库
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hunanshida","123");
		    System.out.println("连接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("加载驱动失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("连接数据库失败");
		}
	}

}

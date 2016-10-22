package com.oracle.dao;
import java.sql.*;
public class BaseDAO {
   //属性
	 public static final String DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
	 public static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	 public static final String USER="hunanshida";
	 public static final String PASS="123";
   //方法--静态方法:类名.方法
	 public static Connection getConn(){
		 Connection conn=null;
		 try {
			//1加载驱动
			 Class.forName(DRIVER_CLASS);
			 //2
			 conn=DriverManager.getConnection(URL,USER,PASS);
			 System.out.println("连接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败!");
		}
		 return conn;
	 }
	 
	 //释放资源的方法
	 public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
		 //1关闭rs
		 if(rs!=null){
			 try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(pstmt!=null){
			 try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(conn!=null){
			 try {
				 System.out.println("请稍候，马上关闭连接.......");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	 
}

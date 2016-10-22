package com.oracle.dao.impl;

import com.oracle.dao.BaseDAO;
import com.oracle.dao.UsersDao;
import com.oracle.entity.Users;

import java.sql.*;//引入SQL包
import java.util.ArrayList;
import java.util.List;
public class UsersDaoImpl implements UsersDao {

	@Override
	public boolean isLogin(String name, String pwd) {
		//jdbc操作6步
		//声明常用变量（SQL“三大将军”）
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		boolean ret=false;
		//1加载驱动
		//2获得连接
		 conn=BaseDAO.getConn();
		//3写SQL并创建执行行器
		 //3.1
		 String sql="select pwd from users where name=?";
		 //3.2:对？的位置进行设置相应的值
		 try {
			pstmt=conn.prepareStatement(sql);//不能丢
			 pstmt.setString(1, name);//设置参数要正确
			//4执行SQL并得到结果
			 rs=pstmt.executeQuery();
			//5处理结果
			 //如果是条件查询，一般是一个唯一的结果，也就是一条记录
			 //如果是没有条件的查询，一般会是一个表集合，也就是多条记录
			 String pwd1="";
			 if(rs.next()){
				 pwd1=rs.getString("pwd");
				 System.out.println("查询的密码是："+pwd1);
			}
			 if(pwd1.equals(pwd)){
				 ret=true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		    //6释放资源
			BaseDAO.closeAll(rs, pstmt, conn);
		} 
		return ret;
	}

	@Override
	public boolean isRegister(String name, String pwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean ret =false;
		//1加载驱动
		//2获得连接
		conn=BaseDAO.getConn();
		//3写出SQL语句和创建SQL执行器
		//3.1写出SQL
		String sql="insert into users(name,pwd) values(?,?)";
		try {
			//3.2创建pstmt对象
			pstmt=conn.prepareStatement(sql);//不能丢
			//3.3为？占位符设置值
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			//4得到结果
			int num=pstmt.executeUpdate();
			//5处理结果
			if(num!=0){
				ret=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   //6释放资源
			BaseDAO.closeAll(null, pstmt, conn);
		}
		return ret;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> list =new ArrayList<Users>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//1加载驱动
		//2获得连接
		conn=BaseDAO.getConn();
		//3写SQL，并创建执行器
		String sql="select * from users order by id";
		try {
			pstmt=conn.prepareStatement(sql);
			//4执行SQL语句得到结果
			rs=pstmt.executeQuery();
			//5处理结果
			while(rs.next()){
				//1生成空的对象
				Users user=new Users();
				//2给对象属性赋值
				//2.1查询数据库
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String pwd=rs.getString("pwd");
				//2.2给对象赋值
				user.setId(id);
				user.setName(name);
				user.setPwd(pwd);
				//3把对象加入到集合
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   //6释放资源
			 BaseDAO.closeAll(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public Users getUsersByID(int id) {
		Users user=new Users();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//1加载驱动
		//2获得连接
		conn=BaseDAO.getConn();
		//3写SQL，并创建执行器
		String sql="select * from users where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			//4执行SQL语句得到结果
			rs=pstmt.executeQuery();
			//5处理结果
			if(rs.next()){
				//1生成空的对象
				
				//2给对象属性赋值
				//2.1查询数据库
				int uid=rs.getInt("id");
				String name=rs.getString("name");
				String pwd=rs.getString("pwd");
				//2.2给对象赋值
				user.setId(uid);
				user.setName(name);
				user.setPwd(pwd);
				//3把对象加入到集合
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   //6释放资源
			 BaseDAO.closeAll(rs, pstmt, conn);
		}
		return user;
	}

	

	
}

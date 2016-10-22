package com.oracle.test;

import java.sql.Connection;
import java.util.List;

import com.oracle.dao.BaseDAO;
import com.oracle.dao.UsersDao;
import com.oracle.dao.impl.UsersDaoImpl;
import com.oracle.entity.Users;

public class TestConn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //BaseDAO dao =new BaseDAO();
      /**
       * 含有静态方法的类就叫静态类
       * 直接使用类名.方法,不用生成对象
       */
//       Connection conn=BaseDAO.getConn();
//       BaseDAO.closeAll(null, null, conn);
//		String name="wangwu";
//		String pwd="123456";
		//接口      对象=new 实现了接口的类的对象();
		UsersDao dao=new UsersDaoImpl();
//		boolean isLogin=dao.isLogin(name, pwd);
//		if(isLogin){
//			System.out.println("用户名和密码正确");
//		}else{
//			System.out.println("用户名或密码错误");
//		}
//		boolean isRegister=dao.isRegister(name, pwd);
//		if(isRegister){
//			System.out.println("注册成功");
//		}else{
//			System.out.println("写入数据库失败");
//		}
		
		List<Users> list=dao.getAllUsers();
		System.out.println("共查询到了"+list.size()+"条记录");
		
		
		for(int i=0;i<list.size();i++){
			Users user=list.get(i);
			System.out.println(user.getId()+" "+user.getName()+" "+user.getPwd());
		}
		
		
	}

}

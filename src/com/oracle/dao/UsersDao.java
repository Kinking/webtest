package com.oracle.dao;

import java.util.List;

import com.oracle.entity.Users;

public interface UsersDao {
   //定义软件的功能
	//登录的功能：根据传入的用户名和密码查询数据库进行比对
	//如果用户名和密码匹配就返回成功转发视图
	public boolean isLogin(String name,String pwd);
	//注册功能
	public  boolean isRegister(String name,String pwd);
	//查询所有用户
	public List<Users> getAllUsers();
	//根据ID查找用户对象
	public Users getUsersByID(int id);
}

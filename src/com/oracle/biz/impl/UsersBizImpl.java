package com.oracle.biz.impl;

import com.oracle.biz.UsersBiz;
import com.oracle.dao.UsersDao;
import com.oracle.dao.impl.UsersDaoImpl;

public class UsersBizImpl implements UsersBiz {
	UsersDao dao=new UsersDaoImpl();
	@Override
	public boolean isLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		//调用数据层来实现
		//接口     对象=new 实现了接口的类的对象
		
		return dao.isLogin(name, pwd);
	}

	@Override
	public boolean isRegister(String name, String pwd) {
		// TODO Auto-generated method stub
		return dao.isRegister(name, pwd);
	}

}

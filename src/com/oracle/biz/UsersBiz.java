package com.oracle.biz;
/**
 * 业务逻辑Model:业务逻辑层
 * @author Administrator
 *
 */
public interface UsersBiz {
   //定义功能
	public boolean isLogin(String name,String pwd);
	//注册功能
	public  boolean isRegister(String name,String pwd);
}

package com.oracle.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.biz.UsersBiz;
import com.oracle.biz.impl.UsersBizImpl;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1接收参数
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upass");
		//2调用业务层
		UsersBiz biz=new UsersBizImpl();
		//3转发视图
		boolean isReg=biz.isRegister(name, pwd);
		if(isReg){
			//如果注册成功跳转到登录页面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//重定向到注册页面重新注册
			response.sendRedirect("register.jsp");
		}
	}

}

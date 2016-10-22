package com.oracle.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.biz.UsersBiz;
import com.oracle.biz.impl.UsersBizImpl;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//服务器只做三件事
		//设置中文
		request.setCharacterEncoding("utf-8");
		
		//1接收客户端的参数
		String name=request.getParameter("uName");
		String pwd=request.getParameter("uPass");
		//2调用业务层进入处理
		//接口     对象 =new 实现了接口的类的对象
		UsersBiz biz=new UsersBizImpl();
		boolean isLogin=biz.isLogin(name, pwd);
		//创建会话：
		HttpSession session=request.getSession();
		 if(isLogin){
			 //在会话内保存用户信息
			 session.setAttribute("user", name);
			//3转发视图
			 request.getRequestDispatcher("list.jsp").forward(request, response);
		 }else{
			 //重定向
			 response.sendRedirect("login.jsp");
		 }
		
	}

}

<%@page import="com.oracle.entity.Users"%>
<%@page import="com.oracle.dao.impl.UsersDaoImpl"%>
<%@page import="com.oracle.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
    <%
       String id=request.getParameter("id");
       out.println(id);
       int nid=Integer.parseInt(id);
       UsersDao dao=new UsersDaoImpl();
       Users user=dao.getUsersByID(nid);
    %>
    <form action="">
       �û���ţ�<input type="text" name="uid" value="<%=user.getId()%>"><br>
       �û����ƣ�<input type="text" name="uname" value="<%=user.getName()%>"><br>
       �û����룺<input type="password" name="upass" value="<%=user.getPwd()%>"><br>
       <input type="submit" value="�޸�">
        <input type="submit" value="ɾ��">
    </form>
    
</body>
</html>
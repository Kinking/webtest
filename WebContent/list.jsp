<%@page import="com.oracle.entity.Users"%>
<%@page import="com.oracle.dao.impl.UsersDaoImpl"%>
<%@page import="com.oracle.dao.UsersDao"%>
<%@page import="java.util.List"%>

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
      //java代码
      Object o =session.getAttribute("user");
      String name="";
      if(o!=null){
    	  name=o.toString();
      }
      
  %>
    欢迎<%=name %>登录本网站
    <br>
   <table border="1" width="600">
       <tr>
           <th>用户编号</th>
           <th>用户的名称</th>
           <th>用户的密码</th>
           <th>操作</th>
       </tr>
       <%
           //java代码
           UsersDao dao=new UsersDaoImpl();
           List<Users> list=dao.getAllUsers();
           for(int i=0;i<list.size();i++){
        	   Users user=list.get(i);
        	%>   
        	  <tr>
        	       <td><%=user.getId() %></td>
        	       <td><%=user.getName() %></td>
        	       <td><%=user.getPwd() %></td>
        	       <td><a href="view.jsp?id=<%=user.getId()%>">查看</a></td>
        	  </tr> 
        	   
          <% }%> 
     
   </table>
   
   
   
   
   
   
   
   
</body>
</html>
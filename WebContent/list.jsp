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
      //java����
      Object o =session.getAttribute("user");
      String name="";
      if(o!=null){
    	  name=o.toString();
      }
      
  %>
    ��ӭ<%=name %>��¼����վ
    <br>
   <table border="1" width="600">
       <tr>
           <th>�û����</th>
           <th>�û�������</th>
           <th>�û�������</th>
           <th>����</th>
       </tr>
       <%
           //java����
           UsersDao dao=new UsersDaoImpl();
           List<Users> list=dao.getAllUsers();
           for(int i=0;i<list.size();i++){
        	   Users user=list.get(i);
        	%>   
        	  <tr>
        	       <td><%=user.getId() %></td>
        	       <td><%=user.getName() %></td>
        	       <td><%=user.getPwd() %></td>
        	       <td><a href="view.jsp?id=<%=user.getId()%>">�鿴</a></td>
        	  </tr> 
        	   
          <% }%> 
     
   </table>
   
   
   
   
   
   
   
   
</body>
</html>
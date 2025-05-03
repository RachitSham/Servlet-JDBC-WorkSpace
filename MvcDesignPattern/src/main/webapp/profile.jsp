<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.in.workspace.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>

    <%
        User user = (User) session.getAttribute("session_user");
    %>
    
    <h1 style="color: #8a27a2; text-align: center">Welcome To User Info !!</h1>
    <hr>
    <h2 style="text-align: center">Name: <%= user.getName() %></h2>
    <h2 style="text-align: center">Email: <%= user.getEmail() %></h2>
    <h2 style="text-align: center">City: <%= user.getCity() %></h2>    
    
    <div align="center">
     <h3><a href="logout">Logout</a></h3>
    </div>
    		

</body>
</html>

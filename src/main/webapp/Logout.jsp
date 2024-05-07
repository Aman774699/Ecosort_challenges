<%-- 
    Document   : Logout
    Created on : Mar 24, 2024, 11:59:56 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
     session.removeAttribute("Email");
     session.invalidate();
    response.sendRedirect("index.html");
%>
            %>
    </body>
</html>

<%-- 
    Document   : process
    Created on : 2022-6-10, 21:59:59
    Author     : PC
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="static java.lang.String.*" %>
<html>
<head>
    <title>复制粘贴面板</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String content = request.getParameter("content");
//    out.print(content);
    if(content != null){
        application.setAttribute("clipBoard", content);
    }
    response.sendRedirect("index.jsp");
%>

</body>
</html>
<%-- 
    Document   : register
    Created on : Oct 18, 2020, 3:13:12 PM
    Author     : 838771
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab 5: JSTL</title>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="POST" action="">
        <label>Username: 
            <input type="text" name="user" value="">
        </label>
        
        <input type="submit" name="register" value="Register name" >
        <input type="hidden" name="action" value="register">
        </form>
        
    </body>
</html>

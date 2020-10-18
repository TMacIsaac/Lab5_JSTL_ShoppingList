<%-- 
    Document   : shoppingList
    Created on : Oct 18, 2020, 3:13:30 PM
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
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout">Logout</a>
        <h3>List</h3>
        <form method="POST" action="ShoppingList?action=add">
            <label>Add Item: 
                <input type="text" name="addItem" value="">
                
            </label>
            <input type="submit" name="submit" value="Add">
        </form>
        <form method="POST" action="ShoppingList?action=delete"
        <c:forEach items="${list}" var="item">
            <br>
            <label>
            <input type="radio" name="itemRadio" value="${item}"><c:out value="${item}"/> 
            </label>
            <br>
        </c:forEach>
            <input type="submit" name="delete"  value="Delete">
    </body>
</html>

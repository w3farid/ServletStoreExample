<%@page import="com.store.Book"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table>
<%
    HashMap map = (HashMap) application.getAttribute("books");
    Iterator it = map.values().iterator();
    while (it.hasNext()) {
        Book book = (Book) it.next();

%>
<tr>
    <td><%= book.getName()%></td>
    <td><%= book.getPrice()%></td>
    <td><a href="CartAction?add=true&id=<%= book.getId()%>">Add to Cart</a></td>
</tr>
<%}%>
<table>

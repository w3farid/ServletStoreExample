
<%@page import="com.store.Book"%>
<%@page import="com.store.Cart"%>
<%@page import="java.util.Iterator"%>
<%  
    Iterator  i = ((Cart) session.getAttribute("cart")).getItems();

%>
<h1>Current Cart contents</h1>
<table>
    <%while(i.hasNext()){%>
        <tr>
            <%Book book = (Book)i.next();%>
            <td><%= book.getName()%></td>
            <td><%= book.getPrice()%></td>
        </tr>
    <%}%>
</table>
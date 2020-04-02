<%@ page import="com.epam.models.Pizzeria" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizzerias</title>
</head>
<body>
    <h1>Hello world from index jsp!</h1>

    <table border ="1" width="500" align="center">
        <%
            List<Pizzeria> pizzerias = (List<Pizzeria>)request.getAttribute("pizzeriaList");
            for (Pizzeria pizzeria: pizzerias){
        %>
        <tr>
            <td><%=pizzeria.getId()%></td>
            <td><%=pizzeria.getAddress()%></td>
            <td><%=pizzeria.getWorkingHours()%></td>
        </tr>
        <%}%>
    </table>
    <hr>
</body>
</html>

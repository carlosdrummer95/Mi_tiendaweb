<%@ page import="models.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head><title>Panel</title></head>
<body>
<h2>Bienvenido, <%= user.getUsername() %>!</h2>
<a href="logout.jsp">Cerrar sesión</a>
</body>
</html>


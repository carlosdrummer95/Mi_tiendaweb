package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import models.UserDAO;

public class ConfirmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        UserDAO dao = new UserDAO();
        if (dao.confirmUser(email)) {
            response.sendRedirect("login.jsp?confirmed=1");
        } else {
            response.sendRedirect("confirm.jsp?error=1");
        }
    }
}


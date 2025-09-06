package controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import models.User;
import models.UserDAO;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Capturar los parámetros del formulario
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Crear objeto User con el nuevo constructor
        User user = new User(username, email, password, false);

        // Guardar en la base de datos
        UserDAO dao = new UserDAO();
        boolean registrado = dao.register(user);

        if (registrado) {
            // Redirigir a confirmación
            response.sendRedirect("confirm.jsp");
        } else {
            // Si hubo error, regresar al registro con un mensaje
            response.sendRedirect("register.jsp?error=1");
        }
    }
}



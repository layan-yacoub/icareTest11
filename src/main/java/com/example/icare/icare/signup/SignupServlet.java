/*package com.example.icare.signup;
import com.example.icare.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.Serial;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Perform any validation or sanitization on the input data

        // Create user account
        User user = new User(firstName, lastName, email, password, role);
        // Save the user to the database or perform any necessary operations

        switch (role) {
            case "Patient" -> response.sendRedirect("patient-signup.jsp"); // Redirect to the patient signup page
            case "Nutritionist" ->
                    response.sendRedirect("nutritionist-signup.jsp"); // Redirect to the nutritionist signup page
            case "Restaurant" ->
                    response.sendRedirect("restaurant-signup.jsp"); // Redirect to the restaurant signup page
            default ->
                    response.sendRedirect("error-page.jsp"); // Redirect to an error page if the userType is not recognized
        }
    }
}*/
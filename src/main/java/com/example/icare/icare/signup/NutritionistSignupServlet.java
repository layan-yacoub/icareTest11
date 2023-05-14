/*package com.example.icare.signup;

import com.example.icare.domain.Nutritionist;
import com.example.icare.user.Role;
import com.example.icare.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.nio.file.FileStore;
import java.util.Objects;

@WebServlet("/nutritionist-signup")
public class NutritionistSignupServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private FileStore session;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("n_first_name");
        String lastName= request.getParameter("n_last_name");
        String location = request.getParameter("location");
        String centerName= request.getParameter("center_name");
        byte[] centerLicense = request.getParameter("center_license").getBytes();
        byte[] nutritionistLicense = request.getParameter(" nutritionist_license").getBytes();
        int experience = Integer.parseInt(request.getParameter("experience "));


        // Perform any validation or sanitization on the input data
        // Retrieve the user object from the session
        User user = (User) session.getAttribute("user");

        // Check if the user object exists in the session
        if (user != null) {
            // Forward the request to the nutritionist signup JSP
            request.getRequestDispatcher("/nutritionistSignup.jsp").forward(request, response);
        } else {
            // User object not found in the session, handle the error or redirect to another page
            response.sendRedirect("login.jsp"); // Redirect to login page, for example
        }


        Nutritionist nutritionist = new Nutritionist();

        // Set the user's profile information and role

        nutritionist.setN_first_name(firstName);
        nutritionist.setN_last_name(lastName);
        nutritionist.setCenter_name(centerName);
        nutritionist.setLocation(location);
        nutritionist.setCenter_license(centerLicense);
        nutritionist.setNutritionist_license(nutritionistLicense);
        nutritionist.setExperience (experience );

        assert user != null;
        user.setRole("Nutritionist");



        // Save the user to the database or perform any necessary operations

        // Redirect to the patient dashboard page
        response.sendRedirect("nutritionist-dashboard.jsp");
    }}
    */

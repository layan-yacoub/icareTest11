package com.example.icare.icare.signup;/*

import com.example.icare.icare.domain.Patient;
import com.example.icare.icare.user.Role;
import com.example.icare.icare.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.Serial;
import java.nio.file.FileStore;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@WebServlet("/patient-signup")
public class PatientSignupServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private FileStore session;

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String city = request.getParameter("city");
        Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        String lifestyle = request.getParameter("lifestyle");
        String Disease = request.getParameter("Disease");


        // Perform any validation or sanitization on the input data
        // Retrieve the user object from the session
        User user = (User) session.getAttribute("user");

        // Check if the user object exists in the session
        if (user != null) {
            // Forward the request to the patient signup JSP
            request.getRequestDispatcher("/patientSignup.jsp").forward(request, response);
        } else {
            // User object not found in the session, handle the error or redirect to another page
            response.sendRedirect("login.jsp"); // Redirect to login page, for example
        }

        Patient patient= new Patient();

        // Set the user's profile information and role

        patient.setCity(city);
        patient.setDob(dob);
        patient.setGender(gender);
        patient.setHeight(height);
        patient.setWeight(weight);
        patient.setLifestyle(lifestyle);
        patient.setDisease(Disease);


        assert user != null;
        user.setRole("Patient");


        // Save the user to the database or perform any necessary operations

        // Redirect to the patient dashboard page
        response.sendRedirect("patient-dashboard.jsp");
    }
}*/
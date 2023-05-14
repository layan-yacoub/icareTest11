package com.example.icare.icare.signup; /****


import com.example.icare.icare.domain.Restaurant;
import com.example.icare.icare.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import javax.net.ssl.HandshakeCompletedEvent;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.FileStore;


@WebServlet("/Restaurant-signup")
public class RestaurantSignupServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        String username = (String)request.getAttribute("un");
        session.setAttribute("UserName", username);
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String phone_number = request.getParameter("phone_number");
        String restaurant_name = request.getParameter("restaurant_name");
        String restaurant_location = request.getParameter("restaurant_location");
        byte[] restaurant_license = request.getParameter("restaurant_license").getBytes();
        String social_media = request.getParameter("social_media");


        HttpSession session = request.getSession();
        session.setAttribute("restaurant_name", restaurant_name );
        session.getAttribute("restaurant_name");//return type is Object here

        // Perform any validation or sanitization on the input data
        // Retrieve the user object from the session
        User user = (User) session.getAttribute("user");

        // Check if the user object exists in the session
        if (user != null) {
            // Forward the request to the Restaurant signup JSP
            request.getRequestDispatcher("/RestaurantSignup.jsp").forward(request, response);
        } else {
            // User object not found in the session, handle the error or redirect to another page
            response.sendRedirect("login.jsp"); // Redirect to login page, for example
        }

        Restaurant restaurant= new Restaurant();

        // Set the user's profile information and role
        restaurant.setRestaurant_location(restaurant_location);
        restaurant.setRestaurant_license(restaurant_license);
        restaurant.setPhone_number(phone_number);
        restaurant.setRestaurant_name(restaurant_name);
        restaurant.setSocial_media(social_media);

        assert user != null;
        user.setRole("Restaurant");

        // Save the user to the database or perform any necessary operations

        // Redirect to the Restaurant dashboard page
        response.sendRedirect("Restaurant-dashboard.jsp");
    }
}*/
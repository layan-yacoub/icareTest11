package com.example.icare.icare.user;

import com.example.icare.icare.registrationRequest.LoginRequest;
import com.example.icare.icare.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //is used in REST Web services & mark class as Controller Class

@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Find user by email
        User user = userService.findByEmail(loginRequest.getEmail());
        if (user == null) {
            // User not found
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        } else if (!user.getPassword().equals(loginRequest.getPassword())) {
            // Password does not match
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        } else {
            // Password matches, redirect to appropriate dashboard based on user role
            return switch (user.getRole()) {
                case PATIENT -> ResponseEntity.ok("redirect:/patient/dashboard");
                case NUTRITIONIST -> ResponseEntity.ok("redirect:/nutritionist/dashboard");
                case RESTAURANT -> ResponseEntity.ok("redirect:/restaurant/dashboard");
                case ADMIN -> ResponseEntity.ok("redirect:/admin/dashboard");
                default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown role");
            };
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session, User user) {

        String role = String.valueOf(user.getRole());

        // Invalidate session to clear user-specific data
        session.invalidate();

        // Determine the redirect URL based on the user's role
        String redirectUrl;
        switch (role) {
            case "PATIENT" -> redirectUrl = "/patient/login";
            case "NUTRITIONIST" -> redirectUrl = "/nutritionist/login";
            case "RESTAURANT" -> redirectUrl = "/restaurant/login";
            case "ADMIN" -> redirectUrl = "/admin/login";
            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown role");
            }
        }

        // Return successful logout response with redirect URL to the appropriate login page
        return ResponseEntity.ok().body(redirectUrl);
    }


}




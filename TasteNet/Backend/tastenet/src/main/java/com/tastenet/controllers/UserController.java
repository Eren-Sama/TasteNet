package com.tastenet.controllers;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastenet.models.BusinessAdmin;
import com.tastenet.models.BusinessVerificationRequest;
import com.tastenet.models.User;
import com.tastenet.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Fetch all users
    @GetMapping
    public ResponseEntity<List<Object>> getAllUsers() {
        List<Object> usersAndAdmins = userService.findAllUsersAndBusinessAdmins();
        return new ResponseEntity<>(usersAndAdmins, HttpStatus.OK);
    }

    // Get a single user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Register a new user or business admin based on the input
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, Object> requestBody) {
        try {
            // Registering normal user
            User user = new User();
            user.setUsername((String) requestBody.get("username"));
            user.setEmail((String) requestBody.get("email"));
            user.setPassword((String) requestBody.get("password"));

            // Check if this is a business admin registration
            if (requestBody.containsKey("address") && requestBody.containsKey("aadharNumber")) {
                BusinessAdmin businessAdmin = new BusinessAdmin();
                businessAdmin.setEmail((String) requestBody.get("email"));
                businessAdmin.setPassword((String) requestBody.get("password"));
                businessAdmin.setAddress((String) requestBody.get("address"));
                businessAdmin.setAadharNumber((String) requestBody.get("aadharNumber"));

                // Decode the Base64 string for business documents if provided
                if (requestBody.containsKey("businessDocuments")) {
                    String base64Document = (String) requestBody.get("businessDocuments");

                    try {
                        // Attempt to decode the Base64 document
                        byte[] decodedDocument = Base64.getDecoder().decode(base64Document);
                        businessAdmin.setBusinessDocuments(decodedDocument);
                    } catch (IllegalArgumentException e) {
                        // Handle the case where Base64 decoding fails (treat as URL)
                        System.out.println("Invalid Base64 string, treating as URL: " + base64Document);
                        businessAdmin.setBusinessDocumentsUrl(base64Document);  // Save URL if decoding fails
                    }
                }

                // Register business admin
                BusinessAdmin newBusinessAdmin = userService.registerBusinessAdmin(businessAdmin);
                return ResponseEntity.status(HttpStatus.CREATED).body(newBusinessAdmin);
            } else {
                // Register normal user
                User newUser = userService.registerUser(user);
                Map<String, Object> response = new HashMap<>();
                response.put("id", newUser.getId());
                response.put("username", newUser.getUsername());
                response.put("email", newUser.getEmail());
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("An error occurred during registration: " + e.getMessage());
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Delete all users
    @DeleteMapping("/clear-all")
    public ResponseEntity<Void> deleteAllUsers() {
        userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Submit a business verification request for a user
    @PostMapping("/{userId}/verify")
    public ResponseEntity<BusinessVerificationRequest> submitVerificationRequest(@PathVariable Long userId) {
        BusinessVerificationRequest request = userService.submitVerificationRequest(userId);
        return request != null ? new ResponseEntity<>(request, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Approve a business verification request
    @PutMapping("/verify/{requestId}/approve")
    public ResponseEntity<Void> approveVerificationRequest(@PathVariable Long requestId) {
        userService.approveVerificationRequest(requestId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

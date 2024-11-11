package com.tastenet.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastenet.models.BusinessAdmin;
import com.tastenet.models.BusinessVerificationRequest;
import com.tastenet.models.Role;
import com.tastenet.models.User;
import com.tastenet.repositories.BusinessAdminRepository;
import com.tastenet.repositories.BusinessVerificationRequestRepository;
import com.tastenet.repositories.RoleRepository;
import com.tastenet.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BusinessVerificationRequestRepository verificationRequestRepository;
    private final BusinessAdminRepository businessAdminRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       BusinessVerificationRequestRepository verificationRequestRepository,
                       BusinessAdminRepository businessAdminRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.verificationRequestRepository = verificationRequestRepository;
        this.businessAdminRepository = businessAdminRepository;
    }

    // Fetch all users, including regular users and business admins
    public List<Object> findAllUsersAndBusinessAdmins() {
        List<Object> allUsers = new ArrayList<>();
        allUsers.addAll(userRepository.findAll()); // Add regular users
        allUsers.addAll(businessAdminRepository.findAll()); // Add business admins
        return allUsers;
    }

    // Get a single user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Register a new normal user
    public User registerUser(User user) {
        Role userRole = roleRepository.findByName(Role.RoleType.USER.name());
        if (userRole != null) {
            user.getRoles().add(userRole); // Assign USER role to new user
        }
        return userRepository.save(user);
    }

    // Register a new business admin
    public BusinessAdmin registerBusinessAdmin(BusinessAdmin businessAdmin) {
        if (businessAdmin.getAadharNumber() == null || businessAdmin.getAddress() == null) {
            throw new IllegalArgumentException("Address and Aadhar Number must be provided for business registration.");
        }
        businessAdmin.setIsVerified(false); // Default to not verified
        Role businessAdminRole = roleRepository.findByName(Role.RoleType.BUSINESS_ADMIN.name());
        if (businessAdminRole != null) {
            businessAdmin.getRoles().add(businessAdminRole); // Assign BUSINESS_ADMIN role to new business admin
        }
        return businessAdminRepository.save(businessAdmin);
    }

    // Register a user or business admin based on the input
    public Object registerUserOrBusinessAdmin(User user, BusinessAdmin businessAdmin) {
        if (businessAdmin != null) {
            return registerBusinessAdmin(businessAdmin);
        } else {
            return registerUser(user);
        }
    }

    // Submit a verification request for a business admin
    public BusinessVerificationRequest submitVerificationRequest(Long businessAdminId) {
        Optional<BusinessAdmin> businessAdmin = businessAdminRepository.findById(businessAdminId);
        if (businessAdmin.isPresent()) {
            BusinessVerificationRequest request = new BusinessVerificationRequest();
            request.setUser(businessAdmin.get()); // Associate with BusinessAdmin
            request.setRequestDate(new Date());
            request.setStatus("PENDING");
            return verificationRequestRepository.save(request);
        }
        return null;
    }

    // Approve a verification request and mark business admin as verified
    public void approveVerificationRequest(Long requestId) {
        BusinessVerificationRequest request = verificationRequestRepository.findById(requestId).orElse(null);
        if (request != null) {
            BusinessAdmin businessAdmin = request.getUser();
            request.setStatus("APPROVED");
            businessAdmin.setIsVerified(true); // Mark business admin as verified

            // Assign BUSINESS_ADMIN role if not already assigned
            Role businessAdminRole = roleRepository.findByName(Role.RoleType.BUSINESS_ADMIN.name());
            if (businessAdminRole != null) {
                businessAdmin.getRoles().clear(); // Clear existing roles
                businessAdmin.getRoles().add(businessAdminRole); // Assign BUSINESS_ADMIN role
            }

            businessAdminRepository.save(businessAdmin);
            verificationRequestRepository.save(request);
        }
    }

    // Save a user (helper method)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete all users
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

package com.tastenet.controllers;

import com.tastenet.models.Business;
import com.tastenet.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    // Endpoint for BUSINESS_ADMIN-specific dashboard access
    /*@GetMapping("/dashboard")
    public String getBusinessDashboard() {
        return "Welcome to the Business Admin Dashboard!";
    }

    // Fetch all businesses (could be public or require USER role based on your config)
    @GetMapping("/all")
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }/* */

    // Get a specific business by ID
    @GetMapping("/{id}")
    public Business getBusinessById(@PathVariable Long id) {
        return businessService.getBusinessById(id);
    }

    // Create a new business (restricted to BUSINESS_ADMIN role)
    @PostMapping
    public Business createBusiness(@RequestBody Business business) {
        return businessService.saveBusiness(business);
    }

    // Delete a specific business (restricted to BUSINESS_ADMIN role)
    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
    }

    // Add more business-related endpoints as needed
}

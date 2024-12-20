package com.tastenet.services;

import com.tastenet.models.Business;
import com.tastenet.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    public Business saveBusiness(Business business) {
        return businessRepository.save(business);
    }

    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}

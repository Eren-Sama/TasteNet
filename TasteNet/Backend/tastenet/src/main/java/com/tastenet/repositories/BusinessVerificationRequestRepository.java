package com.tastenet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tastenet.models.BusinessVerificationRequest;

public interface BusinessVerificationRequestRepository extends JpaRepository<BusinessVerificationRequest, Long> {
    BusinessVerificationRequest findByUserId(Long userId);
}

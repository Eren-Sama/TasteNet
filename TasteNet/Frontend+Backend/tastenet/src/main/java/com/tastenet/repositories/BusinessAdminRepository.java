package com.tastenet.repositories;

import com.tastenet.models.BusinessAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessAdminRepository extends JpaRepository<BusinessAdmin, Long> {
    BusinessAdmin findByEmail(String email);
}

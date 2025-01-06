package com.tastenet.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "business_verification_requests")
public class BusinessVerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private BusinessAdmin user; // Change to BusinessAdmin

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate = new Date();

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public BusinessAdmin getUser() { 
        return user; 
    }
    public void setUser(BusinessAdmin user) { 
        this.user = user; 
    }

    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }

    public Date getRequestDate() { 
        return requestDate; 
    }
    public void setRequestDate(Date requestDate) { 
        this.requestDate = requestDate; 
    }
}

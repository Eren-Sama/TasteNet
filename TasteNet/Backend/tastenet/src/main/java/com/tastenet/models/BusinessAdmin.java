package com.tastenet.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "business_admins")
public class BusinessAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String aadharNumber;

    @Column(nullable = true)
    private byte[] businessDocuments; // For Base64-encoded document

    @Column(nullable = true)
    private String businessDocumentsUrl; // For URL-based document storage

    @Column(nullable = false)
    private boolean isVerified = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "business_admin_roles",
            joinColumns = @JoinColumn(name = "business_admin_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getAadharNumber() { return aadharNumber; }
    public void setAadharNumber(String aadharNumber) { this.aadharNumber = aadharNumber; }

    // Getter and Setter for businessDocuments (Base64)
    public byte[] getBusinessDocuments() { return businessDocuments; }
    public void setBusinessDocuments(byte[] businessDocuments) { this.businessDocuments = businessDocuments; }

    // Getter and Setter for businessDocumentsUrl
    public String getBusinessDocumentsUrl() { return businessDocumentsUrl; }
    public void setBusinessDocumentsUrl(String businessDocumentsUrl) { this.businessDocumentsUrl = businessDocumentsUrl; }

    public boolean isVerified() { return isVerified; }
    public void setIsVerified(boolean isVerified) { this.isVerified = isVerified; }

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
}

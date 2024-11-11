package com.tastenet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/*import java.util.Set;*/

/*import com.fasterxml.jackson.annotation.JsonIgnoreProperties;*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("role")
    @Column(nullable = false, unique = true)
    private String name;
    

    /*@ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private Set<User> users;*/

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /*public Set<User> getUsers() { return users; }
    public void setUsers(Set<User> users) { this.users = users; }*/

    public enum RoleType {
        USER, BUSINESS_ADMIN
    }
    
}

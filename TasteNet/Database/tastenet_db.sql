-- Create the database
CREATE DATABASE tastenet_db;

-- Use the newly created database
USE tastenet_db;

-- Drop existing tables to avoid conflicts (if they exist)
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS business_verification_requests;

-- Create the users table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    aadhar_number VARCHAR(255) UNIQUE,
    business_documents BLOB,
    is_verified BOOLEAN DEFAULT FALSE
);

-- Create the roles table
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Create the user_roles table to link users with roles
CREATE TABLE user_roles (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Insert default roles into the roles table
INSERT INTO roles (name) VALUES ('USER'), ('ADMIN'), ('BUSINESS_ADMIN');

-- Test inserts for users (optional)
INSERT INTO users (email, password) VALUES ('testuser@example.com', 'password123');

-- Link a user with a role (make sure the user_id and role_id are correct)
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);  -- Adjust user_id as necessary

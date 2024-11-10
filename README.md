# TasteNet
TasteNet is a community-driven review platform for hotels, cafes, and restaurants tailored for food lovers and travelers alike! Discover authentic user reviews, easily book table reservations, and find the perfect dining spot based on location and cuisine. Join a vibrant community of food lovers and share your culinary experiences.

# Key Features ✨
1. User Reviews: Read and contribute authentic reviews from fellow users to help you make informed dining choices.
2. Table Reservations: Seamlessly book tables at your favorite restaurants directly through the app.
3. Search & Filter: Easily find the perfect spot based on location, cuisine, rating, and more.
4. Community Engagement: Join a vibrant community of food enthusiasts and share your culinary adventures.

Whether you're looking for the best brunch spot or planning a special night out, TasteNet connects you with the best dining options and ensures you never miss out on a great meal!

Contribute to the project or explore the code to see how you can enhance the TasteNet experience!

# Users Features 🪄

***User Features***
1. User Registration and Login with multiple options (email, phone OTP, Google)
2. Profile Management
3. Country-based User Categorization
4. Secure Password Management
5. Email Verification System

***Admin Features***
1. User Management Dashboard
2. User Data Analytics
3. Email Management
4. Access Control
5. User Activity Monitoring

***Business Admin Features***
1. Business Registration and Verification
2. Business Management Tools
3. Moderation Tools for Reviews
4. Analytics Dashboard
5. Community Engagement (Events, Forums)

# Technical Requirements 🛠️
● JDK 11<br>
● Apache Maven 3.8 or higher<br>
● MySQL 8.0<br>
● Spring Boot 3.4.0<br>
● IntelliJ IDEA or Eclipse IDE or VS Code<br>
● Git<br>

# Project Structure 📂
```
TasteNet/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── tastenet/
│   │   │   │           ├── controller/
│   │   │   │           │   ├── UserController.java
│   │   │   │           │   └── AdminController.java
│   │   │   │           ├── model/
│   │   │   │           │   ├── User.java
│   │   │   │           │   └── BusinessVerificationRequest.java
│   │   │   │           ├── repository/
│   │   │   │           │   ├── UserRepository.java
│   │   │   │           │   └── BusinessVerificationRequestRepository.java
│   │   │   │           ├── service/
│   │   │   │           │   ├── UserService.java
│   │   │   │           │   └── BusinessService.java
│   │   │   │           └── util/
│   │   │   │               └── SecurityConfig.java
│   │   ├── resources/
│   │   │   └── application.properties
│   └── pom.xml
├── database/
│   └── tastenet_db.sql
```

# Dependencies 📚
```xml
<dependencies>
		<dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
        </dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

# Database Configuration 🗄️
### MySQL Setup
1. Create the database:
```sql
CREATE DATABASE tastenet_db;
```
2. Now Use the newly created database:
```sql
USE tastenet_db;
```
3. Copy or Use the SQL file provided in Database folder

# Installation and Setup 🚀
### Prerequisites
1. Install JDK 11
2. Install Maven
3. Install MySQL 8.0
4. Install your preferred IDE (IntelliJ IDEA or Eclipse)

### Steps
1. Clone the repository:
```bash
git clone https://github.com/Eren-Sama/TasteNet.git
```
2. Configure database connection in ``TasteNet/Backend/tastenet/src/main/resources/application.properties``
```bash
spring.application.name=TasteNet
spring.security.user.name=Your Username
spring.security.user.password=Your Password
spring.datasource.url=jdbc:mysql://localhost:3306/tastenet_db
spring.datasource.username=root
spring.datasource.password=Your SQL Password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
3. Build the project:
```bash
mvn clean install
```
# Running the Project ▶️
### Development
1. Run the Spring Boot application:
```
mvn spring-boot:run
```
Or
``Run TasteNetApplication.java`` at path - ``TasteNet/Backend/tastenet/src/main/java/com/tastenet``<br>

2. Access the application at http://localhost:8080.
# Production Deployment
1. Build for production:
```bash
mvn clean package
```
2. Deploy the generated JAR/WAR file to your production server.

# Testing 🧪
● Run the tests using:
```bash
mvn test
```

#Contact 📧
Eklavya Mohan Agrawal - @Eren-Sama<br>
Project Link - https://github.com/Eren-Sama/TasteNet

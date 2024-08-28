Tabela Finanças
Tabela Finanças is a financial management application built using Java, Spring Boot, PostgreSQL, and SpringDoc OpenAPI. This project allows users to manage their financial data, including tracking income, expenses, and viewing financial summaries.

Features
User Management: Create, retrieve, update, and delete user accounts.
Financial Data Management: Add, retrieve, and delete financial records associated with user accounts.
API Documentation: Interactive API documentation with Swagger UI.
PostgreSQL Database: Persistent storage for users and financial data.

Technologies Used
Java 17
Spring Boot 3.x
Spring Data JPA
Spring Web
Spring Validation
PostgreSQL
SpringDoc OpenAPI
Maven: Dependency management and build automation.
JUnit & Mockito: Testing framework.
Prerequisites
Java 17 or later installed
PostgreSQL installed and running
Maven installed

Getting Started

Clone the Repository

git clone https://github.com/yourusername/tabela-financas.git

cd tabela-financas
Database Setup
Create a PostgreSQL database:
CREATE DATABASE tabelafinanciasdb;
Configure your PostgreSQL credentials in the application.properties file:

properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/tabelafinanciasdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

Build and Run the Application

mvn clean install
mvn spring-boot:run
Accessing the API Documentation
Once the application is running, you can access the Swagger UI for API documentation at:

http://localhost:8080/swagger-ui/index.html

API Endpoints

User Management
GET /api/users: Retrieve all users.

POST /api/users: Create a new user.

GET /api/users/{id}: Retrieve a user by ID.

DELETE /api/users/{id}: Delete a user by ID.

Financial Data Management
GET /api/finances: Retrieve all financial records.

POST /api/users/addfinance/{id}: Add financial data to a user.

GET /api/finances/{id}: Retrieve financial data by ID.

DELETE /api/finances/{id}: Delete financial data by ID.

Testing
This project includes unit tests written using JUnit and Mockito. To run the tests, execute
mvn test

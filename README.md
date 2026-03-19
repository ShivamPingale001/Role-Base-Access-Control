# Role-Based Access Control (RBAC) System

This project is a Spring Boot application that implements user authentication and role-based access control.
Users can register, login, and access different APIs based on their role (USER or ADMIN).

---

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database

---

## Features

- User Registration
- User Login
- Role-Based Access Control
- REST APIs

---

## Project Structure

controller - Handles API requests  
entity - Contains User and Role classes  
repository - Database interaction  
config - Security configuration

---

## How to Run the Project

1. Clone the repository

git clone https://github.com/ShivamPingale001/Role-Base-Access-Control

2. Open the project in Eclipse / STS

3. Run the main application class

4. The server will start on

http://localhost:9090

---

## API Endpoints

Register User
POST /api/auth/register

Login User
POST /api/auth/login

Public API
GET /api/public

User API
GET /api/user

Admin API
GET /api/admin

---

## Testing

You can test APIs using Postman.

Example Register Request

{
"name": "Shivam",
"email": "shivam@gmail.com",
"password": "1234",
"role": "ADMIN"
}

---

## GitHub Repository

https://github.com/ShivamPingale001/Role-Base-Access-Control

# Product Catalogue Service

A RESTful web service for managing product information, built with **Java 17**, **Spring Boot**, **PostgreSQL**, and **Docker**.

## 📚 **Table of Contents**
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
    - [1. Clone the Repository](#1-clone-the-repository)
    - [2. Configure Environment Variables](#2-configure-environment-variables)
    - [3. Start the Application with Docker Compose](#3-start-the-application-with-docker-compose)
    - [4. Access the Application](#4-access-the-application)
- [Endpoints](#endpoints)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)

---

## ⚙️ **Technologies Used**
- Java 17
- Spring Boot
- PostgreSQL
- Docker & Docker Compose
- Caffeine Cache

---

## ✅ **Prerequisites**
Make sure you have the following installed:
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Git](https://git-scm.com/)

---

## 🛠️ **Setup Instructions**

### **1. Clone the Repository**
```bash
git clone https://github.com/your-username/product-catalogue.git
cd product-catalogue
```

### **2. Configure Environment Variables**
Copy the sample `.env` file and configure your environment:
```bash
cp sample.env .env
```
Edit the `.env` file to match your local setup:
```env
SERVER_PORT=8005
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/product_catalogue
SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=1234
CONVERSION_API_URL=https://api.hnb.hr/tecajn-eur/v3
```

### **3. Start the Application with Docker Compose**
Run the following command to start the application and database:
```bash
docker-compose up --build
```
This will build the application and start the PostgreSQL and Spring Boot services.

### **4. Access the Application**
- Application: [http://localhost:8005](http://localhost:8005)
- Database: Accessible on port `5432` (via tools like pgAdmin or DBeaver)

---

## 📑 **Endpoints**
- **POST /api/v1/products**: Create a new product
- **GET /api/v1/products/{id}**: Get product details by ID
- **GET /api/v1/products**: Get a list of products

---

## 🧪 **Testing**
Run tests locally with:
```bash
./gradlew test
```

---

## 🐞 **Troubleshooting**
- **Database connection issues:** Verify that your `.env` file has the correct database credentials.
- **Port conflicts:** Ensure that no other service is using ports `8005` (App) or `5432` (PostgreSQL).

---


# 📢 Advertisement Service - Spring Boot Backend

This is a Spring Boot-based backend service for managing advertisements posted by users (farmers). It supports uploading ads with location, price, images, and tracks view counts. It is designed to integrate with a frontend (e.g., React Native) and provides RESTful APIs.

---

## 📦 Features

- ✅ Create, read, and list advertisements
- 🌍 Store geolocation with ads (latitude & longitude)
- 📸 Upload and serve ad images
- 👁️ Track view count per advertisement (supports viewerId)
- 🔧 CORS configured for cross-origin frontend access

---

## 🗃️ Project Structure

| File | Description |
|------|-------------|
| `Advertisement.java` | Entity class representing an ad |
| `Location.java` | Embedded class for latitude & longitude |
| `AdvertisementRepository.java` | Spring Data JPA repository |
| `AdvertisementService.java` | Business logic to handle ad operations |
| `AdvertisementController.java` | REST controller exposing ad endpoints |
| `ApiResponse.java` | Standard API response wrapper |
| `WebConfig.java` | CORS and static resource configuration |
| `AdvertisementApplication.java` | Main Spring Boot application |

---

## 🔧 Setup Instructions

### ✅ Prerequisites

- Java 17+
- Maven
- MySQL or H2 Database (based on your config)
- (Optional) Postman or any REST client

---

### 🚀 Run the Application

```bash
# Run the app
./mvnw spring-boot:run

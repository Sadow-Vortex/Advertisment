# 🧺 Advertisement API 🌾

A Spring Boot backend for managing and displaying advertisements with image upload, view tracking, and category-based filtering. Designed for the **Kisan Seva** platform.

---

## 🧰 Tech Stack

- **Java 23**
- **Spring Boot**
- **Spring Data JPA**
- **H2 / MySQL (configurable)**
- **Multipart File Upload**
- **REST APIs**

---

## 📂 Project Structure

```
src/
├── controller/
│   └── AdvertisementController.java
├── entity/
│   ├── Advertisement.java
│   └── Location.java
├── repository/
│   └── AdvertisementRepository.java
├── service/
│   └── AdvertisementService.java
├── config/
│   └── WebConfig.java
├── response/
│   └── ApiResponse.java
└── AdvertisementApplication.java
```

---

## 🔑 Features

- ✅ Add new advertisements
- ✅ Fetch all ads / ads by ID
- ✅ Get ads by Category / Subcategory
- ✅ View count tracking (`?viewerId=1`)
- ✅ Serve uploaded images from `uploads` folder
- ✅ Filter active ads (`adv_Status = true`)
- ✅ Sort ads by popularity / recent date

---

## 📦 API Endpoints

### ➕ Add Advertisement

```
POST /adv
```

**Request Body:**

```json
{
  "advUserID": 1,
  "adv_CategoryID": 2,
  "advSubCategoryID": 4,
  "adv_Title": "Fresh Apples",
  "adv_Description": "Sweet and crispy apples from Himachal.",
  "adv_Unit": 100,
  "adv_Price": 150,
  "adv_Status": true,
  "adv_Image": "http://localhost:2012/uploads/apple.jpg",
  "adv_Address": "Shimla, HP",
  "adv_Location": {
    "latitude": 31.1048,
    "longitude": 77.1734
  }
}
```

---

### 📥 Get All Ads

```
GET /adv
```

---

### 🔍 Get Ad by ID (with View Count)

```
GET /adv/{id}?viewerId=1
```

- Increments view count per user.

---

### 🧾 Get Ads by Category

```
GET /adv/category/{categoryId}
```

---

### 🗂️ Get Ads by Subcategory

```
GET /adv/subCategory/{subCategoryId}
```

---

### 📤 Upload Advertisement Image

```
POST /adv/upload
```

**Request Type:** `multipart/form-data`  
**Form Field:** `file` (Image)

**Example using cURL:**

```bash
curl -X POST http://localhost:2012/adv/upload \
  -H "Content-Type: multipart/form-data" \
  -F "file=@/path/to/image.jpg"
```

**Response:**

```json
{
  "status_code": 200,
  "status_msg": "Success",
  "data": "http://localhost:2012/uploads/filename.jpg"
}
```

---

## 🌐 Accessing Uploaded Images

Uploaded files are served statically via:

```
http://localhost:2012/uploads/<filename>
```

### Example

```
http://localhost:2012/uploads/mango.jpg
```

**Enabled in** `WebConfig.java`:

```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:uploads/");
}
```

> ✅ Ensure `/uploads` folder exists and is writable.

---

## ⚙️ Run Locally

1. Clone the repo  
2. Make sure `/uploads/` directory is present  
3. Run the app:

```bash
./mvnw spring-boot:run
```

4. Access:

```
http://localhost:2012/adv
```

---

## 📞 Contact

Made with ❤️ for **Kisan Seva**  
Maintainer: [Rishi Prasad Manna](mailto:rishimanna33@gmail.com)

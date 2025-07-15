🧺 Advertisement API - Kisan Seva 🌾
A Spring Boot backend for managing and displaying advertisements with image upload, view tracking, and category-based filtering. Designed for the Kisan Seva platform.

🧰 Tech Stack
Java 23

Spring Boot

Spring Data JPA

H2 / MySQL (configurable)

Multipart File Upload

REST APIs

📂 Project Structure
arduino
Copy
Edit
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
🔑 Features
✅ Add new advertisements

✅ Fetch all ads / ads by ID

✅ Get ads by Category / Subcategory

✅ View count tracking (?viewerId=1)

✅ Serve uploaded images from uploads folder

✅ Filter active ads (adv_Status = true)

✅ Sort ads by popularity / recent date

📦 API Endpoints
➕ Add Advertisement
bash
Copy
Edit
POST /adv
Request Body:

json
Copy
Edit
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
📥 Get All Ads
bash
Copy
Edit
GET /adv
🔍 Get Ad by ID (with View Count)
bash
Copy
Edit
GET /adv/{id}?viewerId=1
Increments view count per user.

🧾 Get Ads by Category
bash
Copy
Edit
GET /adv/category/{categoryId}
🗂️ Get Ads by Subcategory
bash
Copy
Edit
GET /adv/subCategory/{subCategoryId}
📤 Upload Advertisement Image
bash
Copy
Edit
POST /adv/upload
Request Type: multipart/form-data
Form Field: file (Image)

Example using cURL:

bash
Copy
Edit
curl -X POST http://localhost:2012/adv/upload \
  -H "Content-Type: multipart/form-data" \
  -F "file=@/path/to/image.jpg"
Response:

json
Copy
Edit
{
  "status_code": 200,
  "status_msg": "Success",
  "data": "http://localhost:2012/uploads/filename.jpg"
}
🌐 Accessing Uploaded Images
Uploaded files are served statically via:

bash
Copy
Edit
http://localhost:2012/uploads/<filename>
Example
bash
Copy
Edit
http://localhost:2012/uploads/mango.jpg
Enabled in WebConfig.java:

java
Copy
Edit
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:uploads/");
}
✅ Ensure /uploads folder exists and is writable.

⚙️ Run Locally
Clone the repo

Make sure /uploads/ directory is present

Run the app:

bash
Copy
Edit
./mvnw spring-boot:run
Access:

bash
Copy
Edit
http://localhost:2012/adv
📞 Contact
Made with ❤️ for Kisan Seva
Maintainer: Rishi Prasad Manna


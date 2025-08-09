# Java Inventory Management System

## 📌 Project Overview
The **Java Inventory Management System** is a simple console-based application for managing product inventory in a store. It allows users to add, view, update, delete, and search products. This project is built using **Java** and **JDBC** (for database connectivity) without JavaFX, making it suitable for beginners to understand core Java concepts.

---

## ✨ Features
- Add new products with details (name, quantity, price, etc.)
- View all available products in the inventory
- Update product details
- Delete products from the inventory
- Search for products by name or ID
- Persistent storage using MySQL database

---

## 🛠️ Technologies Used
- **Java** (Core concepts: OOP, Collections, Exception Handling)
- **JDBC** (Java Database Connectivity)
- **MySQL** (Database storage)
- **Eclipse / IntelliJ IDEA** (IDE)

---

## 📂 Project Structure
InventoryManagement/
│── src/
│ ├── Main.java
│ ├── Product.java
│ ├── ProductDAO.java
│ ├── DBConnection.java
│── database/
│ ├── inventory.sql
│── README.md

---

## ⚙️ Installation & Setup
### 1️⃣ Prerequisites
- Install **Java JDK 8+**
- Install **MySQL Server**
- Install **IDE** (Eclipse / IntelliJ IDEA)

### 2️⃣ Database Setup
1. Open MySQL and create the database:
   ```sql
   CREATE DATABASE inventory_db;
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    quantity INT,
    price DECIMAL(10, 2)
);
3️⃣ Configure Database Connection
In DBConnection.java, update:

java

private static final String URL = "jdbc:mysql://localhost:3306/inventory_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";

4️⃣ Run the Application
Open the project in your IDE

Compile and run Main.java

Follow the on-screen menu to manage inventory
👨‍💻 Author
Vijay Kumar
📧 Email: Vijayappugowda@gmail.com


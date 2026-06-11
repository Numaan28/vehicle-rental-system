# 🚗 Vehicle Rental System

A simple **Java Console-Based Vehicle Rental System** developed using **Object-Oriented Programming (OOP)** concepts. This project allows users to view vehicles, rent vehicles, return rented vehicles, search for vehicles, and maintain rental history.

---

## 📌 Project Information

**Project Title:** Vehicle Rental System
**Developed By:** Salman
**ERP ID:** RU-25-11264
**Course:** B.Tech CSE (AI & ML)
**Section:** B
**University:** Rungta International Skills University
**Professor:** Santanu Sasmal

---

## 📖 Project Description

The Vehicle Rental System is a Java-based application designed to automate the vehicle rental process. It provides a simple and user-friendly interface where customers can rent and return vehicles while maintaining rental records.

The system uses Java collections (`ArrayList`) to store vehicle and rental information and follows Object-Oriented Programming principles such as:

* Encapsulation
* Classes and Objects
* Inheritance Ready Structure
* Data Abstraction
* Method Reusability

---

## ✨ Features

### 1. View Vehicles

* Displays all available and rented vehicles.
* Shows vehicle details such as:

  * Vehicle ID
  * Brand
  * Model
  * Rent Per Day
  * Availability Status

### 2. Rent Vehicle

* Enter customer details.
* Select an available vehicle.
* Specify rental duration.
* Generate rental receipt.
* Confirm rental before booking.

### 3. Return Vehicle

* Return a rented vehicle using Vehicle ID.
* Updates vehicle availability automatically.

### 4. Rental History

* Stores all rental transactions.
* Displays customer and vehicle details along with billing information.

### 5. Search Vehicle

* Search any vehicle using Vehicle ID.
* Shows complete vehicle information.

### 6. Input Validation

* Prevents invalid numerical inputs.
* Ensures smooth user experience.

---

## 🏗️ Class Structure

### Vehicle Class

Stores vehicle information.

#### Attributes

* id
* brand
* model
* rentPerDay
* available

#### Methods

* getId()
* getBrand()
* getModel()
* getRentPerDay()
* isAvailable()
* rentVehicle()
* returnVehicle()

---

### Customer Class

Stores customer details.

#### Attributes

* name
* phone

#### Methods

* getName()
* getPhone()

---

### Rental Class

Stores rental transaction information.

#### Attributes

* customer
* vehicle
* days

#### Methods

* calculateBill()

---

### VehicleRentalSystem Class

Main class containing system operations.

#### Functions

* main()
* viewVehicles()
* rentVehicle()
* returnVehicle()
* showHistory()
* searchVehicle()
* getIntInput()

---

## 💻 Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* Scanner Class
* Console-Based Interface

---

## 📂 Sample Vehicles

| ID | Brand         | Model       | Rent/Day |
| -- | ------------- | ----------- | -------- |
| 1  | Honda         | City        | ₹1500    |
| 2  | Hyundai       | Creta       | ₹2000    |
| 3  | Royal Enfield | Classic 350 | ₹800     |
| 4  | Maruti        | Swift       | ₹1200    |
| 5  | TVS           | Apache RTR  | ₹700     |

---

## ▶️ How to Run

### Step 1: Save File

Save the source code as:

```bash
VehicleRentalSystem.java
```

### Step 2: Compile

```bash
javac VehicleRentalSystem.java
```

### Step 3: Run

```bash
java VehicleRentalSystem
```

---

## 📋 Menu Options

```text
=================================
     VEHICLE RENTAL SYSTEM
=================================
1. View Vehicles
2. Rent Vehicle
3. Return Vehicle
4. Rental History
5. Search Vehicle
6. Exit
=================================
```

---

## 🎯 Learning Outcomes

By developing this project, students can learn:

* Java Programming Fundamentals
* Object-Oriented Programming
* ArrayList Operations
* User Input Handling
* Console-Based Application Development
* Real-World Project Design

---

## 🔮 Future Enhancements

* Database Integration (MySQL)
* Login & Authentication System
* GUI using Java Swing/JavaFX
* Online Booking System
* Vehicle Categories
* Bill Printing & PDF Generation
* Admin Dashboard
* Customer Management Module

---

## 📜 License

This project is created for educational and academic purposes under the Java Programming course at Rungta International Skills University.

---

⭐ If you found this project useful, consider giving it a star on GitHub.

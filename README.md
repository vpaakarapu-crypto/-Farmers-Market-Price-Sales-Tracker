# Farmers' Market Price & Sales Tracker

## 📌 Project Overview

The **Farmers' Market Price & Sales Tracker** is a simple Java-based console application designed to help farmers and sellers manage their products, prices, stock, and sales.

The application allows users to add products, view product details, search for products, record sales, and generate a sales report.

This project was developed as part of a **PSPJ (Programming for Social and Professional Development)** project to apply basic Java programming concepts to a real-world problem.

## 📖 Abstract

The **Farmers' Market Price & Sales Tracker** is a simple Java-based console application designed to help farmers and sellers manage their products, prices, stock, and sales. The system allows users to add products, view product details, search for products, record sales, and generate a sales report. It automatically calculates the quantity sold, remaining stock, total money earned, and average product price. The project uses basic Java concepts such as arrays, methods, data types, operators, loops, conditional statements, switch-case, and Scanner. The main aim of this project is to provide a simple and organized way to manage market sales while applying Java programming concepts to a real-world problem.

## 🎯 Objectives

* To maintain product information in an organized way.
* To keep track of product prices and available stock.
* To record product sales.
* To automatically calculate the sale amount.
* To update the remaining stock after a sale.
* To generate a simple sales report.
* To apply basic Java programming concepts to a real-world problem.

## ⚙️ Features

* Add a new product
* View all products
* Search for a product
* Record a sale
* Automatically update remaining stock
* Calculate total quantity sold
* Calculate total money earned
* Calculate average product price
* Find the most expensive product
* Find the best-selling product
* Check for invalid sales

## 🛠️ Technologies Used

* **Programming Language:** Java
* **IDE:** Visual Studio Code / Any Java IDE
* **Input:** Java Scanner
* **Data Storage:** Arrays
* **Application Type:** Console-based application

## 📚 Java Concepts Used

The project demonstrates the following basic Java concepts:

* Classes
* `main()` method
* Variables
* Data types

  * `int`
  * `double`
  * `String`
  * `boolean`
* Arrays
* Methods
* Method calling
* Scanner for user input
* Arithmetic operators
* Relational operators
* Assignment operators
* `if-else`
* `else-if`
* `for` loop
* `do-while` loop
* `switch-case`
* `break`
* `return`
* String comparison
* Searching
* Input validation

## 📋 Menu Options

The application provides the following menu:

```text
1. Add Product
2. View Products
3. Search Product
4. Record Sale
5. Sales Report
6. Exit
```

## 🔄 How the System Works

### 1. Add Product

The user enters:

* Product name
* Price per kg
* Available stock in kg

The information is stored using arrays.

### 2. View Products

The system displays:

* Product name
* Price
* Available stock
* Quantity sold

### 3. Search Product

The user enters a product name. The system searches the product list and displays the product details if it is found.

### 4. Record Sale

The user enters the product name and quantity sold.

The system checks whether the product exists and whether enough stock is available.

The sale amount is calculated using:

**Sale Amount = Price × Quantity Sold**

After the sale:

* Available stock is reduced.
* Quantity sold is increased.
* Sale amount is displayed.

### 5. Sales Report

The system displays:

* Number of products
* Total quantity sold
* Total money earned
* Average product price
* Most expensive product
* Best-selling product

## 🗂️ Data Stored

The program uses four arrays:

| Array      | Purpose                |
| ---------- | ---------------------- |
| `names[]`  | Stores product names   |
| `prices[]` | Stores product prices  |
| `stock[]`  | Stores available stock |
| `sold[]`   | Stores quantity sold   |

The same index represents the same product.

For example:

```text
names[0]  → Tomato
prices[0] → 40
stock[0]  → 50
sold[0]   → 10
```

## ▶️ How to Run

### Step 1

Install Java on your computer.

### Step 2

Open the project in Visual Studio Code or another Java IDE.

### Step 3

Compile the program:

```bash
javac FarmersMarketTracker.java
```

### Step 4

Run the program:

```bash
java FarmersMarketTracker
```

## 📸 Sample Output

The program displays a menu like:

```text
===== FARMERS' MARKET TRACKER =====
1. Add Product
2. View Products
3. Search Product
4. Record Sale
5. Sales Report
6. Exit
```

Screenshots of the program execution can be added to the project documentation.

## ✅ Advantages

* Easy to use and understand.
* Helps manage product information.
* Makes product searching easier.
* Automatically updates stock after a sale.
* Reduces manual calculations.
* Provides a simple sales report.
* Helps track the quantity sold.
* Demonstrates basic Java concepts through a real-world application.

## 🔮 Future Work

The project can be improved in the future by adding:

* Permanent data storage using files or a database.
* A feature to update product prices.
* Product categories.
* Daily, weekly, and monthly sales reports.
* A graphical user interface (GUI).
* Login and user authentication.
* Charts and graphs for sales analysis.
* More advanced inventory management features.

## 📌 Conclusion

The **Farmers' Market Price & Sales Tracker** provides a simple way to manage products, prices, stock, and sales. The application performs important tasks such as adding products, searching for products, recording sales, updating stock, and generating sales reports.

The project helped in applying basic Java concepts such as arrays, methods, loops, operators, conditional statements, switch-case, data types, and user input to a practical real-world problem. Overall, the project provides a simple and organised approach to tracking farmers' market products and sales.

## 👥 Project Team

**Project:** Farmers' Market Price & Sales Tracker
**Course:** PSPJ
**Programming Language:** Java
**Application Type:** Console-based Application

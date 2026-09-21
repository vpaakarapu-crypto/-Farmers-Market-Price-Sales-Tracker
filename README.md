# -Farmers-Market-Price-Sales-Tracker
# Farmers' Market Price & Sales Tracker

## 📌 Project Overview

The **Farmers' Market Price & Sales Tracker** is a simple Java-based console application designed to help farmers and sellers manage their products, prices, stock, and sales.

The application allows users to add products, view product details, search for products, record sales, and generate a sales report.

This project was developed as part of a **PSPJ (Programming for Social and Professional Development)** project to apply basic Java programming concepts to a real-world problem.

---

## 🎯 Objectives

* To maintain product information in an organized way.
* To keep track of product prices and available stock.
* To record product sales.
* To automatically calculate the sale amount.
* To update the remaining stock after a sale.
* To generate a simple sales report.
* To apply basic Java programming concepts in a practical application.

---

## ⚙️ Features

* Add a new product
* View all available products
* Search for a product
* Record a sale
* Automatically update remaining stock
* Calculate total money earned
* Calculate total quantity sold
* Calculate average product price
* Find the most expensive product
* Find the best-selling product
* Validate user input

---

## 🛠️ Technologies Used

* **Programming Language:** Java
* **IDE:** Visual Studio Code / Any Java IDE
* **Input:** Java Scanner
* **Data Storage:** Arrays
* **Application Type:** Console-based application

---

## 📚 Java Concepts Used

This project demonstrates the following basic Java concepts:

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
* `if-else` statements
* `else-if` statements
* `for` loops
* `while` loops
* `switch-case`
* `break`
* `return`
* String methods
* Searching
* Input validation

---

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

---

## 🔄 How the System Works

### 1. Add Product

The user enters:

* Product name
* Price per kg
* Available stock in kg

The product information is stored in arrays.

### 2. View Products

The system displays all added products along with:

* Product name
* Price
* Available stock
* Quantity sold

### 3. Search Product

The user enters a product name. The system searches the product list and displays its details if the product is found.

### 4. Record Sale

The user enters the product name and quantity sold.

The system:

* Checks whether the product exists.
* Checks whether enough stock is available.
* Calculates the sale amount.
* Reduces the available stock.
* Increases the quantity sold.

**Sale Amount = Price × Quantity Sold**

### 5. Sales Report

The system calculates and displays:

* Number of products
* Total quantity sold
* Total money earned
* Average product price
* Most expensive product
* Best-selling product

---

## 🗂️ Data Stored

The application uses four arrays:

| Array      | Purpose                |
| ---------- | ---------------------- |
| `names[]`  | Stores product names   |
| `prices[]` | Stores product prices  |
| `stock[]`  | Stores available stock |
| `sold[]`   | Stores quantity sold   |

The same array index represents the same product.

For example:

```text
names[0]  → Tomato
prices[0] → 40
stock[0]  → 50
sold[0]   → 10
```

---

## ▶️ How to Run

### Step 1

Install Java on your computer.

### Step 2

Clone or download this repository.

### Step 3

Open the project in a Java-compatible IDE such as Visual Studio Code.

### Step 4

Compile the program:

```bash
javac FarmersMarketTracker.java
```

### Step 5

Run the program:

```bash
java FarmersMarketTracker
```

---

## 📸 Sample Output

The program displays a menu like:

```text
======================================
     FARMERS' MARKET TRACKER
======================================

1. Add Product
2. View Products
3. Search Product
4. Record Sale
5. Sales Report
6. Exit
```

Screenshots of the program execution are included in the project presentation/documentation.

---

## ✅ Advantages

* Simple and easy to use.
* Helps manage product information.
* Makes product searching easier.
* Automatically updates stock after a sale.
* Reduces manual calculations.
* Provides a simple sales summary.
* Demonstrates basic Java concepts through a real-world application.

---

## 🔮 Future Scope

The project can be further improved by:

* Adding permanent data storage using files or a database.
* Adding a product price update feature.
* Adding product categories.
* Generating daily, weekly, and monthly reports.
* Adding a graphical user interface.
* Adding login and user authentication.
* Adding charts and graphs for sales analysis.
* Adding more advanced inventory management features.

---

## 👥 Project Team

**Project:** Farmers' Market Price & Sales Tracker

**Course:** PSPJ

**Language:** Java

---

## 📄 Conclusion

The Farmers' Market Price & Sales Tracker provides a simple way to manage products, stock, prices, and sales. It applies basic Java programming concepts to solve a practical real-world problem. The project also provides an opportunity to understand how arrays, methods, loops, operators, conditions, and user input can be combined to create a functional application.

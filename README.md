# Farmers' Market Price & Sales Tracker

A console-based Java application that helps a small farmers' market seller keep track of products, prices, stock and daily sales. Product data is saved to a text file, so nothing is lost when the program is closed.

This project was built as part of my B.Tech coursework to practise Object-Oriented Programming, Exception Handling, Strings, Collections and File I/O in Java.

---

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Java Concepts Used](#java-concepts-used)
- [Requirements](#requirements)
- [How to Run](#how-to-run)
- [Menu Options](#menu-options)
- [Sample Run](#sample-run)
- [How It Works](#how-it-works)
- [Data File Format](#data-file-format)
- [Input Validation and Error Handling](#input-validation-and-error-handling)
- [Possible Improvements](#possible-improvements)

---

## Features

- Add products with price per kg and available stock
- View all products with their price, remaining stock and quantity sold
- Search for a product by name (not case-sensitive)
- Record a sale, with automatic stock and sales updates
- Show a sales report with totals and averages
- Save all data to a file on exit and load it automatically on startup
- Handle invalid input, missing files and badly formatted records without crashing

---

## Project Structure

```
FarmersMarketTracker/
├── FarmersMarketTracker.java   # Source code (all classes)
├── README.md                   # Project documentation
└── products.txt                # Created automatically when you save and exit
```

The source file contains three classes:

| Class | Purpose |
|-------|---------|
| `InsufficientStockException` | Custom checked exception thrown when a sale is larger than the available stock |
| `Product` | Stores the name, price, stock and sold quantity of one product, and handles selling |
| `FarmersMarketTracker` | Main class with the menu, user input and all operations on the product list |

---

## Java Concepts Used

**Object-Oriented Programming**
- Classes and objects
- Encapsulation (private fields with getter methods)
- Constructor and the `this` keyword
- `toString()` method with `@Override`

**Exception Handling**
- `try` and `catch`
- `throw` and `throws`
- Checked exception
- Custom exception (`InsufficientStockException`)

**Strings**
- `trim()`, `replace()`, `equalsIgnoreCase()`, `split()`, `isEmpty()`

**Collections**
- `ArrayList`
- For-each loop

**File I/O**
- `Path` and `Files`
- `BufferedReader` and `BufferedWriter`
- Try-with-resources
- Handling a missing file
- Handling malformed records

---

## Requirements

- JDK 11 or higher (the code uses `Path.of()`)
- A terminal or command prompt

Check your Java version with:

```
java -version
```

---

## How to Run

1. Clone or download this repository.
2. Open a terminal in the project folder.
3. Compile the program:

```
javac FarmersMarketTracker.java
```

4. Run it:

```
java FarmersMarketTracker
```

The program creates `products.txt` in the folder you run it from.

---

## Menu Options

```
===== FARMERS MARKET TRACKER =====
1. Add Product
2. View Products
3. Search Product
4. Record Sale
5. Sales Report
6. Save and Exit
```

| Option | What it does |
|--------|--------------|
| 1. Add Product | Asks for the name, price per kg and stock in kg, then adds the product |
| 2. View Products | Lists every product with price, stock and quantity sold |
| 3. Search Product | Finds a product by name and shows its details |
| 4. Record Sale | Asks for a product and the quantity sold, reduces stock and shows the amount |
| 5. Sales Report | Shows overall sales figures (see below) |
| 6. Save and Exit | Writes all products to `products.txt` and closes the program |

**Important:** choose option 6 to exit. Data is saved only when you exit this way.

---

## Sample Run

```
No saved data found. Starting fresh.

===== FARMERS MARKET TRACKER =====
1. Add Product
2. View Products
3. Search Product
4. Record Sale
5. Sales Report
6. Save and Exit
Enter your choice: 1
Enter product name: Tomato
Enter price per kg: 40
Enter stock in kg: 100
Product added successfully.

Enter your choice: 4
Enter product name: tomato
Available stock: 100.0 kg
Enter quantity sold: 10
Sale recorded successfully.
Amount: Rs.400.0
Remaining stock: 90.0 kg

Enter your choice: 4
Enter product name: tomato
Available stock: 90.0 kg
Enter quantity sold: 500
Not enough stock.

Enter your choice: 5

===== SALES REPORT =====
Number of products: 1
Total quantity sold: 10.0 kg
Total money earned: Rs.400.0
Average price: Rs.40.0
Most expensive product: Tomato
Best selling product: Tomato
```

---

## How It Works

**Storing products.** Each product is an object of the `Product` class. All products are kept in an `ArrayList<Product>`, and a for-each loop is used to go through them.

**Finding a product.** The `findProduct()` method loops through the list and compares names using `equalsIgnoreCase()`, so `Tomato`, `tomato` and `TOMATO` all match.

**Recording a sale.** The `sell()` method in `Product` checks the quantity against the stock. If there is not enough stock, it throws `InsufficientStockException`. The main program catches this exception and shows a message instead of crashing.

**Sales report.** The report loops through all products to calculate:
- Total quantity sold
- Total money earned (quantity sold × price for each product)
- Average price
- Most expensive product
- Best-selling product (shows "No sales yet" if nothing has been sold)

**Saving and loading.** On exit, each product is written as one line to `products.txt` using `BufferedWriter`. On startup, the file is read line by line using `BufferedReader` and the products are added back to the list.

---

## Data File Format

Each line of `products.txt` stores one product, separated by commas:

```
name,price,stock,sold
```

Example:

```
Tomato,40.0,90.0,10.0
Onion,30.0,50.0,0.0
Potato,25.0,200.0,35.5
```

Because commas are used as separators, any comma in a product name is replaced with a space when the product is added.

---

## Input Validation and Error Handling

| Situation | What the program does |
|-----------|-----------------------|
| User types letters where a number is expected | Shows a message and asks again |
| Product name is empty | Rejects the product |
| Price is zero or negative, or stock is negative | Rejects the product |
| Product to search or sell is not found | Shows "Product not found." |
| Quantity sold is zero or negative | Shows "Invalid quantity." |
| Quantity sold is more than the stock | Shows "Not enough stock." (custom exception) |
| `products.txt` does not exist | Starts with an empty list |
| A line in `products.txt` is incorrectly formatted | Skips that line and shows a message |
| File cannot be read or written | Shows an error message |

---

## Possible Improvements

- Prevent adding two products with the same name
- Add options to update the price or restock a product
- Add an option to delete a product
- Sort products by name, price or quantity sold
- Add a simple graphical interface

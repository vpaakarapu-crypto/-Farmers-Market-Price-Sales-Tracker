import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

class InsufficientStockException extends Exception {
    InsufficientStockException(String message) {
        super(message);
    }
}

class Product {
    private String name;
    private double price;
    private double stock;
    private double sold;

    Product(String name, double price, double stock, double sold) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    double getStock() {
        return stock;
    }

    double getSold() {
        return sold;
    }

    void sell(double kg) throws InsufficientStockException {
        if (kg > stock) {
            throw new InsufficientStockException("Not enough stock.");
        }
        stock = stock - kg;
        sold = sold + kg;
    }

    String toFileLine() {
        return name + "," + price + "," + stock + "," + sold;
    }

    @Override
    public String toString() {
        return "Name  : " + name + "\n"
             + "Price : Rs." + price + "\n"
             + "Stock : " + stock + " kg\n"
             + "Sold  : " + sold + " kg";
    }
}

public class FarmersMarketTracker {
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Path file = Path.of("products.txt");

    public static void main(String[] args) {
        loadFromFile();
        int choice;
        do {
            System.out.println("\n===== FARMERS MARKET TRACKER =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Record Sale");
            System.out.println("5. Sales Report");
            System.out.println("6. Save and Exit");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    recordSale();
                    break;
                case 5:
                    showReport();
                    break;
                case 6:
                    saveToFile();
                    System.out.println("Thank you for using the tracker!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static Product findProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine().trim().replace(",", " ");
        if (name.isEmpty()) {
            System.out.println("Product name cannot be empty.");
            return;
        }

        double price = readDouble("Enter price per kg: ");
        double kg = readDouble("Enter stock in kg: ");
        if (price <= 0 || kg < 0) {
            System.out.println("Invalid price or stock.");
            return;
        }

        products.add(new Product(name, price, kg, 0));
        System.out.println("Product added successfully.");
    }

    static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n===== PRODUCT LIST =====");
        int number = 1;
        for (Product p : products) {
            System.out.println("\nProduct " + number);
            System.out.println(p);
            number++;
        }
    }

    static void searchProduct() {
        System.out.print("Enter product name: ");
        Product p = findProduct(sc.nextLine().trim());

        if (p == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println("\nProduct Found");
            System.out.println(p);
        }
    }

    static void recordSale() {
        System.out.print("Enter product name: ");
        Product p = findProduct(sc.nextLine().trim());

        if (p == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Available stock: " + p.getStock() + " kg");
        double kg = readDouble("Enter quantity sold: ");

        if (kg <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        try {
            p.sell(kg);
            System.out.println("Sale recorded successfully.");
            System.out.println("Amount: Rs." + kg * p.getPrice());
            System.out.println("Remaining stock: " + p.getStock() + " kg");
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
        }
    }

    static void showReport() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        double totalKg = 0;
        double totalMoney = 0;
        double totalPrice = 0;
        Product bestSeller = products.get(0);
        Product highestPrice = products.get(0);

        for (Product p : products) {
            totalKg = totalKg + p.getSold();
            totalMoney = totalMoney + p.getSold() * p.getPrice();
            totalPrice = totalPrice + p.getPrice();

            if (p.getSold() > bestSeller.getSold()) {
                bestSeller = p;
            }
            if (p.getPrice() > highestPrice.getPrice()) {
                highestPrice = p;
            }
        }

        System.out.println("\n===== SALES REPORT =====");
        System.out.println("Number of products: " + products.size());
        System.out.println("Total quantity sold: " + totalKg + " kg");
        System.out.println("Total money earned: Rs." + totalMoney);
        System.out.println("Average price: Rs." + totalPrice / products.size());
        System.out.println("Most expensive product: " + highestPrice.getName());

        if (totalKg > 0) {
            System.out.println("Best selling product: " + bestSeller.getName());
        } else {
            System.out.println("Best selling product: No sales yet");
        }
    }

    static void saveToFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Product p : products) {
                writer.write(p.toFileLine());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save data: " + e.getMessage());
        }
    }

    static void loadFromFile() {
        if (!Files.exists(file)) {
            System.out.println("No saved data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.out.println("Skipping bad record: " + line);
                    continue;
                }
                try {
                    products.add(new Product(parts[0].trim(),
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3])));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping bad record: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read data: " + e.getMessage());
        }
    }
}


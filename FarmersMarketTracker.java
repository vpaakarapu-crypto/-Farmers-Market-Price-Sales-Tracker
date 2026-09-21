import java.util.Scanner;

class FarmersMarketTracker {
    static String[] names = new String[50];
    static double[] prices = new double[50];
    static double[] stock = new double[50];
    static double[] sold = new double[50];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== FARMERS MARKET TRACKER =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Record Sale");
            System.out.println("5. Sales Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Thank you for using the tracker!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    static void addProduct() {
        if (count >= 50) {
            System.out.println("Product list is full.");
            return;
        }

        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter price per kg: ");
        double price = sc.nextDouble();
        System.out.print("Enter stock in kg: ");
        double kg = sc.nextDouble();
        sc.nextLine();

        names[count] = name;
        prices[count] = price;
        stock[count] = kg;
        sold[count] = 0;
        count++;

        System.out.println("Product added successfully.");
    }

    static void viewProducts() {
        if (count == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n===== PRODUCT LIST =====");
        for (int i = 0; i < count; i++) {
            System.out.println("\nProduct " + (i + 1));
            System.out.println("Name  : " + names[i]);
            System.out.println("Price : Rs." + prices[i]);
            System.out.println("Stock : " + stock[i] + " kg");
            System.out.println("Sold  : " + sold[i] + " kg");
        }
    }

    static void searchProduct() {
        if (count == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                System.out.println("\nProduct Found");
                System.out.println("Name  : " + names[i]);
                System.out.println("Price : Rs." + prices[i]);
                System.out.println("Stock : " + stock[i] + " kg");
                System.out.println("Sold  : " + sold[i] + " kg");
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.println("Product not found.");
        }
    }

    static void recordSale() {
        if (count == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Available stock: " + stock[index] + " kg");
        System.out.print("Enter quantity sold: ");
        double kg = sc.nextDouble();

        if (kg <= 0) {
            System.out.println("Invalid quantity.");
        } else if (kg > stock[index]) {
            System.out.println("Not enough stock.");
        } else {
            double amount = kg * prices[index];
            stock[index] = stock[index] - kg;
            sold[index] = sold[index] + kg;
            System.out.println("Sale recorded successfully.");
            System.out.println("Amount: Rs." + amount);
            System.out.println("Remaining stock: " + stock[index] + " kg");
        }
        sc.nextLine();
    }

    static void showReport() {
        if (count == 0) {
            System.out.println("No products available.");
            return;
        }

        double totalKg = 0;
        double totalMoney = 0;
        double totalPrice = 0;
        int bestSeller = 0;
        int highestPrice = 0;

        for (int i = 0; i < count; i++) {
            totalKg = totalKg + sold[i];
            totalMoney = totalMoney + sold[i] * prices[i];
            totalPrice = totalPrice + prices[i];

            if (sold[i] > sold[bestSeller]) {
                bestSeller = i;
            }

            if (prices[i] > prices[highestPrice]) {
                highestPrice = i;
            }
        }

        double averagePrice = totalPrice / count;

        System.out.println("\n===== SALES REPORT =====");
        System.out.println("Number of products: " + count);
        System.out.println("Total quantity sold: " + totalKg + " kg");
        System.out.println("Total money earned: Rs." + totalMoney);
        System.out.println("Average price: Rs." + averagePrice);
        System.out.println("Most expensive product: " + names[highestPrice]);

        if (totalKg > 0) {
            System.out.println("Best selling product: " + names[bestSeller]);
        } else {
            System.out.println("Best selling product: No sales yet");
        }
    }
}


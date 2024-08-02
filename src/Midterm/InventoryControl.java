/*
Continuation of Product class
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryControl {

    static List<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("1. Create a new product");
            System.out.println("2. Restock the product");
            System.out.println("3. Sell the product");
            System.out.println("4. Display the inventory");
            System.out.println("5. Exit the program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    restockProduct();
                    break;
                case 3:
                    sellProduct();
                    break;
                case 4:
                    displayInventory();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }

    private static void createProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findProductIndexById(id) != -1) {
            System.out.println("Product ID already exists. Try again.");
            return;
        }

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter unit: ");
        String unit = scanner.nextLine();

        products.add(new Product(id, name, 0, unit));
        System.out.println("Product added successfully.");
    }

    private static void restockProduct() {
        System.out.print("Enter product ID to restock: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        int index = findProductIndexById(id);
        if (index == -1) {
            System.out.println("Product ID not found.");
            return;
        }

        System.out.print("Enter number of items to restock: ");
        int restock = scanner.nextInt();
        scanner.nextLine();

        Product product = products.get(index);
        product.restock(restock);
        products.set(index, product);
        System.out.println("Restocked successfully.");
    }

    private static void sellProduct() {
        System.out.print("Enter product ID to sell: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        int index = findProductIndexById(id);
        if (index == -1) {
            System.out.println("Product ID not found.");
            return;
        }

        System.out.print("Enter number of items to sell: ");
        int sell = scanner.nextInt();
        scanner.nextLine();

        Product product = products.get(index);
        if (product.sell(sell)) {
            products.set(index, product);
            System.out.println("Sold successfully.");
        } else {
            System.out.println("Not enough items in stock to sell.");
        }
    }

    private static void displayInventory() {
        System.out.println("List of Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static int findProductIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}

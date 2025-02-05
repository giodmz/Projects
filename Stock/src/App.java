import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        
        Product product = new Product(name, price, quantity);

        product.setName("Computer");
        System.out.println("Updated name: " + product.getName());

        System.out.println("\nProduct data: " + product);

        System.out.println("Enter the number of products to be added in stock: ");
        quantity = sc.nextInt();
        product.addProducts(quantity);
        System.out.println("Updated data: " + product);

        System.out.println("Enter the number of products to be removed from stock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);
        System.out.println("Updated data: " + product);


        sc.close();
    }
}

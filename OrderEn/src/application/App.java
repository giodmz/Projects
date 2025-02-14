package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.next();
        sc.next();
        System.out.println("E-mail: ");
        String email = sc.next();
        System.out.println("Birth date (DD/MM/YYYY): ");
        Date birthdate = sdf.parse(sc.next());
        
        Client client = new Client(name, email, birthdate);
        
        System.out.println("Enter the order data: ");
        System.out.print("Status: ");
        String status = sc.next();
        Date dateNow = new Date();

        Order order = new Order(dateNow, OrderStatus.valueOf(status));
        

        System.out.println("How many items to this order? ");
        int items = sc.nextInt();

        for (int i = 0; i < items; i++) {
            System.out.println("Enter #" + (i +1) + " item data: ");
            System.out.println("Product name: ");
            String productName = sc.nextLine();
            sc.next();
            System.out.println("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(productQuantity, product.getPrice());

            order.addItem(orderItem);
            // System.out.println(orderItem.toString());
        }
        
        System.out.println(client.toString());
        System.out.println(order.toString());
        


        sc.close();


    }
}

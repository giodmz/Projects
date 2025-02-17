package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            System.out.println("Product #" + (i + 1) + " data: ");
            System.out.println("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Price: ");
            double price = sc.nextDouble();
            if (type == 'c'){
                products.add(new Product(name, price));
            } 
            if (type == 'i'){
                System.out.println("Customs Fee: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            } 
            if (type == 'u'){
                System.out.println("Manufacture date (DD/MM/YYYY)");
                String date = sc.next();
                LocalDate manufactureDate = LocalDate.parse(date, formatter);
                products.add(new UsedProduct(name, price, manufactureDate));
            }
            
        }

        System.out.println("\nPRICE TAGS: ");
        for (Product product : products){
            System.out.println(product.priceTag());
        }


        sc.close();
    }
}

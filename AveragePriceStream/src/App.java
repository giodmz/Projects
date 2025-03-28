import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        
        String csvPath = "C:\\Projects\\AveragePriceStream\\lib\\products.csv";

        List<Product> product = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);

                product.add(new Product(name, price));

                line = br.readLine();
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        

        double avgPrice = product.stream()
        .mapToDouble(p -> p.getPrice() / product.size())
        .sum();

        List<Product> sortPrice = product.stream()
        .filter(p -> p.getPrice() < avgPrice)
        .sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
        .collect(Collectors.toList());

        
        
        System.out.println("Average price: $" + avgPrice);
        
        System.out.println("Lower than average products: " + "\n" + Arrays.toString(sortPrice
        .toArray()));
        
        System.out.println("\nProduct summary: ");
        for (Product products : product) {
            System.out.println(products.toString());
        }


    }
}

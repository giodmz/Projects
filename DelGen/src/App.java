import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.CalService;

public class App {
    public static void main(String[] args) throws Exception {
    
        List<Product> list = new ArrayList<>();

        String path = "C:\\Projects\\DelGen\\lib\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add( new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Product x = CalService.max(list);
            System.out.println("Max: ");
            System.out.println(x);


        }   catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

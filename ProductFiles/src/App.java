import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Projects\\ProductFiles\\lib\\");
        File productRead = new File ("C:\\Projects\\ProductFiles\\lib\\products.csv");

        List<Product> product = new ArrayList<>();
        Scanner sc = null;


        try{
            sc = new Scanner(productRead);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 

        boolean newFolder = new File(file + "\\out").mkdir();
        System.out.println("\nFolder created: " + newFolder);

        try (BufferedReader br = new BufferedReader(new FileReader(productRead))){
            
            // get .csv data
            String itemCsv = br.readLine();

            while (itemCsv != null) {
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                product.add(new Product(name, price, quantity));

                itemCsv = br.readLine();
            
            }
        }   catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        String targetFile = file + "\\out\\summary.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))){
            // write the summary data

            for(Product products : product){
                bw.write(products.getName() + "," + String.format("%.2f", products.outComing()));
                bw.newLine();
            }
            System.out.println("Summary path: " + targetFile);

        } catch(IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }




        sc.close();

    }
}

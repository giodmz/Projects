import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {

        File fileRead = new File("C:\\Projects\\ProductFiles\\lib\\products.csv");
        File fileOut = new File("C:\\Projects\\ProductFiles\\lib");
        File summary = new File("C:\\Projects\\ProductFiles\\lib\\out");

        Scanner sc = null;


        try{
            sc = new Scanner(fileRead);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 

        boolean newFolder = new File(fileOut + "\\out").mkdir();
        System.out.println("Directory created: " + newFolder);

        boolean summaryFile = new File(summary + "\\summary.csv").createNewFile();

        

        String[] products = new String[] {"product 1", "product 2"};
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(summary))){
            for (String product : products ){
                bw.write(product.toString());
                bw.newLine();
            }
        
        }   catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        sc.close();

    }
}

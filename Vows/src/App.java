import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import entities.Candidate;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file full path: ");
        String path = "C:\\Projects\\Vows\\lib\\candidates.csv";
        // String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            Map<String, Integer> Ellections = new HashMap<>();

            while (line != null) {

                String[] fields = line.split(",");
                String candidateName = fields[0];
                Integer candidateVows = Integer.parseInt(fields[1]);

                Ellections.put(candidateName, candidateVows);
                
                Candidate candidates = new Candidate(candidateName, candidateVows);
                
                


                System.out.println("Candidate: " + candidates.getName());
                line = br.readLine();

                System.out.println("All candidates:");
                for (Map.Entry<String, Integer> entry : Ellections.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
    }
            }


        } catch (IOException ex) {
            ex.getMessage();
        }


        Map<String, Integer> Candidates = new HashMap<>();


        sc.close();
    }
}

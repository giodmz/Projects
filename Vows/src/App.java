import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file full path: ");
        String path = "C:\\Projects\\Vows\\lib\\candidates.csv";
        // String path = sc.nextLine();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            Map<String, Integer> ellections = new HashMap<>();

            while (line != null) {

                // separa no .csv as partes do arquivo pela ,
                String[] fields = line.split(",");
                String candidateName = fields[0];
                Integer candidateVows = Integer.parseInt(fields[1].trim()); 

                // soma os votos utilizando de base o hashcode do nome 
                ellections.put(candidateName, ellections.getOrDefault(candidateName, 0) + candidateVows);
                line = br.readLine();
            }
            
            System.out.println("\nAll candidates:");
            for (Map.Entry<String, Integer> entry : ellections.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException ex) {
            ex.getMessage();
        }

        sc.close();
    }
}

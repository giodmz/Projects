import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        // File file = new File("C:\\Projects\\FileReader\\lib\\file.txt");

        String path = "C:\\Projects\\FileReader\\lib\\file.txt";

        // Scanner sc = null;
        // try {
        //     sc = new Scanner(file);
        //     while (sc.hasNextLine()){
        //         System.out.println(sc.nextLine());
        //     }
        // }   catch (IOException ex){
        //     System.out.println("Error: " + ex.getMessage());
        // } finally {
        //     sc.close();
        // }
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 

        String[] lines = new String[] {"123", "321", "788"};
        String pathWriter = "C:\\Projects\\FileReader\\lib\\file2.txt";

        // true faz com que acrescente ao arquivo e não recria ele
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter, true))) {
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }   catch (IOException ex){
            ex.printStackTrace();
        }

    }
}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        File file = new File("C:\\Projects\\FileReader\\lib\\file.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }   catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        finally {
            if ( sc != null){
                sc.close();
            }
        }


    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        File file = new File("C:\\Projects\\FileReader\\lib\\file.txt");

        String path = "C:\\Projects\\FileReader\\lib\\file.txt";
        FileReader fr = null;
        BufferedReader br = null;


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
        
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try{

                if(br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
            }


    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Projects\\Try\\in.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error opening file: " + ex.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
            System.out.println("\nFinally block executed");
        }

        // try {
        //     String[] vect = sc.nextLine().split(" ");
        //     int position = sc.nextInt();
        //     System.out.println(vect[position]);

        // } catch (ArrayIndexOutOfBoundsException ex) {
        //     System.out.println("Invalid Position! ");
        // } catch (InputMismatchException ex) {
        //     System.out.println("Input error, try a number");
        //     ex.printStackTrace();
        // }



    }
}

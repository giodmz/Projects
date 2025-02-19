import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid Position! ");
        } catch (InputMismatchException ex) {
            System.out.println("Input error, try a number");
        }

        sc.close();


    }
}

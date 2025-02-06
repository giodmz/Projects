import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        int number;

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos números você vai digitar ?");
        int input = sc.nextInt();
        NumberVector[] vect = new NumberVector[input];

        for (int i = 0; i < vect.length; i++) {
            int value = sc.nextInt();
            vect[i] = new NumberVector(value);
        }

        
        System.out.println("\nNúmeros negativos: ");
        for (int i = 0; i < vect.length; i++) {
           int negatives = vect[i].getValue();
           if (negatives < 0) {
            System.out.println(negatives);
           }
        }
        

        sc.close();
    }
}

import java.util.Scanner;

import services.PrintService;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();

        System.out.println("How many values? ");
        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            int value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        System.out.println("First: " + ps.first());

        sc.close();
    }
}

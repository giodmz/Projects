import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Type: ");
        int correctAnswear = sc.nextInt();

        System.out.println("Answears: ");

        int answears = 0;
        int countAns = 0;
        
        for (int i = 0; i < 5; i++) {
            answears = sc.nextInt();
            if (answears == correctAnswear) {
                countAns++;
            }
        }
        

        int count = 0;
        for (int i = 0; i < countAns; i++) {
            count++;
        }

        System.out.println(count);




        sc.close();
    }
}

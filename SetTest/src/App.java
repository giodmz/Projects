import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.User;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Set<User> set = new HashSet<>();

        System.out.print("How many students for course A? ");
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            int studentA = sc.nextInt();
            set.add(new User(studentA));
        }
        
        System.out.print("How many students for course B? ");
        int input2 = sc.nextInt();
        for (int i = 0; i < input2; i++) {
            int studentB = sc.nextInt();
            set.add(new User(studentB));
        }
        
        System.out.print("How many students for course C? ");
        int input3 = sc.nextInt();
        for (int i = 0; i < input3; i++) {
            int studentC = sc.nextInt();
            set.add(new User(studentC));
        }

        System.out.println("Total users: " + set.size());



        sc.close();
    }
}

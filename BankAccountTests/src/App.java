import java.util.Locale;
import java.util.Scanner;

import entities.Client;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter the titular name: ");
        String name = sc.nextLine();
        System.out.println("Enter the ID account: ");
        int accountId = sc.nextInt();
        System.out.println("Do you have a start deposit? (y/n)");
        char answer = sc.next().charAt(0);
        
        if (answer != 'n') {
            System.out.println("How much?");
            double cash = sc.nextDouble();
            Client client = new Client(name, cash, accountId);
            client.setCash(cash);
            System.out.println("Do a deposit: ");
            cash = sc.nextDouble();
            client.deposit(cash);
            System.out.println("Do a withdraw: ");
            cash = sc.nextDouble();
            client.withdraw(cash);
            System.out.println("\nUpdated account info: " + client);

        } else {

            double cash = 0;
            Client client = new Client(name, cash, accountId);
            System.out.println("Do a deposit: ");
            cash = sc.nextDouble();
            client.deposit(cash);
            System.out.println("Do a withdraw: ");
            cash = sc.nextDouble();
            client.withdraw(cash);
            System.out.println("\nUpdated account info: " + client);
    
        }
        

        sc.close();
    }
}

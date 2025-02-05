import java.util.Locale;
import java.util.Scanner;

import entities.Client;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Client client;
        
        System.out.println("Enter the titular name: ");
        String name = sc.nextLine();
        System.out.println("Enter account number: ");
        int accountId = sc.nextInt();
        System.out.println("Is there an initial deposit? (y/n)");

        char answer = sc.next().charAt(0);
        
        if (answer != 'n') {
            System.out.println("How much?");
            double inicialCash = sc.nextDouble();
            client = new Client(name, accountId, inicialCash);
            System.out.println("Do a deposit: ");
            inicialCash = sc.nextDouble();
            client.deposit(inicialCash);
            System.out.println("\nUpdated account info: " + client);
            System.out.println("Do a withdraw: ");
            inicialCash = sc.nextDouble();
            client.withdraw(inicialCash);
            System.out.println("\nUpdated account info: " + client);

        } else {

            double cash = 0;
            client = new Client(name, accountId);
            System.out.println("Do a deposit: ");
            cash = sc.nextDouble();
            client.deposit(cash);
            System.out.println("\nUpdated account info: " + client);
            System.out.println("Do a withdraw: ");
            cash = sc.nextDouble();
            client.withdraw(cash);
            System.out.println("\nUpdated account info: " + client);
    
        }
        

        sc.close();
    }
}

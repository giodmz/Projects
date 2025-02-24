package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.exceptions.DomainException;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.next();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrwaLimit = sc.nextDouble();
        Account account = new Account(number, holder, balance, withdrwaLimit);

        System.out.println("\nEnter amount for withdraw: ");
        double amount = sc.nextDouble();

        try {
        account.withdraw(amount);
        System.out.println("New balance: " + account.getBalance());
        
        } catch (DomainException ex) {
            System.out.println(ex.getMessage());
        }
            sc.close();
        }
}

package application;

import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Account> list = new ArrayList<>();

        // UPCASTING

        list.add(new BusinessAccount(3, "Bob", 500.00, 500.00));
        list.add(new SavingsAccount(77, "Ana", 1000.00, 0.02));
        list.add(new BusinessAccount(42, "Celo", 400.00, 700.00));
        list.add(new SavingsAccount(76, "Mendi", 500.00, 0.01));

        double sum = 0.0;
        for (Account account: list){
            sum += account.getBalance();
        }

        System.out.printf("Total balance: %.2f%n", sum);

        for (Account account : list){
            account.deposit(10.0);
        }
        for (Account account : list){
            System.out.printf("Updated balance: %d: %.2f%n", account.getNumber(), account.getBalance());
        }

        // DOWNCASTING
        // BusinessAccount acc4 = (BusinessAccount)acc2;
        // acc4.loan(100.0);

        
        // TESTS
        // Account x = new Account(111, "Astarion", 1000.0);
        // Account y = new SavingsAccount(777, "Shadowheart", 1000.0, 0.01);

        // x.withdraw(50.0);
        // y.withdraw(50.0);
        
        // System.out.println(x.getBalance());
        // System.out.println(y.getBalance());



        // if(acc3 instanceof BusinessAccount){
        //     BusinessAccount acc5 = (BusinessAccount)acc3;
        //     acc5.loan(200.0);
        //     System.out.println("Loan!");
        // }

        // if(acc3 instanceof SavingsAccount){
        //     SavingsAccount acc5 = (SavingsAccount)acc3;
        //     acc5.updateBalance();
        //     System.out.println("Update!");
        // }

        // Account acc6 = new Account(100, "Foda-se", 1000.0);
        // acc6.withdraw(200.0);
        // System.out.println(acc6.getBalance());

        // Account acc7 = new SavingsAccount(222, "Fodinha", 1000.00, 0.01);
        // acc7.withdraw(200.0);
        // System.out.println(acc7.getBalance());

        // Account acc8 = new BusinessAccount(102, "Bob Balão", 1000.00, 500.0);
        // acc8.withdraw(200.0);
        // System.out.println(acc8.getBalance());

    }
}

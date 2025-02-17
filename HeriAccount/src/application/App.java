package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
        
        Account acc = new Account(1, "Celo", 0);
        BusinessAccount bacc = new BusinessAccount(2, "Cai", 0.0, 500.0);

        // UPCASTING
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(3, "Bob", 0, 200.0);
        Account acc3 = new SavingsAccount(4, "Maria", 0.0, 0.01);


        // DOWNCASTING
        BusinessAccount acc4 = (BusinessAccount)acc2;
        acc4.loan(100.0);

        
        // TESTS
        Account x = new Account(111, "Astarion", 1000.0);
        Account y = new SavingsAccount(777, "Shadowheart", 1000.0, 0.01);

        x.withdraw(50.0);
        y.withdraw(50.0);
        
        System.out.println(x.getBalance());
        System.out.println(y.getBalance());



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

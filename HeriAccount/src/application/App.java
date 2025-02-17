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
        if(acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if(acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

    }
}

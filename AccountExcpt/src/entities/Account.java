package entities;

public class Account {

    private int number;
    private String holder;
    private double balance;
    private double withdrwaLimit;

    public Account(){

    }

    public Account(int number, String holder, double balance, double withdrwaLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrwaLimit = withdrwaLimit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrwaLimit() {
        return withdrwaLimit;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    
}

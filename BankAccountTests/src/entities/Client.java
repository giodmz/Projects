package entities;

public class Client {

    private String name;
    private int accountId;
    private double cash;
    
    public Client(String name, int accountId, double inicialCash) {
        this.name = name;
        this.accountId = accountId;
        deposit(inicialCash);
    }

    public Client(String name, int accountId){
        this.name = name;
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public int getAccountId() {
        return accountId;
    }

    public void deposit(double cash){
        this.cash += cash;
    }

    public void withdraw(double cash){
        double tax = 5.00;
        this.cash -= cash + tax;
    }



    @Override
    public String toString() {
        return "Client name: " + name + ", Account Number: " + accountId + ", Balance: $" + cash;
    }

    
    
    
}

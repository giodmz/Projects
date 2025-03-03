package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Installment {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private LocalDateTime date;
    private double amount;

    public Installment(LocalDateTime date, Double amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(formatter.format(date) + " - ");
        sb.append(String.format("%.2f", amount));

        return sb.toString();
    }
    

}

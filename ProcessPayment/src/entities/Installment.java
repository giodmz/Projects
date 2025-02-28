package entities;

import java.time.LocalDateTime;

public class Installment {

    private LocalDateTime date;
    private Double amount;

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
        return date + " - " + amount;
    }

    // public void add(Installment installment) {
    //     installment += installment + 1;
    // }

    

}

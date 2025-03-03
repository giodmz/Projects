package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Contract {

    private Integer number;
    private LocalDateTime date;
    private Double totalValue;

    ArrayList<Installment> installments = new ArrayList<Installment>();

     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

     public Contract(){
        
     }


    public Contract(Integer number, LocalDateTime date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public ArrayList<Installment> getInstallments() {
        return installments;
    }
    
    
    
}

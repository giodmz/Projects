package entities;

import java.time.LocalDate;

public class UsedProduct extends Product {

    private LocalDate manufactureDate;

    public UsedProduct(){

    }

    public UsedProduct(String name, double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        StringBuilder sb = new StringBuilder();
        sb.append(name + " (used)");
        sb.append(" $" + price);
        sb.append(" (Manufacture date: " + manufactureDate + ")");
        return sb.toString();
    }
    
}

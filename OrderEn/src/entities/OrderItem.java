package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {

    private int quantity;
    private double price;

    private List<Product> products = new ArrayList<>();

    public OrderItem(){

    }

    public OrderItem(Integer quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double subTotal(){
        return quantity * price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Product p : products){
            sb.append(p.getName() + ", ");
            sb.append("$" + p.getPrice() + ", ");
        }
        sb.append("Quantity: " + quantity + ", ");
        sb.append("Subtotal: $" + subTotal());
        return sb.toString();
    }

    
}

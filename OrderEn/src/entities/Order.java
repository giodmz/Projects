package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

    private Date moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();
    private List<Product> products = new ArrayList<>();


    public Order(){

    }

    public Order(Date moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Order SUMMARY: ");
        sb.append("Order moment: " + moment + "\n");
        sb.append("Order status: " + status + "\n");
        for (Product p : products){
            sb.append(p.getName() + ", ");
            sb.append("$" + p.getPrice() + ", ");
        }

        for (OrderItem i : items){
            sb.append("Quantity: " + i.getQuantity() + ", ");
            sb.append("Subtotal: $" + i.subTotal() + "\n");
        }
        
        double total = 0.0;
        for (OrderItem i : items) {
            total += i.subTotal();
        }
        sb.append("Total price: $" + total + "\n");



        return sb.toString();
    }

    

    
    

    
}

package entities;

public class Product implements Comparable<Product> {

    private String name;
    private Double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
       return price.compareTo(other.getPrice());
    }


    @Override
    public String toString() {
        return name + ", " + price;
    }

    

    

}

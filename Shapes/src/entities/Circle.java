package entities;

public class Circle implements Shape {

    private double r;
    
    public Circle(double r) {
        this.r = r;
    }

    public Circle() {
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double area() {
       double area = Math.PI * Math.abs(r);
       return area;
    }

    
}

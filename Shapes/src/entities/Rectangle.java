package entities;

public class Rectangle implements Shape{
    private double b;
    private double h;


    public Rectangle(double b, double h) {
        this.b = b;
        this.h = h;
    }


    public Rectangle() {
    }


    public double getB() {
        return b;
    }


    public void setB(double b) {
        this.b = b;
    }


    public double getH() {
        return h;
    }


    public void setH(double h) {
        this.h = h;
    }


    @Override
    public double area() {
        double area = b * h;
        return area;
    }

    

    
}

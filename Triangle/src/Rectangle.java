public class Rectangle implements Shape {

    public double b;
    public double h;

    public Rectangle(){

    }

    

    public Rectangle(double b, double h) {
        this.b = b;
        this.h = h;
    }


    public double area(){
        double a = b * h;
        return a;
    }


    public double getB() {
        return b;
    }





    public double getH() {
        return h;
    }
}

public class Square implements Shape {
    public double a;

    public Square(){

    }


    public Square(double a) {
        this.a = a;
    }



    public double area(){
        double p = a * a;
        return p;
    }


    public double getA() {
        return a;
    }


    public void setA(double a) {
        this.a = a;
    }

    

}

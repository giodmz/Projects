public class Rectangle {

    public double width;
    public double height;

    public double Area(){
        return width * height;
    }

    public double Perimeter(){
        return height * 2 + width * 2;
    }

    public double Diagonal(){
        double som = Math.pow(width, 2) + Math.pow(height, 2);
        return Math.sqrt(som);
        
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + ", Area()=" + Area() + ", Perimeter()="
                + Perimeter() + ", Diagonal()=" + Diagonal() + "]";
    }

    

    

}

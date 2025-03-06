package application;

import java.util.ArrayList;
import java.util.List;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;


public class App {
    public static void main(String[] args) throws Exception {
        
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(3.0, 2.0));
        shapes.add(new Circle());

        System.out.println("Total area: " + totalArea(shapes));


    }

    public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;

        for (Shape shapes : list) {
            sum += shapes.area();
        }
        return sum;
    }
}

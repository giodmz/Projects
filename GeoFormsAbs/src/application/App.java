package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;


public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            System.out.println("\nShape #" + (i + 1) + " data: ");
            System.out.print("Rectangle or Circle (r/c)? ");
            char key = sc.next().charAt(0);
            if (key == 'r') {
                System.out.print("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.next());
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                shapes.add(new Rectangle(color, width, height));
            }
            if (key == 'c'){
                System.out.print("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.next());
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                shapes.add(new Circle(color, radius));
            }
        }

        System.out.println("SHAPE DATA: ");
        for (Shape shape : shapes){
            System.out.printf("Area: %.2f%n", shape.area());
            System.out.println("Color: " + shape.getColor());
        }

        sc.close();
    }
}

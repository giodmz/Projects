import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);

        System.out.println("Witch geometry form do you want calculate?");
        System.out.println("1 - Triangle");
        System.out.println("2 - Square");
        System.out.println("3 - Rectangle");
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();

        
        
        switch (result) {
            case 1:
                calTriangle();
            break;

            case 2:
                calSquare();
            break;

            case 3:
                calRectangle();
            break;

            default:
            System.out.println("Try a valid option");
                break;
        }
        sc.close();

        
    }
        public static void calTriangle(){
            Scanner sc = new Scanner(System.in);

            Triangle x, y;
            x = new Triangle();
            y = new Triangle();
        
            System.out.println("Enter the measures of triangle X: ");
            x.a = sc.nextDouble();
            x.b = sc.nextDouble();
            x.c = sc.nextDouble();
    
            System.out.println("Enter the measures of triangle Y: ");
            y.a = sc.nextDouble();
            y.b = sc.nextDouble();
            y.c = sc.nextDouble();
    
            double areaX = x.area();
            double areaY = y.area();
    
            System.out.printf("\nTriangle X area: %.4f%n", areaX);
            System.out.printf("Triangle Y area: %.4f%n", areaY);
    
            if (areaX > areaY) {
                System.out.println("Larger area: X");
            } if (areaX < areaY){
                System.out.println("Larger area: Y");
            } else {
                System.out.println("They have the same area.");
            }

            sc.close();
        }

        public static void calSquare(){
            Scanner sc = new Scanner(System.in);

            Square x, y;
            x = new Square();
            y = new Square();


            System.out.println("Enter the measure of Square X: ");
            x.a = sc.nextDouble();
            
            System.out.println("Enter the measure of Square Y: ");
            y.a = sc.nextDouble();

            double areaX = x.area();
            double areaY = y.area();

            System.out.printf("\nSquare X area: %.4f%n", areaX);
            System.out.printf("Square Y area: %.4f%n", areaY);

            if (areaX > areaY) {
                System.out.println("Larger area: X");
            } if (areaX < areaY){
                System.out.println("Larger area: Y");
            } else {
                System.out.println("They have the same area.");
            }
            
            sc.close();
        }

        public static void calRectangle(){
            
            Scanner sc = new Scanner(System.in);

            Rectangle x, y;
            x = new Rectangle();
            y = new Rectangle();

            System.out.println("Enter the measures of Rectangle X: ");
            x.b = sc.nextDouble();
            x.h = sc.nextDouble();
            
            System.out.println("Enter the measures of Rectangle Y: ");
            y.b = sc.nextDouble();
            y.h = sc.nextDouble();

            double areaX = x.area();
            double areaY = y.area();

            System.out.printf("\nRectangle X area: %.4f%n", areaX);
            System.out.printf("Rectangle Y area: %.4f%n", areaY);

            if (areaX > areaY) {
                System.out.println("Larger area: X");
            } if (areaX < areaY){
                System.out.println("Larger area: Y");
            } else {
                System.out.println("They have the same area.");
            }
            
            sc.close();
        }
        
        
}


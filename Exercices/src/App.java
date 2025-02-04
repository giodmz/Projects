import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter the rectangle measures: ");

        // Rectangle rectangle = new Rectangle();
        // rectangle.width = sc.nextDouble();
        // rectangle.height = sc.nextDouble();

        // System.out.println(rectangle);

        // Employee employee = new Employee();

        // System.out.println("Enter the employee info: ");
        // System.out.println("Name: ");
        // employee.name = sc.next();
        // System.out.println("Gross Salary: ");
        // employee.grossSalary = sc.nextDouble();
        // System.out.println("Tax: ");
        // employee.tax = sc.nextDouble();

        // System.out.println(employee);

        // System.out.println("Increase the employee salary(percentage): ");
        // double percentage = sc.nextDouble();
        // employee.IncreaseSalary(percentage);

        // System.out.println("Updated data: " + employee);

        Student student = new Student();

        System.out.println("Enter Student infos: ");
        System.out.println("First semester: ");
        student.grade1 = sc.nextDouble();
        System.out.println("Second semester: ");
        student.grade2 = sc.nextDouble();
        System.out.println("Third semester: ");
        student.grade3 = sc.nextDouble();
        student.calculateGrade();
        System.out.println(student);
        

        sc.close();
    }
}

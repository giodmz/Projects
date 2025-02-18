package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.JuridicPeople;
import entities.People;
import entities.PhysicPeople;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<People> people = new ArrayList<>();

        System.out.println("Enter the number of tax payers: ");
        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            System.out.println("\nTax payer #" + (i + 1) + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char answer = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual income: ");
            double annualIncome = sc.nextDouble();
            if (answer == 'i'){
                System.out.print("Helath expenditures: ");
                double healthOutlay = sc.nextDouble();
                people.add(new PhysicPeople(name, annualIncome, healthOutlay));
            }
            if (answer == 'c') {
                System.out.print("Number of employees: ");
                int employeeN = sc.nextInt();
                people.add(new JuridicPeople(name, annualIncome, employeeN));
            }
        }

        System.out.println("\nTAXES PAID: ");
        for(People peoples : people){
            System.out.println(peoples.getName() + ": $" + peoples.tax());
        }

        double totalTaxes = 0.0;
        for (People peoples : people) {
            totalTaxes += peoples.tax();
        }
        System.out.println("\nTOTAL TAXES: $" + totalTaxes);
        
        sc.close();
    }
}

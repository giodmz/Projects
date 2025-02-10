import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("\nHow many employees will be registered? ");
        int input = sc.nextInt();


        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            System.out.println("\nEmployee #" + (i + 1));
            System.out.print("Id: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            Employee employee = new Employee(id, name, salary);
            employees.add(employee);
        }

        System.out.println("\nEnter the employee id that will have a salary increase: ");
        Integer id = sc.nextInt();

    
        Integer pos = findPosition(employees, id);

        // Busca o funcionário com o id igual ao input
        Employee employee = employees.stream()
        .filter(x -> x.getId() == id)
        .findFirst()
        .orElse(null);


        if (pos == null) {
            System.out.println("This id does not exist! ");
        } else {
            System.out.println("\nEnter the percentage: ");
            double percentage = sc.nextDouble();
            employee.increaseSalary(percentage);
        }
        
        
        System.out.println("\nList of employees: ");
        for ( Employee emp : employees){
            System.out.println(emp);
        }

        




        sc.close();
    }

    // Procura a posição e se o Id e retorna null se ele não existir
    public static Integer findPosition(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }   
        }
        return null;
    }
        
   

    
}



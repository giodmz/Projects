import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Employee> list = new ArrayList<>();
        String path = "C:\\Projects\\Comparable\\lib\\list.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String employeeCsv = br.readLine();
            
            while(employeeCsv != null){
                // split name and salary
                String[] fields = employeeCsv.split(",");
                // fields are splited by the , on csv archive
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCsv = br.readLine();
            }

            //sort can only be used if we implement the comparable class
            Collections.sort(list);
            for (Employee employee : list){
                System.out.println(employee.getName() + ", " + 
                employee.getSalary());
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());

        }
    }
}

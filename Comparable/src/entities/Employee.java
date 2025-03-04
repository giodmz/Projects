package entities;

public class Employee implements Comparable<Employee>{

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // compare the employees names
    // could replace "name" with "salary" to compare based on salary
    // - on the left (replace name) if want a descending list (double, int, etc)
    @Override
    public int compareTo(Employee other) {
        return name.compareTo(other.getName());
    }

    

    

}

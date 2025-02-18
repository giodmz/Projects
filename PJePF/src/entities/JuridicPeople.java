package entities;

public class JuridicPeople extends People {

    private int employeeN;

    public JuridicPeople(){

    }

    public JuridicPeople(String name, double annualIncome, int employeeN) {
        super(name, annualIncome);
        this.employeeN = employeeN;
    }

    public int getEmployeeN() {
        return employeeN;
    }

    public void setEmployeeN(int employeeN) {
        this.employeeN = employeeN;
    }

    @Override
    public double tax() {
        double tax = annualIncome * 16 / 100;
        if (employeeN > 10) {
            tax = annualIncome * 14 / 100;
        }
        return tax;
    }

}

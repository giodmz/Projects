package entities;

public abstract class People {

    private String name;
    protected double annualIncome;

    public People(){

    }

    public People(String name, double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public abstract double tax();
    

}

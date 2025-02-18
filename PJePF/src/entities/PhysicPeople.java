package entities;

public class PhysicPeople extends People {

    private double healthOutlay;

    public PhysicPeople(){

    }

    

    public PhysicPeople(String name, double annualIncome, double healthOutlay) {
        super(name, annualIncome);
        this.healthOutlay = healthOutlay;
    }


    public double getHealthOutlay() {
        return healthOutlay;
    }



    public void setHealthOutlay(double healthOutlay) {
        this.healthOutlay = healthOutlay;
    }


    @Override
    public double tax() {
        double tax = 0.0;
        if (annualIncome < 20000.00){
            tax = annualIncome * 0.15;
        } else {
            tax = annualIncome * 0.25;
        }
        tax = tax - (healthOutlay * 0.5);
        if (tax < 0.0){
            return 0.0;
        }

        return tax;
    }


    
}

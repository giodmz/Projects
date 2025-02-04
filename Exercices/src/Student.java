
public class Student {

    public String name;
    public double grade1;
    public double grade2;
    public double grade3;
    public double finalGrade = grade1 + grade2 + grade3;
    public boolean approve;

    public void verifyGrade(){
        if (finalGrade >= 60) {
            approve = true;
        } else {
            approve = false;
        }
        

    }

    public void calculateGrade(){

        double finalGrade = grade1 + grade2 + grade3;

        double missingPoints = finalGrade - 60;

        if (finalGrade >= 60) {
            System.out.println("PASS");
            System.out.println("FINAL GRADE: " + finalGrade);
        } else {
            System.out.println("FAILED ");
            System.out.println("MISSING " + missingPoints + " POINTS");
        }

    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", grade1=" + grade1 + ", grade2=" + grade2 + ", grade3=" + grade3
                + ", finalGrade=" + finalGrade + ", approve=" + approve + "]";
    }

    

    

}

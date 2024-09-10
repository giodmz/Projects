import java.util.Locale;
import java.util.Scanner;

public class App { 
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);        
        Scanner sc = new Scanner(System.in);

        String numberFun = sc.next();
        double valorHora = sc.nextDouble();
        double horasTrabalhadas =  sc.nextDouble();

        double salario = valorHora * horasTrabalhadas;

        System.out.printf("Número = %.0s%n", numberFun);
        System.out.printf("Salário = %.2f%n", salario);



        sc.close();
    }


}

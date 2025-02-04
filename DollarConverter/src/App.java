import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the dollar price? ");
        double price = sc.nextDouble();
        System.out.println("How many dollar wil be bought? ");
        double quantity = sc.nextDouble();

        double convertedCurrency = CurrencyConverter.Converter(price, quantity);
        System.out.printf("Amount to de paid in reais = $%.2f%n", convertedCurrency);
        

        sc.close();
    }
}

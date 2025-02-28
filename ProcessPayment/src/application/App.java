package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.OnlinePaymentService;
import services.PaypalService;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Insira os dados do contrato: ");
        System.out.print("Número: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDateTime date = LocalDate.parse(sc.nextLine(), formatter).atStartOfDay();
        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();
        System.out.print("Insira o número de parcelas: ");
        int installments = sc.nextInt();

        
        Installment installment = new Installment(date, totalValue);
        Contract contract = new Contract(number, date, totalValue, installment, new PaypalService());

        // ContractService.processContract(contract, installments);
        
        

        for (int i = 0; i < installments; i++) {
            System.out.println(installment.toString());
        }


        sc.close();
    }
}

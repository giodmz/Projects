package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
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
        Integer months = sc.nextInt(); 
    

        ContractService contractService = new ContractService(new PaypalService());
        Contract contract = new Contract(number, date, totalValue);

        contractService.processContract(contract, months);

        System.out.println("\nID: " + contract.getNumber() + " (Valor total: " + String.format("%.2f", contract.getTotalValue())+ "$)");
        System.out.println("Parcelas: ");
        for (Installment installment : contract.getInstallments()) {
        System.out.println(formatter.format(installment.getDate()) + " - " + String.format("%.2f", installment.getAmount()) + "$");
        }
        
        
        sc.close();
    }

    
}

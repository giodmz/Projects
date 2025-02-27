import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.model.CarRental;
import entities.model.Vehicle;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:ss");

        System.out.println("Entre com os dados do aluguel: ");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.println("Retirada (dd/MM/yyyy hh:mm)");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Retorno (dd/MM/yyyy hh:mm)");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental car = new CarRental(start, finish, new Vehicle(carModel));


        sc.close();
    }
}

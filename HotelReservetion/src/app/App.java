package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{ 
            System.out.println("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check-in date (dd/MM/yyyy)");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-in date (dd/MM/yyyy)");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            
            System.out.println("\n Enter data to update the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-in date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());
            
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } 
        catch (ParseException ex) {
            System.out.println("Invalid date format ");
        }
        catch (DomainException ex) {
            System.out.println("Error in reservation: " + ex.getMessage());
        }
        catch (RuntimeException ex){
            System.out.println("Unexpectad error");
        }

    sc.close();
        

    }
}

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Movie;
import entities.Ticket;



public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("--Cinema--");
        System.out.println("What do you want for today?");
        System.out.println("1- Search for a movie");
        System.out.println("2- Add a movie to the list");
        System.out.println("3- Buy a ticket");

        int input = sc.nextInt();

        switch (input) {
            case 3:

                break;
        
            default:
                break;
        }

        sc.close();
        
    }
    
        ArrayList<Movie> movie = new ArrayList<>();

        public void buyATicket(){

            Ticket ticket = new Ticket(0, null);
    
            System.out.println("Select the movie you want to watch: ");
            for(Movie movies : movie) {
            System.out.println("Movie: " + movies.getName() 
            + " Genre: " + movies.getType()
            + " $" + ticket.getPrice());
        }
    }
}

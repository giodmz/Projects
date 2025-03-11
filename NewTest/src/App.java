import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Movie;
import entities.Ticket;
import entities.enums.TypeMovie;



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
                buyATicket();
                break;
        
            default:
                break;
        }

        sc.close();
        
    }

    
    public static void buyATicket(){

            ArrayList<Movie> movie = new ArrayList<Movie>();
            Ticket ticket1 = new Ticket(20.00);
            Ticket ticket2 = new Ticket(25.00);
            Ticket ticket3 = new Ticket(15.00);
            Movie movie1 = new Movie("Star Wars", TypeMovie.FICTION, ticket1);
            Movie movie2 = new Movie("Star Wars", TypeMovie.FICTION, ticket2);
            Movie movie3 = new Movie("Star Wars", TypeMovie.FICTION, ticket3);

            movie.add(movie1);
            movie.add(movie2);
            movie.add(movie3);
             
            System.out.println("Select the movie you want to watch: ");
            for(Movie movies : movie) {
            System.out.println("Movie: " + movies.getName() 
            + " Genre: " + movies.getType()
            + " $" + movies.getTicket().getPrice());
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            case 1:
                movieSearch();
                break;
            case 2:
                addAMovie();
                break;
            case 3:
                buyATicket();
                break;
        
            default:
                break;
        }

        sc.close();
        
    }

    public static void movieSearch(){
        System.out.println("Catalog: ");
        String path = "C:\\Projects\\NewTest\\lib\\movies.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String movieName = fields[0];
                String movieGenre = fields[1];
                
                System.out.println("Movie: " + movieName
                + " - Genre: " + movieGenre);
                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }


    public static void addAMovie(){

        Scanner sc = new Scanner(System.in);
        String path = "C:\\Projects\\NewTest\\lib\\movies.csv";
        System.out.println("Film name: ");
        String lines = sc.next();
        System.out.println("Film genre: ");
        String genre = sc.next();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.newLine();
            bw.write(lines);
            bw.write("," + genre);
        } catch (IOException ex) {
            ex.getMessage();
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

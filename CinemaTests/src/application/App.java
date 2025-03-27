package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import entities.Movie;
import entities.Ticket;
import entities.enums.TypeMovie;

public class App {

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        menu();

    }

    public static void menu() {
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

    public static void menuLoop() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nRetornar ao menu? (s/n)");
        String input = sc.next();
        if (input.charAt(0) == 's') {
            menu();
        } else {
            System.exit(0);
        }

        sc.close();
    }

    public static void movieSearch() {

        // lista todos os filmes catalogados nos arquivo .csv

        System.out.println("Catalog: ");
        String path = "C:\\Projects\\NewTest\\lib\\movies.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
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

        menuLoop();

    }

    public static void addAMovie() {

        // adiciona filmes no arquivo .csv

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

        menuLoop();

        sc.close();
    }

    public static void buyATicket() {

        ArrayList<Movie> movie = new ArrayList<Movie>();

        Ticket ticket1 = new Ticket(20.00);
        Ticket ticket2 = new Ticket(25.00);
        Ticket ticket3 = new Ticket(15.00);
        Ticket ticket4 = new Ticket(9.00);
        Movie movie1 = new Movie("Star Wars", TypeMovie.FICTION, ticket1);
        Movie movie2 = new Movie("Zootopia", TypeMovie.FICTION, ticket2);
        Movie movie3 = new Movie("Hobbit", TypeMovie.FICTION, ticket3);
        Movie movie4 = new Movie("Avengers", TypeMovie.FICTION, ticket4);


        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);

        //predicate
        double min = 9.00;
        movie.removeIf(m -> m.getTicket().getPrice() <= min);

        //consumer
        double priceUpdt = 1.2;
        movie.forEach(m -> m.getTicket().setPrice(m.getTicket().getPrice() * priceUpdt));

        // ordenar os filmes em ordem alfabética utilizando o comparator
        // arrow function (->)
        // comp recebe dois argumentos para comparar e o resultado é o return

        // Comparator<Movie> comp = (c1, c2) -> {
        // return c1.getName().toUpperCase().compareTo(c2.getName().toUpperCase());
        // };

        movie.sort((c1, c2) -> c1.getName().toUpperCase().compareTo(c2.getName().toUpperCase()));

        //function
        List<String> names = movie.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

        Thread movieThread = new Thread(() -> {
            System.out.println("Select the movie you want to watch: ");
            for (Movie movies : movie) {
                System.out.println("Movie: " + movies.getName()
                        + ", Genre: " + movies.getType()
                        + ", $" + movies.getTicket().getPrice());
            }

        });
        movieThread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
            menuLoop();
        } catch (InterruptedException ex){
            ex.getMessage();
        }

    }

}

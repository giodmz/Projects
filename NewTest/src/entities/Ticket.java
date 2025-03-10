package entities;

public class Ticket {

    private double price;
    private Movie movie;

    public Ticket(double price, Movie movie) {
        this.price = price;
        this.movie = movie;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    
    

}

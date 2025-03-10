package entities;

import java.util.ArrayList;

public class Movie {
    
    private String name;
    private TypeMovie type;
    private Ticket ticket;

    ArrayList<Movie> movie = new ArrayList<>();
    

    public Movie(String name, TypeMovie type, ArrayList<Movie> movie) {
        this.name = name;
        this.type = type;
        this.movie = movie;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public TypeMovie getType() {
        return type;
    }
    public void setType(TypeMovie type) {
        this.type = type;
    }

    public ArrayList<Movie> getMovie() {
        return movie;
    }

    


    





}

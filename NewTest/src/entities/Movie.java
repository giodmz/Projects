package entities;

import entities.enums.TypeMovie;

public class Movie {
    
    private String name;
    private TypeMovie type;
    private Ticket ticket;

    public Movie(){
        
    }
    
    public Movie(String name, TypeMovie type, Ticket ticket) {
        this.name = name;
        this.type = type;
        this.ticket = ticket;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Movie [name=" + name + ", type=" + type + ", ticket=" + ticket + "]";
    }

    
    



    


    





}

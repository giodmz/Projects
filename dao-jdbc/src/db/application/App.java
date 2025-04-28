package db.application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import db.model.entities.Department;
import db.model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        Department obj = new Department(1, "we");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String day = "21/03/2004";
        Seller sell = new Seller(2, "ca", "ha", LocalDate.parse(day, fmt), 500.0,obj);
        System.out.println(obj);
        System.out.println(sell);
    }
}

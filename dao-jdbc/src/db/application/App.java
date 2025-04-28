package db.application;

import db.model.entities.Department;

public class App {
    public static void main(String[] args) throws Exception {
        
        Department obj = new Department(1, "we");
        System.out.println(obj);
    }
}

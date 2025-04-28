package db.application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import db.model.dao.DaoFactory;
import db.model.dao.SellerDao;
import db.model.entities.Department;
import db.model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        Department obj = new Department(1, "we");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String day = "21/03/2004";
        Seller sell = new Seller(2, "ca", "ha", LocalDate.parse(day, fmt), 500.0,obj);
        
        // o programa não conhece a sellerDao, apenas a interface
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        Seller seller = sellerDao.findById(3);
        
        System.out.println(obj);
        System.out.println(sell);
        System.out.println(seller);
    }
}

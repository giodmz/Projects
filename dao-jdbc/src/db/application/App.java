package db.application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        
        System.out.println("test - seller findById");
        Seller seller = sellerDao.findById(3);
        
        System.out.println("\ntest - seller findByDepartment");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller sellers : list) {
            System.out.println(sellers);
        }
    }
}

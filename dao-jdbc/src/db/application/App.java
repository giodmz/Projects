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
        
        // o programa não conhece a sellerDao, apenas a interface
        SellerDao sellerDao = DaoFactory.createSellerDao();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        System.out.println("test - seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        
        System.out.println("\ntest - seller findByDepartment");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller sellers : list) {
            System.out.println(sellers);
        }

        System.out.println("\ntest - seller findAll");
        list = sellerDao.findAll();
        for (Seller sellers : list) {
            System.out.println(sellers);
        }
        
        System.out.println("\ntest - seller insert");
        Seller newSeller = new Seller(null, 
        "Marcelo", 
        "pneuqueimado@gmail.com", 
        LocalDate.parse("21-04-2000", dtf), 
        4000.0, 
        department);
        
        sellerDao.insert(newSeller);
        System.out.println("Inserted - new ID = " + newSeller.getId());
    }
}

package db.application;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import db.model.dao.DaoFactory;
import db.model.dao.SellerDao;
import db.model.entities.Department;
import db.model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

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
        
        System.out.println("\ntest - seller update");
        seller = sellerDao.findById(1);
        seller.setName("Gustavo Rocha");
        sellerDao.update(seller);
        System.out.println("successful update");

        System.out.println("\ntest - seller delete");
        System.out.println("Enter id for delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("successful delete");

        sc.close();
    }
}

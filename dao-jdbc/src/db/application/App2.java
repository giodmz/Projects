package db.application;

import java.util.List;
import java.util.Scanner;

import db.model.dao.DaoFactory;
import db.model.dao.DepartmentDao;
import db.model.entities.Department;

public class App2 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // o programa não conhece a sellerDao, apenas a interface
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("test - seller findById");
        Department department = departmentDao.findById(3);
        System.out.println(department);
        

        System.out.println("\ntest - seller findAll");
        List<Department> list = departmentDao.findAll();
        for (Department departments : list) {
            System.out.println(departments);
        }
        

        System.out.println("\ntest - seller insert");
        Department newDepartment = new Department(null, "HighTec");
        
        
        departmentDao.insert(newDepartment);
        System.out.println("Inserted - new ID = " + newDepartment.getId());
        
        System.out.println("\ntest - seller update");
        department = departmentDao.findById(1);
        department.setName("Vox");
        departmentDao.update(department);

        System.out.println("successful update");
        

        System.out.println("\ntest - seller delete");
        System.out.println("Enter id for delete: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("successful delete");

        sc.close();

    }

}

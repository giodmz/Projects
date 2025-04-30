package db.model.dao;

import java.util.List;

import db.model.entities.Department;
import db.model.entities.Seller;

public interface SellerDao {

    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);

}

package db.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import db.model.dao.SellerDao;
import db.model.entities.Department;
import db.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Seller findById(Integer id) {
        
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT seller.*,department.Name as DepName"
            + " FROM seller INNER JOIN department"
            + " ON seller.DepartmentId = department.Id"
            + " WHERE seller.Id = ?");

            //recebe o id que foi passado como parametro
            st.setInt(1, id);

            //executa o comando SQL e envia para o ResultSet
            rs = st.executeQuery();

            //testa se houve algum resultado
            if(rs.next()) {
                Department dep = new Department();
                //acessa e instancia department
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DepName"));
                Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                obj.setDepartment(dep);
                return obj;
            }
            return null;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}

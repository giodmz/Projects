package db.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import db.model.dao.SellerDao;
import db.model.entities.Department;
import db.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO seller"
            + " (Name, Email, Birthdate, BaseSalary, DepartmentId)"
            +" VALUES (?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, java.sql.Date.valueOf(obj.getBirthDate()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());

            int rowsAffected = st.executeUpdate();

            // verifica se algum objeto foi afetado e o atrela a um novo id
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("No rows affected");
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE seller"
            + " SET Name=?,Email=?,BirthDate=?,BaseSalary=?,DepartmentId"
            + " WHERE Id = ?");

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, java.sql.Date.valueOf(obj.getBirthDate()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());
            st.setInt(6, obj.getId());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM seller"
            + " WHERE Id = ?");

            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected == 0) {
                throw new DbException("invalid id");
            }

        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
        }
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

            // recebe o id que foi passado como parametro
            st.setInt(1, id);

            // executa o comando SQL e envia para o ResultSet
            rs = st.executeQuery();

            // testa se houve algum resultado
            if (rs.next()) {
                Department dep = instanceDepartment(rs);
                // acessa e instancia department
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DepName"));
                Seller obj = instanceSeller(rs, dep);
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

    private Seller instanceSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate").toLocalDate());
        obj.setDepartment(dep);
        return obj;
    }

    private Department instanceDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT seller.*,department.Name as DepName"
                    + " FROM seller INNER JOIN department"
                    + " ON seller.DepartmentId = department.Id"
                    + " ORDER BY Name");

            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            
            // mapeia para evitar repetição de departamentos
            Map<Integer,Department> map = new HashMap<>();

            // percorre os resultados e adiciona na lista, logo depois retorna a mesma
            while (rs.next()) {

                // testa se o departamento existe ou não (usando o ID)
                Department dep = map.get(rs.getInt("DepartmentId"));

                // se o departamento ja existe ele vai cair no map e o if vai resultar em null
                if (dep == null) {
                    dep = instanceDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instanceSeller(rs, dep);
                list.add(obj);
            }
            return list;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT seller.*,department.Name as DepName"
                    + " FROM seller INNER JOIN department"
                    + " ON seller.DepartmentId = department.Id"
                    + " WHERE Department.Id = ?"
                    + " ORDER BY Name");

            st.setInt(1, department.getId());

            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            
            // mapeia para evitar repetição de departamentos
            Map<Integer,Department> map = new HashMap<>();

            // percorre os resultados e adiciona na lista, logo depois retorna a mesma
            while (rs.next()) {

                // testa se o departamento existe ou não (usando o ID)
                Department dep = map.get(rs.getInt("DepartmentId"));

                // se o departamento ja existe ele vai cair no map e o if vai resultar em null
                if (dep == null) {
                    dep = instanceDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instanceSeller(rs, dep);
                list.add(obj);
            }
            return list;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

}

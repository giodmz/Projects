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
import db.model.dao.DepartmentDao;
import db.model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO department"
            + " (Name)"
            +" VALUES (?)",
            Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

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
    public void update(Department obj) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE department"
            + " SET Name=?"
            + " WHERE Id = ?");

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

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
            st = conn.prepareStatement("DELETE FROM department"
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
    public Department findById(Integer id) {
        
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM department"
                    + " WHERE Id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = instanceDepartment(rs);
                // acessa e instancia department
                dep.setId(rs.getInt("Id"));
                dep.setName(rs.getString("Name"));
                return dep;
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
    public List<Department> findAll() {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM department"
                    + " ORDER BY Name");

            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();
            
            // mapeia para evitar repetição de departamentos
            Map<Integer,Department> map = new HashMap<>();

            // percorre os resultados e adiciona na lista, logo depois retorna a mesma
            while (rs.next()) {

                // testa se o departamento existe ou não (usando o ID)
                Department dep = map.get(rs.getInt("Id"));

                // se o departamento ja existe ele vai cair no map e o if vai resultar em null
                if (dep == null) {
                    dep = instanceDepartment(rs);
                    map.put(rs.getInt("Id"), dep);
                }

                list.add(dep);
            }
            return list;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Department instanceDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

}

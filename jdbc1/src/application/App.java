package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class App {
    public static void main(String[] args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // connect with the server
        Connection conn = DB.getConnection();
        Statement st = null;
        ResultSet rs = null;

        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();

            // do not auto confirm operations
            conn.setAutoCommit(false);

            // ps = conn.prepareStatement(
            //     "INSERT INTO seller "
            //     + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
            //     + "VALUES "
            //     + "(?, ?, ?, ?, ?)",
            //     Statement.RETURN_GENERATED_KEYS); // placeholder
            // ps.setString(1, "Carl Johnson");
            // ps.setString(2, "carl@gmail.com");
            // date no sql
            // ps.setDate(3, new java.sql.Date(sdf.parse("22/03/1998").getTime()));
            // ps.setDouble(4, 3999.99);
            // ps.setInt(5, 4);


            // update database command
            // ps = conn.prepareStatement("UPDATE seller "
            //     + "SET BaseSalary = BaseSalary + ? "
            //     + "WHERE "
            //     + "(DepartmentId = ?)");
            // ps.setDouble(1, 200.0);
            // ps.setInt(2, 2);

            // ps = conn.prepareStatement(
            //     "DELETE FROM department "
            //     + "WHERE " // IMPORTANT!!
            //     + "Id = ?");
            // ps.setInt(1, 2);

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2100 WHERE DepartmentId = 1");

            // int x = 1;
            // if (x <2) {
            //     throw new SQLException("Error");
            // }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3100 WHERE DepartmentId = 2");
            // update the data on database


            // confirm transation
            conn.commit();

            // int rowsAffected =  ps.executeUpdate();

            // System.out.println("Rows affeceted: " + rowsAffected);

            // sql command line
            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

            // if (rowsAffected > 0) {
            //     // return new ids on database
            //     ResultSet rsKey = ps.getGeneratedKeys();
            //     while (rsKey.next()) {
            //         int id = rsKey.getInt(1);
            //         System.out.println("ID = " + id);
            //     }
            // } else {
            //     System.out.println("No rows affected.");
            // }

        } catch (SQLException ex) {
            // return transaction to the initial point
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back (" + ex.getMessage()
                + ")");
            } catch (SQLException e1) {
                throw new DbException("Error on rollback (" + e1.getMessage() + ")");
            }
            // throw new DbIntegrityException(ex.getMessage());
        // } catch (ParseException ex) {
        //     ex.printStackTrace();
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}

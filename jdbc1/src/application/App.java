package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class App {
    public static void main(String[] args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = DB.getConnection();
        Statement st = null;
        ResultSet rs = null;

        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            ps = conn.prepareStatement(
                "INSERT INTO seller "
                + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                + "VALUES "
                + "(?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS); // placeholder
            ps.setString(1, "Carl Johnson");
            ps.setString(2, "carl@gmail.com");
            // date no sql
            ps.setDate(3, new java.sql.Date(sdf.parse("22/03/1998").getTime()));
            ps.setDouble(4, 3999.99);
            ps.setInt(5, 4);

            // update the data on database
            int rowsAffected =  ps.executeUpdate();

            // sql command line
            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

            if (rowsAffected > 0) {
                // return new ids on database
                ResultSet rsKey = ps.getGeneratedKeys();
                while (rsKey.next()) {
                    int id = rsKey.getInt(1);
                    System.out.println("ID = " + id);
                }
            } else {
                System.out.println("No rows affected.");
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}

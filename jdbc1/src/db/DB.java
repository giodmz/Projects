package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection(){
        if (conn == null){
            try {   
                Properties props = loadProparties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex){
                throw new DbException(ex.getMessage());
            }
        }
    }

    private static Properties loadProparties(){
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException ex){
            throw new DbException(ex.getMessage());
        }
    }

}

package DataAccess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 12123_000
 */


public class DataProvider {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost/hdocument";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "liclac";
    
    private static Connection conn = null;
    private static  Statement stmt = null;
    
    
    
    
    @Override
    public  void finalize() throws Throwable {

        conn.close();
    }
    
    public static boolean ExecuteUpdtae(String sql) 
    {
        try {
             Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            //STEP 4: Execute a query
            
            stmt = conn.createStatement();
            
            stmt.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static ResultSet ExecuteSelect(String sql)
    {
        ResultSet rs = null;
        try {
             Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection

            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            //STEP 4: Execute a query
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratory;

import org.sqlite.SQLiteDataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author shubhdashail
 */
public class LabInventory {
      static SQLiteDataSource ds = null;
        static Connection sqliteConnection;
    public static Connection connectiondb(){
        try{
            ds = new SQLiteDataSource();
            System.out.println("ds");
            ds.setUrl("jdbc:sqlite:hospManagement.db");
            System.out.println("ds set");
            sqliteConnection = ds.getConnection();
            System.out.println("sqliteConnection set");
            //Class.forName("org.sqlite.JDBC");
            //Connection conn = DriverManager.getConnection("jdbc;sqlite:laboratory.sqlite");
            //JOptionPane.showMessageDialog(null, "successfully connected to "+conn);
            //return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

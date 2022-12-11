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
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author shubhdashail
 */
public class LabInventory {
      static SQLiteDataSource ds = null;
    static Connection sqliteConnection;
    static Statement statement;
    
     private static String CREATE_LABTEST_TABLE_SQL = "CREATE TABLE IF NOT EXISTS LABTEST ("
            + "PateintId INTEGER(3) PRIMARY KEY NOT NULL," + "DoctorName VARCHAR(50) NOT NULL,"
            + "PatientName NOT NULL," + "Age INTEGER(3) NOT NULL," + "gender VARCHAR(6) NOT NULL,"
            + "BloodGroup VARCHAR(3) NOT NULL," + "Specimen VARCHAR(20) NOT NULL," +
             "Department VARCHAR(50) NOT NULL)";
     
}

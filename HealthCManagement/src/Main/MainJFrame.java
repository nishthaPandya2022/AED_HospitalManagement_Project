package Main;


import UILaboratory.Lab_Console;
import java.sql.Statement;
import java.sql.Connection;
import java.io.File;
import org.sqlite.SQLiteDataSource;
//import pharmacy.Medicines;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author nishthapandya
 */
public class MainJFrame extends javax.swing.JFrame {

    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;
    static Statement statement;

    private static String CREATE_LOGIN_TABLE_SQL = "CREATE TABLE IF NOT EXISTS login ("
            + "username VARCHAR(200) NOT NULL," + "password VARCHAR(200) NOT NULL)";

    private static String CREATE_TEMP_TABLE_SQL = "CREATE TABLE IF NOT EXISTS temp (" + "root VARCHAR(300) NOT NULL,"
            + "directory VARCHAR(300) NOT NULL," + "path VARCHAR(300) NOT NULL," + "added INT NOT NULL,"
            + "removed INT NOT NULL," + "modified INT NOT NULL," + "hash VARCHAR(300) NOT NULL,"
            + "dateModified VARCHAR(300) NOT NULL)";
    
//   CREATING TABLES FOR PHARMACY
    
     private static String CREATE_MEDICINE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS medicine ("
            + "MedId INTEGER(3) PRIMARY KEY NOT NULL," + "MedName VARCHAR(50) NOT NULL,"
            + "MedPrice INTEGER(7) NOT NULL," + "MedQty INTEGER(7) NOT NULL," + "MedFab DATE NOT NULL,"
            + "MedExp DATE NOT NULL," + "MedComp VARCHAR(50) NOT NULL)";
    
     private static String CREATE_AGENT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS agent ("
            + "AgeId INTEGER(3) PRIMARY KEY NOT NULL," + "AgeName VARCHAR(50) NOT NULL," + "AgeAge INTEGER(3) NOT NULL,"
            + "AgePhone INTEGER(11) NOT NULL," + "AgePass VARCHAR(50) NOT NULL," + "AgeGend VARCHAR(50) NOT NULL)";
     
     private static String CREATE_COMPANY_TABLE_SQL = "CREATE TABLE IF NOT EXISTS company ("
            + "CompId INTEGER(3) PRIMARY KEY NOT NULL," + "CompName VARCHAR(50) NOT NULL,"
            + "CompAddress VARCHAR(200) NOT NULL," + "CompPhone INTEGER(11) NOT NULL," + "CompExp INTEGER(5) NOT NULL)";
     
//   CREATING TABLES FOR Laboratory
     private static String CREATE_LABTEST_TABLE_SQL = "CREATE TABLE IF NOT EXISTS LABTEST ("
            + "PateintId INTEGER(3) PRIMARY KEY NOT NULL," + "DoctorName VARCHAR(50) NOT NULL,"
            + "PatientName NOT NULL," + "Age INTEGER(3) NOT NULL," + "gender VARCHAR(6) NOT NULL,"
            + "BloodGroup VARCHAR(3) NOT NULL," + "Specimen VARCHAR(20) NOT NULL," +
             "Department VARCHAR(50) NOT NULL)";

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainHospital = new javax.swing.JButton();
        mainPharmacy = new javax.swing.JButton();
        mainLaboratory = new javax.swing.JButton();
        mainBloodBank = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainHospital.setText("Hospital");

        mainPharmacy.setText("Pharmacy");
        mainPharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainPharmacyActionPerformed(evt);
            }
        });

        mainLaboratory.setText("Laboratory");
        mainLaboratory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainLaboratoryActionPerformed(evt);
            }
        });

        mainBloodBank.setText("Blood Bank");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainLaboratory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                        .addComponent(mainBloodBank))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainHospital)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainPharmacy)))
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainHospital)
                    .addComponent(mainPharmacy))
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainLaboratory)
                    .addComponent(mainBloodBank))
                .addContainerGap(453, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainLaboratoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainLaboratoryActionPerformed
        // TODO add your handling code here:
        new Lab_Console().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mainLaboratoryActionPerformed

    private void mainPharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPharmacyActionPerformed
        //new Medicines().setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_mainPharmacyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            String userDirectory = System.getProperty("user.dir");
            System.out.println(userDirectory);
            userDirectory = userDirectory + "/hospManagement.db";
            File dbFile = new File(userDirectory);
            
            ds = new SQLiteDataSource();

            if (dbFile.exists()) {
                System.out.println("dbFile exists");
                ds.setUrl("jdbc:sqlite:hospManagement.db");
                sqliteConnection = ds.getConnection();
                statement = sqliteConnection.createStatement();
//			getDirectoriesForHash("/home/nishthapandya/Pictures");
//			statement.executeUpdate(CREATE_TABLE_SQL);
            } else {
                System.out.println("dbFile doesn't exist");

                ds.setUrl("jdbc:sqlite:hospManagement.db");
                sqliteConnection = ds.getConnection();
                statement = sqliteConnection.createStatement();

                statement.executeUpdate(CREATE_LOGIN_TABLE_SQL);
//              statement.executeUpdate(CREATE_TEMP_TABLE_SQL);
                
//              PHARMACY TABLES
                statement.executeUpdate(CREATE_MEDICINE_TABLE_SQL);
                statement.executeUpdate(CREATE_AGENT_TABLE_SQL);
                statement.executeUpdate(CREATE_COMPANY_TABLE_SQL);
                
//              LABORATORY TABLES
                statement.executeUpdate(CREATE_LABTEST_TABLE_SQL);
//            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton mainBloodBank;
    private javax.swing.JButton mainHospital;
    private javax.swing.JButton mainLaboratory;
    private javax.swing.JButton mainPharmacy;
    // End of variables declaration//GEN-END:variables

}
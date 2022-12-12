package ui;


import ui.admin.AdminJFrame;
import java.sql.Statement;
import java.sql.Connection;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.sqlite.SQLiteDataSource;
import pharmacy.Medicines;

/**
 *
 * @author nishthapandya
 */
public class MainJFrame extends javax.swing.JFrame {

    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;
    static Statement statement;

    private static final String CREATE_LOGIN_TABLE_SQL = "CREATE TABLE IF NOT EXISTS login ("
            + "loginID VARCHAR(200) NOT NULL," + "userID VARCHAR(200) NOT NULL,"
            + "username VARCHAR(200) NOT NULL," + "password VARCHAR(200) NOT NULL)";
    
    private static final String CREATE_HOSPITAL_TABLE_SQL = "CREATE TABLE IF NOT EXISTS hospital ("
            + "userID VARCHAR(200) NOT NULL," + "name VARCHAR(200) NOT NULL,"
            + "DOB VARCHAR(200) NOT NULL," + "age VARCHAR(200) NOT NULL,"
            + "organization VARCHAR(200) NOT NULL," + "phoneNumber VARCHAR(200) NOT NULL,"
            + "address VARCHAR(200) NOT NULL," + "community VARCHAR(200) NOT NULL,"
            + "state VARCHAR(200) NOT NULL," + "zipcode VARCHAR(200) NOT NULL,"
            + "role VARCHAR(200) NOT NULL);";

    private static final String INSERT_LOGIN_ADMIN = "INSERT INTO login (loginID, userID, username, password)"
            + " VALUES('" + 1 + "','" + 1 + "','admin'," + "'admin');";
    
    private static final String CREATE_APPOINTMENT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS appointment "
            + "(appointmentID VARCHAR(200) NOT NULL, " + "patientID VARCHAR(200) NOT NULL," 
            + "patientName VARCHAR(200) NOT NULL,"+ "doctorID VARCHAR(200) NOT NULL,"
            + "doctorName VARCHAR(200) NOT NULL," + "temperature VARCHAR(200) NOT NULL,"
            + "bloodPressure VARCHAR(200) NOT NULL," + "weight VARCHAR(200) NOT NULL," 
            + "height VARCHAR(200) NOT NULL," + "heartRate VARCHAR(200),"+"diagnosis VARCHAR(300) NOT NULL);";
    
//   CREATING TABLES FOR PHARMACY
    
    private static final String CREATE_MEDICINE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS medicine ("
            + "MedId INTEGER(3) PRIMARY KEY NOT NULL," + "MedName VARCHAR(50) NOT NULL,"
            + "MedPrice INTEGER(7) NOT NULL," + "MedQty INTEGER(7) NOT NULL," + "MedFab DATE NOT NULL,"
            + "MedExp DATE NOT NULL," + "MedComp VARCHAR(50) NOT NULL)";
    
    private static final String CREATE_AGENT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS agent ("
            + "AgeId INTEGER(3) PRIMARY KEY NOT NULL," + "AgeName VARCHAR(50) NOT NULL," + "AgeAge INTEGER(3) NOT NULL,"
            + "AgePhone INTEGER(11) NOT NULL," + "AgePass VARCHAR(50) NOT NULL," + "AgeGend VARCHAR(50) NOT NULL)";
     
    private static final String CREATE_COMPANY_TABLE_SQL = "CREATE TABLE IF NOT EXISTS company ("
            + "CompId INTEGER(3) PRIMARY KEY NOT NULL," + "CompName VARCHAR(50) NOT NULL,"
            + "CompAddress VARCHAR(200) NOT NULL," + "CompPhone INTEGER(11) NOT NULL," + "CompExp INTEGER(5) NOT NULL)";
    
    private static String CREATE_LABTEST_TABLE_SQL = "CREATE TABLE IF NOT EXISTS labtest ("
            + "Pateint_ID INTEGER(3) PRIMARY KEY NOT NULL," + "DoctorName VARCHAR(50) NOT NULL,"
            + "Name VARCHAR(20) NOT NULL," + "Age INTEGER(3) NOT NULL," + "gender VARCHAR(6) NOT NULL,"
            + "Blood_Group VARCHAR(3) NOT NULL," + "Tests VARCHAR(20) NOT NULL," +
             "Department VARCHAR(50) NOT NULL)";
    
    private static String CREATE_DONOR_TABLE_SQL = "CREATE TABLE IF NOT EXISTS donor ("
            + "DonId INTEGER(3) PRIMARY KEY NOT NULL," + "DonName VARCHAR(50) NOT NULL,"
            + "DonFather VARCHAR(200) NOT NULL," + "DonMother VARCHAR(200) NOT NULL," + "DonDob DATE NOT NULL,"
            + "DonMobile INTEGER(11) NOT NULL," + "DonGend VARCHAR(50) NOT NULL," + "DonEmail VARCHAR(100) NOT NULL,"
            + "DonBlood VARCHAR(10) NOT NULL," + "DonCity VARCHAR(200) NOT NULL," + "DonAddress VARCHAR(100) NOT NULL)";
     
     private static String CREATE_STOCK_TABLE_SQL = "CREATE TABLE IF NOT EXISTS stock ("
            + "BloodGroup VARCHAR(20) NOT NULL," + "BloodUnits INTEGER(100) NOT NULL)";
     
     
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

        jPanel1 = new javax.swing.JPanel();
        mainHospital = new javax.swing.JButton();
        mainLaboratory = new javax.swing.JButton();
        mainPharmacy = new javax.swing.JButton();
        mainBloodBank = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(67, 103, 72));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(53, 85, 53));
        jPanel1.setForeground(new java.awt.Color(51, 102, 0));

        mainHospital.setFont(new java.awt.Font("Oriya MN", 0, 18)); // NOI18N
        mainHospital.setText("Hospital");
        mainHospital.setMaximumSize(new java.awt.Dimension(100, 30));
        mainHospital.setMinimumSize(new java.awt.Dimension(100, 30));
        mainHospital.setPreferredSize(new java.awt.Dimension(100, 30));
        mainHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainHospitalActionPerformed(evt);
            }
        });

        mainLaboratory.setFont(new java.awt.Font("Oriya MN", 0, 18)); // NOI18N
        mainLaboratory.setText("Laboratory");
        mainLaboratory.setMaximumSize(new java.awt.Dimension(100, 30));
        mainLaboratory.setMinimumSize(new java.awt.Dimension(100, 30));
        mainLaboratory.setPreferredSize(new java.awt.Dimension(100, 30));
        mainLaboratory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainLaboratoryActionPerformed(evt);
            }
        });

        mainPharmacy.setFont(new java.awt.Font("Oriya MN", 0, 18)); // NOI18N
        mainPharmacy.setText("Pharmacy");
        mainPharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainPharmacyActionPerformed(evt);
            }
        });

        mainBloodBank.setFont(new java.awt.Font("Oriya MN", 0, 18)); // NOI18N
        mainBloodBank.setText("Blood Bank");
        mainBloodBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainBloodBankActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mainHospital, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(mainLaboratory, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(192, 192, 192)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainBloodBank, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainLaboratory, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainBloodBank, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainHospitalActionPerformed
        // TODO add your handling code here:
        dispose();
        LoginJFrame loginFrame = new LoginJFrame();
        loginFrame.setVisible(true);
    }//GEN-LAST:event_mainHospitalActionPerformed

    private void mainPharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPharmacyActionPerformed
        // TODO add your handling code here:
        dispose();
        LoginJFrame loginFrame = new LoginJFrame();
        loginFrame.setVisible(true);
    }//GEN-LAST:event_mainPharmacyActionPerformed

    private void mainLaboratoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainLaboratoryActionPerformed
        // TODO add your handling code here:
        dispose();
        LoginJFrame loginFrame = new LoginJFrame();
        loginFrame.setVisible(true);
    }//GEN-LAST:event_mainLaboratoryActionPerformed

    private void mainBloodBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainBloodBankActionPerformed
        // TODO add your handling code here:
        dispose();
        LoginJFrame loginFrame = new LoginJFrame();
        loginFrame.setVisible(true);
    }//GEN-LAST:event_mainBloodBankActionPerformed

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
                statement.executeUpdate(CREATE_HOSPITAL_TABLE_SQL);
                statement.executeUpdate(CREATE_APPOINTMENT_TABLE_SQL);
                statement.executeUpdate(CREATE_LABTEST_TABLE_SQL);
                statement.executeUpdate(CREATE_DONOR_TABLE_SQL);
                statement.executeUpdate(CREATE_STOCK_TABLE_SQL);
                boolean insertDone = statement.execute(INSERT_LOGIN_ADMIN);
//              statement.executeUpdate(CREATE_TEMP_TABLE_SQL);
                
//              PHARMACY TABLES
                statement.executeUpdate(CREATE_MEDICINE_TABLE_SQL);
                statement.executeUpdate(CREATE_AGENT_TABLE_SQL);
                statement.executeUpdate(CREATE_COMPANY_TABLE_SQL);
//            
                
                System.out.println("insertDone : " + insertDone);
//            statement.executeUpdate(CREATE_TEMP_TABLE_SQL);
            }
        } catch (SQLException e) {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mainBloodBank;
    private javax.swing.JButton mainHospital;
    private javax.swing.JButton mainLaboratory;
    private javax.swing.JButton mainPharmacy;
    // End of variables declaration//GEN-END:variables

}

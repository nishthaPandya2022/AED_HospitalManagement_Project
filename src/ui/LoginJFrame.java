package ui;


import UILaboratory.Lab_Console;
import bloodBank.BloodHome;
import ui.admin.AdminJFrame;
import java.sql.Connection;
import java.sql.SQLException;
import org.sqlite.SQLiteDataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pharmacy.Medicines;
import ui.doctor.DoctorHomeJFrame;
import ui.receptionist.ReceptionistHomeJFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author nishthapandya
 */
public class LoginJFrame extends javax.swing.JFrame {

    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;
    static Statement statement;

    private static final String SEARCH_ADMIN_LOGIN = "SELECT username, password from login;";

    /**
     * Creates new form LoginJFrame
     */
    public LoginJFrame() {
        initComponents();

        try {
            ds = new SQLiteDataSource();
            System.out.println("ds");
            ds.setUrl("jdbc:sqlite:hospManagement.db");
            System.out.println("ds set");
            sqliteConnection = ds.getConnection();
            System.out.println("sqliteConnection set");

        } catch (Exception e) {
            e.printStackTrace();
        }

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
        passwordField = new javax.swing.JPasswordField();
        labelPassword = new javax.swing.JLabel();
        labelLogInScreen = new javax.swing.JLabel();
        textUserName = new javax.swing.JTextField();
        labelUserName = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        bBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 65, 31));
        jPanel1.setForeground(new java.awt.Color(40, 76, 40));

        labelPassword.setForeground(new java.awt.Color(255, 255, 255));
        labelPassword.setText("Password :");

        labelLogInScreen.setForeground(new java.awt.Color(255, 255, 255));
        labelLogInScreen.setText("LogIn Screen");

        textUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserNameActionPerformed(evt);
            }
        });

        labelUserName.setForeground(new java.awt.Color(255, 255, 255));
        labelUserName.setText("UserName :");

        buttonLogin.setText("LOGIN");
        buttonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLoginMouseClicked(evt);
            }
        });
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        bBack.setText("Back");
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(481, Short.MAX_VALUE)
                .addComponent(buttonLogin)
                .addGap(447, 447, 447))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(bBack)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(468, 468, 468)
                .addComponent(labelLogInScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(363, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelUserName)
                        .addComponent(labelPassword))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(passwordField))
                    .addGap(363, 363, 363)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(bBack)
                .addGap(228, 228, 228)
                .addComponent(labelLogInScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                .addComponent(buttonLogin)
                .addGap(254, 254, 254))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(393, 393, 393)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelUserName)
                        .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPassword)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(330, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1017, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1014, 1024));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUserNameActionPerformed

    private void buttonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseClicked
        /* TODO: 1. Close this JFrame
        2. Create and open a new JFrame
        3. Create appropriate JPanel and other UI/UX things.

         */
        try {

            String loginUsername = textUserName.getText();
            String loginPassword = String.valueOf(passwordField.getPassword());

            System.out.println("username : " + loginUsername);
            System.out.println("password : " + loginPassword);

            PreparedStatement p2p = sqliteConnection.prepareStatement(SEARCH_ADMIN_LOGIN);
            ResultSet output = p2p.executeQuery();
            while (output.next()) {
                String username = output.getString("username");
                String password = output.getString("password");

                if(loginUsername.equals("admin") && loginPassword.equals("admin")) {
                    this.dispose();
                    AdminJFrame adminFrame = new AdminJFrame();
                    adminFrame.setVisible(true);
                }
                else if (loginPassword.contains("Pharmacist")){
                    this.dispose();
                    Medicines med = new Medicines();
                    med.setVisible(true);
                }
                else if(loginPassword.contains("LabAssistant")) {
                    //lab will open
                    this.dispose();
                    Lab_Console labConsole = new Lab_Console();
                    labConsole.setVisible(true);
                }
                else if(loginPassword.contains("Pathologist")) {
                    //path
                    this.dispose();
                    BloodHome bloodBank = new BloodHome();
                    bloodBank.setVisible(true);
                }
                else if(loginPassword.contains("Receptionist")) {
                    //receptionist
                    this.dispose();
                    ReceptionistHomeJFrame reception = new ReceptionistHomeJFrame();
                    reception.setVisible(true);
                }
                else if(loginPassword.contains("Doctor")) {
                    this.dispose();
                    DoctorHomeJFrame doctor = new DoctorHomeJFrame();
                    doctor.setVisible(true);
                }
            }

            //System.out.println("listOfLoginCredentials Size(): " + listOfLoginCredentials.getAllLoginCredentials().size());
            //        for (LoginCredentials login : listOfLoginCredentials.getAllLoginCredentials()) {
            //            System.out.println("login.getusername() : " + login.getUserName());
            //            System.out.println("login.getpassword : " + login.getPassword());
            //            System.out.println("login.getName() : " + login.getName());
            //            System.out.println("login.getId : " + login.getId());
            //            System.out.println("login.getRoleOptions : " + login.getRoleOptions());
            //            if ((username.equals(login.getUserName())) && (password.equals(login.getPassword()))) {
            //                if (username.equals("admin")) {
            //                    dispose();
            //
            //                    adminFrame = AdminJFrame.GetInstance(listOfLoginCredentials);
            //                    //                    if(dirPatient !=null || dirPatient.getPatientDirectory().size() != 0 || !dirPatient.getPatientDirectory().isEmpty() ) {
            //                        //                        adminFrame.setPatientDirectory(dirPatient);
            //                        //                    }
            //                    adminFrame.setVisible(true);
            //
            //                } else {
            //                    if (username.contains("hospital")) {
            //
            //                        JOptionPane.showMessageDialoJOpg(this, "Hospital logged in");
            //                    }
            //                    if (username.contains("patient")) {
            //                        JOptionPane.showMessageDialog(this, "Patient logged in");
            //                        PatientJFrame patientFrame = new PatientJFrame(listOfLoginCredentials, adminFrame, login, registrationPatient, login.getName(), login.getRoleOptions());
            //                        patientFrame.setVisible(true);
            //                    }
            //
            //                    if (username.contains("community")) {
            //                        CommunityJFrame communityFrame = new CommunityJFrame(listOfLoginCredentials, adminFrame, login.getName(), login.getRoleOptions());
            //                        communityFrame.setVisible(true);
            //                    }
            //                    if(username.contains("doctor")) {
            //                        DoctorJFrame docFrame = new DoctorJFrame(listOfLoginCredentials, adminFrame, login);
            //                        docFrame.setVisible(true);
            //                    }
            //                }
            //            }
            //            else {
            //
//                            JOptionPane.showMessageDialog(this, "Wrong Username or Password");
            //            }
            //        }
            //        if (username.equals("admin") && password.equals("admin")) {
            //
            //            dispose();
            //
            //            adminFrame = AdminJFrame.GetInstance(listOfLoginCredentials);
            //            adminFrame.setVisible(true);
            //
            //        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonLoginMouseClicked

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        dispose();
        MainJFrame mainFrame = new MainJFrame();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainFrame.setVisible(true);
            }
        });
    }//GEN-LAST:event_bBackActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginJFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBack;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLogInScreen;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField textUserName;
    // End of variables declaration//GEN-END:variables
}

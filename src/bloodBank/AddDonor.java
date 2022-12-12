/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bloodBank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author ADMIN
 */
public class AddDonor extends javax.swing.JFrame {

    /**
     * Creates new form AddDonor
     */
    public AddDonor() {
        initComponents();
    }

    static Connection sqliteConnection;
    static Statement statement;
    static SQLiteDataSource ps = null;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDonId = new javax.swing.JLabel();
        lblDonFieldId = new javax.swing.JLabel();
        lblDonName = new javax.swing.JLabel();
        lblDonFatName = new javax.swing.JLabel();
        lblDonMotName = new javax.swing.JLabel();
        lblDonDob = new javax.swing.JLabel();
        lblDonMob = new javax.swing.JLabel();
        lblDonGend = new javax.swing.JLabel();
        txtFieldName = new javax.swing.JTextField();
        txtFieldFatName = new javax.swing.JTextField();
        txtFieldMotName = new javax.swing.JTextField();
        txtFieldDob = new com.toedter.calendar.JDateChooser();
        txtFieldGend = new javax.swing.JComboBox<>();
        txtFieldMob = new javax.swing.JTextField();
        lblDonEmail = new javax.swing.JLabel();
        lblBlood = new javax.swing.JLabel();
        lblDonCities = new javax.swing.JLabel();
        lblDonAddress = new javax.swing.JLabel();
        txtFieldEmail = new javax.swing.JTextField();
        txtFieldBlood = new javax.swing.JComboBox<>();
        txtFieldCity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFieldAddress = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        btnDonSave = new javax.swing.JButton();
        btnDonReset = new javax.swing.JButton();
        btnDonClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(340, 130));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Donor");
        jLabel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel1ComponentShown(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 15, 462, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 10));

        lblDonId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonId.setText("Donor ID:");
        getContentPane().add(lblDonId, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 89, 104, -1));

        lblDonFieldId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDonFieldId.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lblDonFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 85, 55, 20));

        lblDonName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonName.setText("Full Name:");
        getContentPane().add(lblDonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 131, 104, -1));

        lblDonFatName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonFatName.setText("Father Name:");
        getContentPane().add(lblDonFatName, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 173, 104, -1));

        lblDonMotName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonMotName.setText("Mother Name:");
        getContentPane().add(lblDonMotName, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 213, -1, -1));

        lblDonDob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonDob.setText("Date of Birth:");
        getContentPane().add(lblDonDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 251, -1, -1));

        lblDonMob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonMob.setText("Mobile No:");
        getContentPane().add(lblDonMob, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 294, -1, -1));

        lblDonGend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonGend.setText("Gender:");
        getContentPane().add(lblDonGend, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 335, 77, -1));

        txtFieldName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 128, 195, -1));

        txtFieldFatName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtFieldFatName, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 170, 195, -1));

        txtFieldMotName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtFieldMotName, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 210, 195, -1));
        getContentPane().add(txtFieldDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 251, 195, -1));

        txtFieldGend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFieldGend.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female", "Others" }));
        getContentPane().add(txtFieldGend, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 332, 195, -1));

        txtFieldMob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtFieldMob, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 291, 195, -1));

        lblDonEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonEmail.setText("Email:");
        getContentPane().add(lblDonEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 58, -1));

        lblBlood.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBlood.setText("Blood Group:");
        getContentPane().add(lblBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        lblDonCities.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonCities.setText("City:");
        getContentPane().add(lblDonCities, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 73, -1));

        lblDonAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDonAddress.setText("Address:");
        getContentPane().add(lblDonAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 70, -1));

        txtFieldEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 210, -1));

        txtFieldBlood.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFieldBlood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        getContentPane().add(txtFieldBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        txtFieldCity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtFieldCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 220, -1));

        txtFieldAddress.setColumns(20);
        txtFieldAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFieldAddress.setRows(5);
        jScrollPane1.setViewportView(txtFieldAddress);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 220, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 680, 10));

        btnDonSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDonSave.setText("Save");
        btnDonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnDonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        btnDonReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDonReset.setText("Reset");
        btnDonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnDonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        btnDonClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDonClose.setText("Close");
        btnDonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnDonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloodBank/all page background image.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNameActionPerformed

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEmailActionPerformed

    private void btnDonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonSaveActionPerformed
        
        try {
               
            ps = new SQLiteDataSource();
            
            ps.setUrl("jdbc:sqlite:hospManagement.db");
            sqliteConnection = ps.getConnection();
            String command = "insert into donor (DonId, DonName, DonFather, DonMother, DonDob, DonMobile, DonGend, DonEmail, DonBlood, DonAddress, DonCity ) values (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement p2p = sqliteConnection.prepareStatement(command);
            
            p2p.setString(1, lblDonFieldId.getText());
            p2p.setString(2, txtFieldName.getText());
            p2p.setString(3, txtFieldFatName.getText());
            p2p.setString(4, txtFieldMotName.getText());
            p2p.setString(5,  ((JTextField)txtFieldDob.getDateEditor().getUiComponent()).getText());
            p2p.setInt(6, Integer.valueOf(txtFieldMob.getText()));
            p2p.setString(7, txtFieldGend.getSelectedItem().toString());
            p2p.setString(8, txtFieldEmail.getText());
            p2p.setString(9, txtFieldBlood.getSelectedItem().toString());
            p2p.setString(10, txtFieldCity.getText());
            p2p.setString(11, txtFieldAddress.getText());
            
            
            boolean output = p2p.execute();
            JOptionPane.showMessageDialog(this, "Donor Successfully Added!");
            sqliteConnection.close();
            
         } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDonSaveActionPerformed

    private void btnDonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnDonCloseActionPerformed

    private void btnDonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonResetActionPerformed
        setVisible(false);
        new AddDonor().setVisible(true);
    }//GEN-LAST:event_btnDonResetActionPerformed

    private void jLabel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       try {
            
           ps = new SQLiteDataSource();
            
           ps.setUrl("jdbc:sqlite:hospManagement.db");
           sqliteConnection = ps.getConnection();
        
           String command = "Select max(DonId) from donor";
           Statement p2p = sqliteConnection.createStatement();
           ResultSet rs = p2p.executeQuery(command);
           
           if(rs.next())
           {
               int id = rs.getInt(1);
               id = id+1;
               String str = String.valueOf(id);
               lblDonFieldId.setText(str);
               
           }
           else 
           {
           
               lblDonFieldId.setText("1");
           }
           
           sqliteConnection.close();

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(AddDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDonor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonClose;
    private javax.swing.JButton btnDonReset;
    private javax.swing.JButton btnDonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBlood;
    private javax.swing.JLabel lblDonAddress;
    private javax.swing.JLabel lblDonCities;
    private javax.swing.JLabel lblDonDob;
    private javax.swing.JLabel lblDonEmail;
    private javax.swing.JLabel lblDonFatName;
    private javax.swing.JLabel lblDonFieldId;
    private javax.swing.JLabel lblDonGend;
    private javax.swing.JLabel lblDonId;
    private javax.swing.JLabel lblDonMob;
    private javax.swing.JLabel lblDonMotName;
    private javax.swing.JLabel lblDonName;
    private javax.swing.JTextArea txtFieldAddress;
    private javax.swing.JComboBox<String> txtFieldBlood;
    private javax.swing.JTextField txtFieldCity;
    private com.toedter.calendar.JDateChooser txtFieldDob;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldFatName;
    private javax.swing.JComboBox<String> txtFieldGend;
    private javax.swing.JTextField txtFieldMob;
    private javax.swing.JTextField txtFieldMotName;
    private javax.swing.JTextField txtFieldName;
    // End of variables declaration//GEN-END:variables
}

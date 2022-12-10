/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pharmacy;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.sqlite.SQLiteDataSource;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static pharmacy.Medicines.ps;
import static pharmacy.Medicines.sqliteConnection;

/**
 *
 * @author ADMIN
 */
public class Company extends javax.swing.JFrame {

    /**
     * Creates new form Company
     */
    public Company() {
        initComponents();
        GetAllCompanies();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pharmacyLeftJPanel = new javax.swing.JPanel();
        companyJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCompId = new javax.swing.JLabel();
        lblCompName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblExperience = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtFieldCompanyAddress = new javax.swing.JTextField();
        txtFieldCompanyId = new javax.swing.JTextField();
        textFieldCompanyName = new javax.swing.JTextField();
        txtFieldExp = new javax.swing.JTextField();
        btnAddCompany = new javax.swing.JButton();
        btnUpdateCompany = new javax.swing.JButton();
        btnDeleteCompany = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CompanyJTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        textFieldCompanyPhone = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        lblAgents = new javax.swing.JLabel();
        lblMedicines = new javax.swing.JLabel();
        lblSelling = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pharmacyLeftJPanel.setBackground(new java.awt.Color(0, 153, 0));

        companyJPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGE COMPANY");

        lblCompId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCompId.setForeground(new java.awt.Color(0, 153, 0));
        lblCompId.setText("ID");

        lblCompName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCompName.setForeground(new java.awt.Color(0, 153, 0));
        lblCompName.setText("NAME");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(0, 153, 0));
        lblAddress.setText("ADDRESS");

        lblExperience.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExperience.setForeground(new java.awt.Color(0, 153, 0));
        lblExperience.setText("EXPERIENCE");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(0, 153, 0));
        lblPhone.setText("PHONE");

        txtFieldCompanyAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFieldCompanyAddress.setForeground(new java.awt.Color(0, 153, 0));

        txtFieldCompanyId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFieldCompanyId.setForeground(new java.awt.Color(0, 153, 0));

        textFieldCompanyName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textFieldCompanyName.setForeground(new java.awt.Color(0, 153, 0));

        txtFieldExp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFieldExp.setForeground(new java.awt.Color(0, 153, 0));

        btnAddCompany.setBackground(new java.awt.Color(51, 204, 0));
        btnAddCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddCompany.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCompany.setText("ADD");
        btnAddCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCompanyMouseClicked(evt);
            }
        });

        btnUpdateCompany.setBackground(new java.awt.Color(51, 204, 0));
        btnUpdateCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdateCompany.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCompany.setText("UPDATE");
        btnUpdateCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateCompanyMouseClicked(evt);
            }
        });

        btnDeleteCompany.setBackground(new java.awt.Color(51, 204, 0));
        btnDeleteCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDeleteCompany.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCompany.setText("DELETE");
        btnDeleteCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteCompanyMouseClicked(evt);
            }
        });

        CompanyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "COMPANY", "ADDRESS", "EXPERIENCE", "PHONE"
            }
        ));
        CompanyJTable.setRowHeight(25);
        CompanyJTable.setSelectionBackground(new java.awt.Color(0, 153, 0));
        CompanyJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CompanyJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CompanyJTable);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 153, 0));
        jLabel12.setText("COMPANIES LIST");

        textFieldCompanyPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textFieldCompanyPhone.setForeground(new java.awt.Color(0, 153, 0));

        btnClear.setBackground(new java.awt.Color(51, 204, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout companyJPanelLayout = new javax.swing.GroupLayout(companyJPanel);
        companyJPanel.setLayout(companyJPanelLayout);
        companyJPanelLayout.setHorizontalGroup(
            companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyJPanelLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(companyJPanelLayout.createSequentialGroup()
                .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(companyJPanelLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnAddCompany)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateCompany)
                        .addGap(27, 27, 27)
                        .addComponent(btnDeleteCompany)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear))
                    .addGroup(companyJPanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(companyJPanelLayout.createSequentialGroup()
                                .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCompName)
                                    .addComponent(lblCompId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldCompanyName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFieldCompanyId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(companyJPanelLayout.createSequentialGroup()
                                .addComponent(lblAddress)
                                .addGap(18, 18, 18)
                                .addComponent(txtFieldCompanyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(96, 96, 96)
                        .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhone)
                            .addComponent(lblExperience))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldExp, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(366, 366, 366))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyJPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        companyJPanelLayout.setVerticalGroup(
            companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldCompanyId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompId)
                    .addComponent(lblPhone)
                    .addComponent(textFieldCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompName)
                    .addComponent(textFieldCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExperience)
                    .addComponent(txtFieldExp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldCompanyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addGap(70, 70, 70)
                .addGroup(companyJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblAgents.setBackground(new java.awt.Color(255, 255, 255));
        lblAgents.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAgents.setForeground(new java.awt.Color(255, 255, 255));
        lblAgents.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAgents.setText("AGENTS");
        lblAgents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgentsMouseClicked(evt);
            }
        });

        lblMedicines.setBackground(new java.awt.Color(255, 255, 255));
        lblMedicines.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMedicines.setForeground(new java.awt.Color(255, 255, 255));
        lblMedicines.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMedicines.setText("MEDICINES");
        lblMedicines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMedicinesMouseClicked(evt);
            }
        });

        lblSelling.setBackground(new java.awt.Color(255, 255, 255));
        lblSelling.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelling.setForeground(new java.awt.Color(255, 255, 255));
        lblSelling.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSelling.setText("SELLING");
        lblSelling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSellingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pharmacyLeftJPanelLayout = new javax.swing.GroupLayout(pharmacyLeftJPanel);
        pharmacyLeftJPanel.setLayout(pharmacyLeftJPanelLayout);
        pharmacyLeftJPanelLayout.setHorizontalGroup(
            pharmacyLeftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pharmacyLeftJPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pharmacyLeftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelling)
                    .addComponent(lblMedicines)
                    .addComponent(lblAgents))
                .addGap(12, 12, 12)
                .addComponent(companyJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pharmacyLeftJPanelLayout.setVerticalGroup(
            pharmacyLeftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pharmacyLeftJPanelLayout.createSequentialGroup()
                .addGroup(pharmacyLeftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pharmacyLeftJPanelLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(lblAgents, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblMedicines, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSelling, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pharmacyLeftJPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(companyJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pharmacyLeftJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pharmacyLeftJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCompanyMouseClicked

        try {
            ps = new SQLiteDataSource();
            
            ps.setUrl("jdbc:sqlite:hospManagement.db");
            sqliteConnection = ps.getConnection();
            String commandCompany = "insert into company (CompId, CompName, CompAddress, CompPhone, CompExp ) values (?,?,?,?,?)";

            PreparedStatement p2p = sqliteConnection.prepareStatement(commandCompany);

            p2p.setInt(1, Integer.valueOf(txtFieldCompanyId.getText()));
            p2p.setString(2, textFieldCompanyName.getText());
            p2p.setString(3, txtFieldCompanyAddress.getText());
            p2p.setInt(4, Integer.valueOf(txtFieldExp.getText()));
            p2p.setString(5, textFieldCompanyPhone.getText());

            boolean output = p2p.execute();
            JOptionPane.showMessageDialog(this, "Company Successfully Added!");
            sqliteConnection.close();
            GetAllCompanies();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddCompanyMouseClicked

    private void btnUpdateCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateCompanyMouseClicked
        if (txtFieldCompanyId.getText().isEmpty() || textFieldCompanyName.getText().isEmpty() || txtFieldCompanyAddress.getText().isEmpty() || txtFieldExp.getText().isEmpty() || textFieldCompanyPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information about Company");
        }
        else
        {
            try {
                ps = new SQLiteDataSource();
            
                ps.setUrl("jdbc:sqlite:hospManagement.db");
                sqliteConnection = ps.getConnection();
                String id = txtFieldCompanyId.getText();
                
                String queryUpdate = "update company set CompName = '" + textFieldCompanyName.getText() + "'" + ",CompAddress = '" + txtFieldCompanyAddress.getText() + "'" + ",CompPhone = " + textFieldCompanyPhone.getText() + "" + ",CompExp = '" + txtFieldExp.getText() + "'" + "where CompId = " + id;

                PreparedStatement p2p = sqliteConnection.prepareStatement(queryUpdate);
                boolean output = p2p.execute();
                
                GetAllCompanies();
                JOptionPane.showMessageDialog(this, "Company Successfully Updated!");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateCompanyMouseClicked

    private void btnDeleteCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteCompanyMouseClicked
        if (txtFieldCompanyId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter ID of The Company To Be Deleted....");
        }
        else
        {
            try {
                ps = new SQLiteDataSource();
            
                ps.setUrl("jdbc:sqlite:hospManagement.db");
                sqliteConnection = ps.getConnection();
                String id = txtFieldCompanyId.getText();
                String query = "Delete from company where CompId = " + id;
                
                PreparedStatement p2p = sqliteConnection.prepareStatement(query);
                boolean output = p2p.execute();
                
                GetAllCompanies();
                JOptionPane.showMessageDialog(this, "Company Successfully Deleted!");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteCompanyMouseClicked

    private void CompanyJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompanyJTableMouseClicked

        DefaultTableModel model = (DefaultTableModel)CompanyJTable.getModel();
        int myIndex = CompanyJTable.getSelectedRow();
        txtFieldCompanyId.setText(model.getValueAt(myIndex, 0).toString());
        textFieldCompanyName.setText(model.getValueAt(myIndex, 1).toString());
        txtFieldCompanyAddress.setText(model.getValueAt(myIndex, 2).toString());
        txtFieldExp.setText(model.getValueAt(myIndex, 3).toString());
        textFieldCompanyPhone.setText(model.getValueAt(myIndex, 4).toString());

    }//GEN-LAST:event_CompanyJTableMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked

        txtFieldCompanyId.setText("");
        textFieldCompanyName.setText("");
        txtFieldCompanyAddress.setText("");
        txtFieldExp.setText("");
        textFieldCompanyPhone.setText("");
    }//GEN-LAST:event_btnClearMouseClicked

    private void lblAgentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgentsMouseClicked
        new Agents().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAgentsMouseClicked

    private void lblMedicinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMedicinesMouseClicked
        new Medicines().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMedicinesMouseClicked

    private void lblSellingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSellingMouseClicked
        new Selling().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblSellingMouseClicked

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
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Company().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CompanyJTable;
    private javax.swing.JButton btnAddCompany;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteCompany;
    private javax.swing.JButton btnUpdateCompany;
    private javax.swing.JPanel companyJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAgents;
    private javax.swing.JLabel lblCompId;
    private javax.swing.JLabel lblCompName;
    private javax.swing.JLabel lblExperience;
    private javax.swing.JLabel lblMedicines;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSelling;
    private javax.swing.JPanel pharmacyLeftJPanel;
    private javax.swing.JTextField textFieldCompanyName;
    private javax.swing.JTextField textFieldCompanyPhone;
    private javax.swing.JTextField txtFieldCompanyAddress;
    private javax.swing.JTextField txtFieldCompanyId;
    private javax.swing.JTextField txtFieldExp;
    // End of variables declaration//GEN-END:variables

    private void GetAllCompanies() {
         try {
           ps = new SQLiteDataSource();
            
           ps.setUrl("jdbc:sqlite:hospManagement.db");
           sqliteConnection = ps.getConnection();
        
           String command = "Select * from company";
           Statement p2p = sqliteConnection.createStatement();
           ResultSet rs = p2p.executeQuery(command);
           CompanyJTable.setModel(DbUtils.resultSetToTableModel(rs));
    
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}

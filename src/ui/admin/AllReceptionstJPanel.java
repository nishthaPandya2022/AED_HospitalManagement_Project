/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package ui.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Doctor;
import model.DoctorDirectory;
import model.Receptionist;
import model.ReceptionistDirectory;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author nishthapandya
 */
public class AllReceptionstJPanel extends javax.swing.JPanel {
    
    private ReceptionistDirectory receptionistDirectory;
    private ArrayList<Receptionist> recpDirectory;
    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;
    
    String GET_ALL_RECEPTIONIST_FROM_HOSPITAL = "SELECT userID, name, DOB, age, organization, phoneNumber, address, community, state, zipcode, role from hospital WHERE role=\"Receptionist\"";

    /** Creates new form AllReceptionstJPanel */
    public AllReceptionstJPanel(SQLiteDataSource dataSource, Connection connection) {
        initComponents();
        this.ds = dataSource;
        this.sqliteConnection = connection;
        this.receptionistDirectory = new ReceptionistDirectory();
        recpDirectory = new ArrayList<Receptionist>();
        
        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_ALL_RECEPTIONIST_FROM_HOSPITAL);
            ResultSet output = p2p.executeQuery();
            while(output.next()){
                Receptionist recp = new Receptionist();
                recp.setReceptionistID(Integer.parseInt(output.getString("userID")));
                recp.setReceptionistName(output.getString("name"));
//                Date date = output.getDate("DOB");
                System.out.println("dob : " + output.getString("DOB"));
                recp.setReceptionistDOB(java.sql.Date.valueOf(output.getString("DOB")));
                recp.setReceptionistAge(output.getString("age"));
                recp.setReceptionistPhoneNumber(output.getString("phoneNumber"));
                recp.setReceptionistAddress(output.getString("address"));
                recp.setReceptionistCommunity(output.getString("community"));
                recp.setReceptionistState(output.getString("state"));
                recp.setReceptionistZipCode(output.getString("zipcode"));
                
                recpDirectory.add(recp);
            }
            
            this.receptionistDirectory.setListOfReceptionist(recpDirectory);
            
            populateReceptionistTable();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean validatedata() {

        if ("".equals(etReceptionistID.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Id.");
            return false;
        }
        if (!etReceptionistID.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Id.");
            return false;
        }
        if ("".equals(etReceptionistName.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Name.");
            return false;
        }
        if (!etReceptionistName.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Name.");
            return false;
        }
        if ("".equals(etReceptionistAddress.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Address.");
            return false;
        }
        if (!etReceptionistAddress.getText().matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper Address.");
            return false;
        }
        if ("".equals(etReceptionistCommunity.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Community.");
            return false;
        }
        if (!etReceptionistCommunity.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper community.");
            return false;
        }
        if ("".equals(etReceptionistZipCode.getText())) {
            JOptionPane.showMessageDialog(this, "Enter zipcode.");
            return false;
        }
        if (!etReceptionistZipCode.getText().matches("[0-9]{5}(?:-[0-9]{4})?$")) {
            JOptionPane.showMessageDialog(this, "Enter zipcode in the form of xxxxx or xxxxx-xxxx.");
            return false;
        }
        if ("".equals(etReceptionistCity.getText())) {
            JOptionPane.showMessageDialog(this, "Enter City.");
            return false;
        }
        if (!etReceptionistCity.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper city.");
            return false;
        }
        if ("".equals(etReceptionistState.getText())) {
            JOptionPane.showMessageDialog(this, "Enter State.");
            return false;
        }
        if (!etReceptionistState.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper state.");
            return false;
        }
        if (!etReceptionistPhoneNumber.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper phone number of 10 digits.");
            return false;
        }
        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etReceptionistCommunity = new javax.swing.JTextField();
        txtFieldReceptionistAge = new javax.swing.JTextField();
        lblReceptionistDetails = new javax.swing.JLabel();
        bViewReceptionist = new javax.swing.JButton();
        lblDoctorCommunity = new javax.swing.JLabel();
        lblDocDOB = new javax.swing.JLabel();
        etReceptionistAddress = new javax.swing.JTextField();
        lblDocAge = new javax.swing.JLabel();
        lblDoctorName = new javax.swing.JLabel();
        lblDoctorZipCode = new javax.swing.JLabel();
        lblDoctorPhoneNumber = new javax.swing.JLabel();
        bUpdateReceptionist = new javax.swing.JButton();
        etReceptionistZipCode = new javax.swing.JTextField();
        dateChooserReceptionistDOB = new com.toedter.calendar.JDateChooser();
        bDeleteReceptionist = new javax.swing.JButton();
        lblDoctorAddress = new javax.swing.JLabel();
        etReceptionistCity = new javax.swing.JTextField();
        etReceptionistName = new javax.swing.JTextField();
        lblDoctorState = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllReceptionist = new javax.swing.JTable();
        etReceptionistState = new javax.swing.JTextField();
        etReceptionistID = new javax.swing.JTextField();
        etReceptionistPhoneNumber = new javax.swing.JTextField();
        lblDoctorCity = new javax.swing.JLabel();

        lblReceptionistDetails.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblReceptionistDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReceptionistDetails.setText("All Receptionist Details");

        bViewReceptionist.setText("View");
        bViewReceptionist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewReceptionistActionPerformed(evt);
            }
        });

        lblDoctorCommunity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCommunity.setText("Community :");

        lblDocDOB.setText("DOB :");

        etReceptionistAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etReceptionistAddressActionPerformed(evt);
            }
        });

        lblDocAge.setText("Age :");

        lblDoctorName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorName.setText("Name :");

        lblDoctorZipCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorZipCode.setText("Zip Code :");

        lblDoctorPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorPhoneNumber.setText("Phone Number :");

        bUpdateReceptionist.setText("Update");
        bUpdateReceptionist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateReceptionistActionPerformed(evt);
            }
        });

        bDeleteReceptionist.setText("Delete");
        bDeleteReceptionist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteReceptionistActionPerformed(evt);
            }
        });

        lblDoctorAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorAddress.setText("Address :");

        lblDoctorState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorState.setText("State :");

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID :");

        tableAllReceptionist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAllReceptionist);

        lblDoctorCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCity.setText("City :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(lblReceptionistDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(bViewReceptionist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(bUpdateReceptionist)
                        .addGap(115, 115, 115)
                        .addComponent(bDeleteReceptionist)
                        .addGap(103, 103, 103)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDocAge)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDoctorPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addComponent(lblDoctorName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblDocDOB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etReceptionistID, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(etReceptionistName)
                    .addComponent(etReceptionistPhoneNumber)
                    .addComponent(txtFieldReceptionistAge)
                    .addComponent(dateChooserReceptionistDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDoctorAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDoctorCommunity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDoctorCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDoctorState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDoctorZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(etReceptionistAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etReceptionistCommunity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etReceptionistCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etReceptionistState, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etReceptionistZipCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblReceptionistDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bViewReceptionist)
                    .addComponent(bUpdateReceptionist)
                    .addComponent(bDeleteReceptionist))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(etReceptionistID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoctorAddress)
                    .addComponent(etReceptionistAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorName)
                    .addComponent(lblDoctorCommunity)
                    .addComponent(etReceptionistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etReceptionistCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorCity)
                    .addComponent(etReceptionistPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoctorPhoneNumber)
                    .addComponent(etReceptionistCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDoctorState)
                        .addComponent(etReceptionistState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDocDOB))
                    .addComponent(dateChooserReceptionistDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorZipCode)
                    .addComponent(etReceptionistZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDocAge)
                    .addComponent(txtFieldReceptionistAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bViewReceptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewReceptionistActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableAllReceptionist.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllReceptionist.getModel();
        Receptionist recp = (Receptionist) model.getValueAt(selectedRow, 0);

        etReceptionistID.setText(String.valueOf(recp.getReceptionistID()));
        etReceptionistName.setText(recp.getReceptionistName());
        etReceptionistCity.setText(recp.getReceptionistCity());
        dateChooserReceptionistDOB.setDate(recp.getReceptionistDOB());
        txtFieldReceptionistAge.setText(recp.getReceptionistAge());
        etReceptionistCommunity.setText(recp.getReceptionistCommunity());
        etReceptionistZipCode.setText(recp.getReceptionistZipCode());
        etReceptionistState.setText(recp.getReceptionistState());
        etReceptionistAddress.setText(recp.getReceptionistAddress());
        etReceptionistPhoneNumber.setText(recp.getReceptionistPhoneNumber());
    }//GEN-LAST:event_bViewReceptionistActionPerformed

    private void etReceptionistAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etReceptionistAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etReceptionistAddressActionPerformed

    private void bUpdateReceptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateReceptionistActionPerformed
        // TODO add your handling code here:

        if (validatedata()) {

            LocalDate localDOB = LocalDate.parse(((JTextField) dateChooserReceptionistDOB.getDateEditor().getUiComponent()).getText());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            int editDoctorID = Integer.parseInt(etReceptionistID.getText());
            String editDoctorName = etReceptionistName.getText();
            Date editDoctorDOB = java.sql.Date.valueOf(localDOB);
            String editDoctorAge = txtFieldReceptionistAge.getText();
            String editDoctorPhoneNumber = etReceptionistPhoneNumber.getText();
            String editDoctorAddress = etReceptionistAddress.getText();
            String editDoctorCommunity = etReceptionistCommunity.getText();
            String editDoctorCity = etReceptionistCity.getText();
            String editDoctorState = etReceptionistState.getText();
            String editDoctorZipCode = etReceptionistZipCode.getText();

            for (Receptionist doc : receptionistDirectory.getListOfReceptionist()) {

                int id = doc.getReceptionistID();
                if (editDoctorID == id) {
                    doc.setReceptionistID(editDoctorID);
                    doc.setReceptionistDOB(editDoctorDOB);
                    doc.setReceptionistAge(editDoctorAge);
                    doc.setReceptionistName(editDoctorName);
                    doc.setReceptionistAddress(editDoctorAddress);
                    doc.setReceptionistCommunity(editDoctorCommunity);
                    doc.setReceptionistCity(editDoctorCity);
                    doc.setReceptionistState(editDoctorState);
                    doc.setReceptionistZipCode(editDoctorZipCode);
                    doc.setReceptionistPhoneNumber(editDoctorPhoneNumber);

                    JOptionPane.showMessageDialog(this, "Updated Doctor Details!");

                    populateReceptionistTable();

                    etReceptionistID.setText("");
                    etReceptionistName.setText("");
                    txtFieldReceptionistAge.setText("");
                    etReceptionistPhoneNumber.setText("");
                    etReceptionistAddress.setText("");
                    etReceptionistCommunity.setText("");
                    etReceptionistCity.setText("");
                    etReceptionistState.setText("");
                    etReceptionistZipCode.setText("");

                }

            }
        }
    }//GEN-LAST:event_bUpdateReceptionistActionPerformed

    private void bDeleteReceptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteReceptionistActionPerformed
        // TODO add your handling code here:

        int selectedRow = tableAllReceptionist.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllReceptionist.getModel();
        Receptionist doc = (Receptionist) model.getValueAt(selectedRow, 0);

        receptionistDirectory.deleteReceptionist(doc);

        populateReceptionistTable();

        etReceptionistID.setText("");
        txtFieldReceptionistAge.setText("");
        etReceptionistName.setText("");
        etReceptionistPhoneNumber.setText("");
        etReceptionistAddress.setText("");
        etReceptionistCommunity.setText("");
        etReceptionistCity.setText("");
        etReceptionistState.setText("");
        etReceptionistZipCode.setText("");
    }//GEN-LAST:event_bDeleteReceptionistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeleteReceptionist;
    private javax.swing.JButton bUpdateReceptionist;
    private javax.swing.JButton bViewReceptionist;
    private com.toedter.calendar.JDateChooser dateChooserReceptionistDOB;
    private javax.swing.JTextField etReceptionistAddress;
    private javax.swing.JTextField etReceptionistCity;
    private javax.swing.JTextField etReceptionistCommunity;
    private javax.swing.JTextField etReceptionistID;
    private javax.swing.JTextField etReceptionistName;
    private javax.swing.JTextField etReceptionistPhoneNumber;
    private javax.swing.JTextField etReceptionistState;
    private javax.swing.JTextField etReceptionistZipCode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDocAge;
    private javax.swing.JLabel lblDocDOB;
    private javax.swing.JLabel lblDoctorAddress;
    private javax.swing.JLabel lblDoctorCity;
    private javax.swing.JLabel lblDoctorCommunity;
    private javax.swing.JLabel lblDoctorName;
    private javax.swing.JLabel lblDoctorPhoneNumber;
    private javax.swing.JLabel lblDoctorState;
    private javax.swing.JLabel lblDoctorZipCode;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblReceptionistDetails;
    private javax.swing.JTable tableAllReceptionist;
    private javax.swing.JTextField txtFieldReceptionistAge;
    // End of variables declaration//GEN-END:variables

    public void populateReceptionistTable() {

        DefaultTableModel model = (DefaultTableModel) tableAllReceptionist.getModel();
        model.setRowCount(0);

        for (Receptionist doc : receptionistDirectory.getListOfReceptionist()) {
            Object[] row = new Object[3];

            row[0] = doc;
            row[1] = doc.getReceptionistName();
            row[2] = doc.getReceptionistAge();

            model.addRow(row);
        }
    }
}

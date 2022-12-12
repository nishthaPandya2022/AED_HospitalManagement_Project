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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.InternDoctor;
import java.util.Date;
import model.Doctor;
import model.DoctorDirectory;
import model.InternDoctorDirectory;
import org.sqlite.SQLiteDataSource;
import static ui.admin.AllDoctorsJPanel.sqliteConnection;

/**
 *
 * @author nishthapandya
 */
public class AllInternDoctorsJPanel extends javax.swing.JPanel {
    
    private InternDoctorDirectory internDoctorDirectory;
    private ArrayList<InternDoctor> internDocDirectory;
    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;

    String GET_ALL_INTERN_DOCTORS_FROM_HOSPITAL = "SELECT userID, name, DOB, age, organization, phoneNumber, address, community, state, zipcode, role from hospital WHERE role=\"Intern Doctor\"";

    /**
     * Creates new form AllInternDoctorsJPanel
     */
    public AllInternDoctorsJPanel(SQLiteDataSource dataSource, Connection connection) {
        initComponents();
        
        this.ds = dataSource;
        this.sqliteConnection = connection;
        this.internDoctorDirectory = new InternDoctorDirectory();
        internDocDirectory = new ArrayList<InternDoctor>();

        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_ALL_INTERN_DOCTORS_FROM_HOSPITAL);
            ResultSet output = p2p.executeQuery();
            while (output.next()) {
                InternDoctor doc = new InternDoctor();
                doc.setDoctorID(Integer.parseInt(output.getString("userID")));
                doc.setDoctorName(output.getString("name"));
//                Date date = output.getDate("DOB");
                System.out.println("dob : " + output.getString("DOB"));
                doc.setDoctorDOB(java.sql.Date.valueOf(output.getString("DOB")));
                doc.setDoctorAge(output.getString("age"));
                doc.setDoctorPhoneNumber(output.getString("phoneNumber"));
                doc.setDoctorAddress(output.getString("address"));
                doc.setDoctorCommunity(output.getString("community"));
                doc.setDoctorState(output.getString("state"));
                doc.setDoctorZipCode(output.getString("zipcode"));

                internDocDirectory.add(doc);
            }

            this.internDoctorDirectory.setListOfInternDoctors(internDocDirectory);

            populateInternDoctorTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validatedata() {

        if ("".equals(etInternDoctorID.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Id.");
            return false;
        }
        if (!etInternDoctorID.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Id.");
            return false;
        }
        if ("".equals(etInternDoctorName.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Name.");
            return false;
        }
        if (!etInternDoctorName.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Name.");
            return false;
        }
        if ("".equals(etInternDoctorAddress.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Address.");
            return false;
        }
        if (!etInternDoctorAddress.getText().matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper Address.");
            return false;
        }
        if ("".equals(etInternDoctorCommunity.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Community.");
            return false;
        }
        if (!etInternDoctorCommunity.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper community.");
            return false;
        }
        if ("".equals(etInternDoctorZipCode.getText())) {
            JOptionPane.showMessageDialog(this, "Enter zipcode.");
            return false;
        }
        if (!etInternDoctorZipCode.getText().matches("[0-9]{5}(?:-[0-9]{4})?$")) {
            JOptionPane.showMessageDialog(this, "Enter zipcode in the form of xxxxx or xxxxx-xxxx.");
            return false;
        }
        if ("".equals(etInternDoctorCity.getText())) {
            JOptionPane.showMessageDialog(this, "Enter City.");
            return false;
        }
        if (!etInternDoctorCity.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper city.");
            return false;
        }
        if ("".equals(etInternDoctorState.getText())) {
            JOptionPane.showMessageDialog(this, "Enter State.");
            return false;
        }
        if (!etInternDoctorState.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper state.");
            return false;
        }
        if (!etInternDoctorPhoneNumber.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper phone number of 10 digits.");
            return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDoctorCommunity = new javax.swing.JLabel();
        bViewInternDoctor = new javax.swing.JButton();
        etInternDoctorZipCode = new javax.swing.JTextField();
        etInternDoctorName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllInternDoctor = new javax.swing.JTable();
        lblDoctorCity = new javax.swing.JLabel();
        etInternDoctorCity = new javax.swing.JTextField();
        lblDoctorPhoneNumber = new javax.swing.JLabel();
        etInternDoctorState = new javax.swing.JTextField();
        lblDocAge = new javax.swing.JLabel();
        lblInternDoctorsDetails = new javax.swing.JLabel();
        etInternDoctorCommunity = new javax.swing.JTextField();
        etInternDoctorID = new javax.swing.JTextField();
        lblDocDOB = new javax.swing.JLabel();
        lblDoctorZipCode = new javax.swing.JLabel();
        etInternDoctorAddress = new javax.swing.JTextField();
        lblDoctorState = new javax.swing.JLabel();
        txtFieldInternDocAge = new javax.swing.JTextField();
        bUpdateInternDoctor = new javax.swing.JButton();
        dateChooserInternDocDOB = new com.toedter.calendar.JDateChooser();
        lblID = new javax.swing.JLabel();
        bDeleteInternDoctor = new javax.swing.JButton();
        lblDoctorAddress = new javax.swing.JLabel();
        lblDoctorName = new javax.swing.JLabel();
        etInternDoctorPhoneNumber = new javax.swing.JTextField();

        lblDoctorCommunity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCommunity.setText("Community :");

        bViewInternDoctor.setText("View");
        bViewInternDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewInternDoctorActionPerformed(evt);
            }
        });

        tableAllInternDoctor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableAllInternDoctor);

        lblDoctorCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCity.setText("City :");

        lblDoctorPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorPhoneNumber.setText("Phone Number :");

        lblDocAge.setText("Age :");

        lblInternDoctorsDetails.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblInternDoctorsDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInternDoctorsDetails.setText("All Intern Doctor Details");

        lblDocDOB.setText("DOB :");

        lblDoctorZipCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorZipCode.setText("Zip Code :");

        etInternDoctorAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etInternDoctorAddressActionPerformed(evt);
            }
        });

        lblDoctorState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorState.setText("State :");

        bUpdateInternDoctor.setText("Update");
        bUpdateInternDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateInternDoctorActionPerformed(evt);
            }
        });

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID :");

        bDeleteInternDoctor.setText("Delete");
        bDeleteInternDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteInternDoctorActionPerformed(evt);
            }
        });

        lblDoctorAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorAddress.setText("Address :");

        lblDoctorName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorName.setText("Name :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDocAge)
                    .addComponent(lblDocDOB))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFieldInternDocAge, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserInternDocDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(lblDoctorState, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblInternDoctorsDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(bViewInternDoctor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                            .addComponent(bUpdateInternDoctor)
                            .addGap(115, 115, 115)
                            .addComponent(bDeleteInternDoctor)
                            .addGap(103, 103, 103))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblDoctorPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addComponent(lblDoctorName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(etInternDoctorID, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addComponent(etInternDoctorName)
                                .addComponent(etInternDoctorPhoneNumber))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblDoctorAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDoctorCommunity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDoctorCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDoctorZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(etInternDoctorAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(etInternDoctorCommunity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etInternDoctorCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etInternDoctorState, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etInternDoctorZipCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDocDOB)
                        .addComponent(lblDoctorState))
                    .addComponent(dateChooserInternDocDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocAge)
                    .addComponent(txtFieldInternDocAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblInternDoctorsDetails)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bViewInternDoctor)
                        .addComponent(bUpdateInternDoctor)
                        .addComponent(bDeleteInternDoctor))
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblID)
                        .addComponent(etInternDoctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDoctorAddress)
                        .addComponent(etInternDoctorAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDoctorName)
                        .addComponent(lblDoctorCommunity)
                        .addComponent(etInternDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etInternDoctorCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDoctorCity)
                        .addComponent(etInternDoctorPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDoctorPhoneNumber)
                        .addComponent(etInternDoctorCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(etInternDoctorState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDoctorZipCode)
                        .addComponent(etInternDoctorZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(130, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bViewInternDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewInternDoctorActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableAllInternDoctor.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllInternDoctor.getModel();
        InternDoctor doc = (InternDoctor) model.getValueAt(selectedRow, 0);

        etInternDoctorID.setText(String.valueOf(doc.getDoctorID()));
        etInternDoctorName.setText(doc.getDoctorName());
        etInternDoctorCity.setText(doc.getDoctorCity());
        dateChooserInternDocDOB.setDate(doc.getDoctorDOB());
        txtFieldInternDocAge.setText(doc.getDoctorAge());
        etInternDoctorCommunity.setText(doc.getDoctorCommunity());
        etInternDoctorZipCode.setText(doc.getDoctorZipCode());
        etInternDoctorState.setText(doc.getDoctorState());
        etInternDoctorAddress.setText(doc.getDoctorAddress());
        etInternDoctorPhoneNumber.setText(doc.getDoctorPhoneNumber());
        //        etHospitalName.setText(doc.getHospitalName());
    }//GEN-LAST:event_bViewInternDoctorActionPerformed

    private void etInternDoctorAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etInternDoctorAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etInternDoctorAddressActionPerformed

    private void bUpdateInternDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateInternDoctorActionPerformed
        // TODO add your handling code here:

        if (validatedata()) {
            
            etInternDoctorID.setEditable(false);

//            + "userID VARCHAR(200) NOT NULL," + "name VARCHAR(200) NOT NULL,"
//            + "DOB VARCHAR(200) NOT NULL," + "age VARCHAR(200) NOT NULL,"
//            + "organization VARCHAR(200) NOT NULL," + "phoneNumber VARCHAR(200) NOT NULL,"
//            + "address VARCHAR(200) NOT NULL," + "community VARCHAR(200) NOT NULL,"
//            + "state VARCHAR(200) NOT NULL," + "zipcode VARCHAR(200) NOT NULL,"
//            + "role VARCHAR(200) NOT NULL);";

            try {
                String updateCommand = "Update hospital set "
                    + "phoneNumber=?, address=?, community=?, state=?, zipcode=? where userID=? AND role=?;";

                PreparedStatement p2p = sqliteConnection.prepareStatement(updateCommand);
                p2p.setString(1,etInternDoctorPhoneNumber.getText());
                p2p.setString(2, etInternDoctorAddress.getText());
                p2p.setString(3, etInternDoctorCommunity.getText());
                p2p.setString(4, etInternDoctorState.getText());
                p2p.setString(5, etInternDoctorZipCode.getText());
                p2p.setString(6, etInternDoctorID.getText());
                p2p.setString(7,"Intern Doctor");
                boolean output = p2p.execute();

                if (output == false) {
                    System.out.println("row updated !");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            LocalDate localDOB = LocalDate.parse(((JTextField) dateChooserInternDocDOB.getDateEditor().getUiComponent()).getText());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            int editDoctorID = Integer.parseInt(etInternDoctorID.getText());
            String editDoctorName = etInternDoctorName.getText();
            Date editDoctorDOB = java.sql.Date.valueOf(localDOB);
            String editDoctorAge = txtFieldInternDocAge.getText();
            String editDoctorPhoneNumber = etInternDoctorPhoneNumber.getText();
            String editDoctorAddress = etInternDoctorAddress.getText();
            String editDoctorCommunity = etInternDoctorCommunity.getText();
            String editDoctorCity = etInternDoctorCity.getText();
            String editDoctorState = etInternDoctorState.getText();
            String editDoctorZipCode = etInternDoctorZipCode.getText();

            for (InternDoctor doc : internDoctorDirectory.getListOfInternDoctors()) {

                int id = doc.getDoctorID();
                if (editDoctorID == id) {
                    doc.setDoctorID(editDoctorID);
                    doc.setDoctorDOB(editDoctorDOB);
                    doc.setDoctorAge(editDoctorAge);
                    doc.setDoctorName(editDoctorName);
                    doc.setDoctorAddress(editDoctorAddress);
                    doc.setDoctorCommunity(editDoctorCommunity);
                    doc.setDoctorCity(editDoctorCity);
                    doc.setDoctorState(editDoctorState);
                    doc.setDoctorZipCode(editDoctorZipCode);
                    doc.setDoctorPhoneNumber(editDoctorPhoneNumber);

                    JOptionPane.showMessageDialog(this, "Updated Intern Doctor Details!");

                    populateInternDoctorTable();

                    etInternDoctorID.setText("");
                    etInternDoctorName.setText("");
                    txtFieldInternDocAge.setText("");
                    etInternDoctorPhoneNumber.setText("");
                    etInternDoctorAddress.setText("");
                    etInternDoctorCommunity.setText("");
                    etInternDoctorCity.setText("");
                    etInternDoctorState.setText("");
                    etInternDoctorZipCode.setText("");

                }

            }
        }
    }//GEN-LAST:event_bUpdateInternDoctorActionPerformed

    private void bDeleteInternDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteInternDoctorActionPerformed
        // TODO add your handling code here:

        int selectedRow = tableAllInternDoctor.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllInternDoctor.getModel();
        InternDoctor doc = (InternDoctor) model.getValueAt(selectedRow, 0);

        internDoctorDirectory.deleteInternDoctor(doc);
        
        try {
            String deleteStatement = "DELETE from hospital where userID=? AND role=?;";

            PreparedStatement p2p = sqliteConnection.prepareStatement(deleteStatement);
            p2p.setInt(1, doc.getDoctorID());
            p2p.setString(2, "Intern Doctor");
            boolean output = p2p.execute();

            if (output == false) {
                System.out.println("row deleted !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        populateInternDoctorTable();

        etInternDoctorID.setText("");
        txtFieldInternDocAge.setText("");
        etInternDoctorName.setText("");
        etInternDoctorPhoneNumber.setText("");
        etInternDoctorAddress.setText("");
        etInternDoctorCommunity.setText("");
        etInternDoctorCity.setText("");
        etInternDoctorState.setText("");
        etInternDoctorZipCode.setText("");
    }//GEN-LAST:event_bDeleteInternDoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeleteInternDoctor;
    private javax.swing.JButton bUpdateInternDoctor;
    private javax.swing.JButton bViewInternDoctor;
    private com.toedter.calendar.JDateChooser dateChooserInternDocDOB;
    private javax.swing.JTextField etInternDoctorAddress;
    private javax.swing.JTextField etInternDoctorCity;
    private javax.swing.JTextField etInternDoctorCommunity;
    private javax.swing.JTextField etInternDoctorID;
    private javax.swing.JTextField etInternDoctorName;
    private javax.swing.JTextField etInternDoctorPhoneNumber;
    private javax.swing.JTextField etInternDoctorState;
    private javax.swing.JTextField etInternDoctorZipCode;
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
    private javax.swing.JLabel lblInternDoctorsDetails;
    private javax.swing.JTable tableAllInternDoctor;
    private javax.swing.JTextField txtFieldInternDocAge;
    // End of variables declaration//GEN-END:variables

    public void populateInternDoctorTable() {

        DefaultTableModel model = (DefaultTableModel) tableAllInternDoctor.getModel();
        model.setRowCount(0);

        for (InternDoctor doc : internDoctorDirectory.getListOfInternDoctors()) {
            Object[] row = new Object[3];

            row[0] = doc;
            row[1] = doc.getDoctorName();
            row[2] = doc.getDoctorAge();

            model.addRow(row);
        }
    }
}

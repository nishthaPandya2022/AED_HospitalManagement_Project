/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Doctor;
import model.DoctorDirectory;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author nishthapandya
 */
public class AllDoctorsJPanel extends javax.swing.JPanel {

    private DoctorDirectory doctorDirectory;
    private ArrayList<Doctor> docDirectory;
    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;

    String GET_ALL_DOCTORS_FROM_HOSPITAL = "SELECT userID, name, DOB, age, organization, email, address, community, state, zipcode, role from hospital WHERE role=\"Doctor\"";

    //    private static final String INSERT_DATA_INTO_HOSPITAL = "CREATE TABLE IF NOT EXISTS hospital ("
//            + "userID VARCHAR(200) NOT NULL," + "name VARCHAR(200) NOT NULL,"
//            + "DOB VARCHAR(200) NOT NULL," + "age VARCHAR(200) NOT NULL,"
//            + "organization VARCHAR(200) NOT NULL," + "phoneNumber VARCHAR(200) NOT NULL,"
//            + "address VARCHAR(200) NOT NULL," + "community VARCHAR(200) NOT NULL,"
//            + "state VARCHAR(200) NOT NULL," + "zipcode VARCHAR(200) NOT NULL,"
//            + "role VARCHAR(200) NOT NULL);";
    /**
     * Creates new form AllDoctorsJPanel
     */
    public AllDoctorsJPanel(SQLiteDataSource dataSource, Connection connection) {
        initComponents();
        this.ds = dataSource;
        this.sqliteConnection = connection;
        this.doctorDirectory = new DoctorDirectory();
        docDirectory = new ArrayList<Doctor>();

        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_ALL_DOCTORS_FROM_HOSPITAL);
            ResultSet output = p2p.executeQuery();
            while (output.next()) {
                Doctor doc = new Doctor();
                doc.setDoctorID(Integer.parseInt(output.getString("userID")));
                doc.setDoctorName(output.getString("name"));
//                Date date = output.getDate("DOB");
                System.out.println("dob : " + output.getString("DOB"));
                doc.setDoctorDOB(java.sql.Date.valueOf(output.getString("DOB")));
                doc.setDoctorAge(output.getString("age"));
                doc.setDoctorSpeciality(output.getString("organization"));
                doc.setDoctorPhoneNumber(output.getString("phoneNumber"));
                doc.setDoctorAddress(output.getString("address"));
                doc.setDoctorCommunity(output.getString("community"));
                doc.setDoctorState(output.getString("state"));
                doc.setDoctorZipCode(output.getString("zipcode"));

                docDirectory.add(doc);
            }

            this.doctorDirectory.setListOfDoctors(docDirectory);

            populateDoctorTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validatedata() {

        if ("".equals(etDoctorID.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Id.");
            return false;
        }
        if (!etDoctorID.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Id.");
            return false;
        }
        if ("".equals(etDoctorSpecialization.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Specializatino.");
            return false;
        }
        if (!etDoctorSpecialization.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Specialization.");
            return false;
        }
        if ("".equals(etDoctorName.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Name.");
            return false;
        }
        if (!etDoctorName.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Name.");
            return false;
        }
        if ("".equals(etDoctorAddress.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Address.");
            return false;
        }
        if (!etDoctorAddress.getText().matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper Address.");
            return false;
        }
        if ("".equals(etDoctorCommunity.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Community.");
            return false;
        }
        if (!etDoctorCommunity.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper community.");
            return false;
        }
        if ("".equals(etDoctorZipCode.getText())) {
            JOptionPane.showMessageDialog(this, "Enter zipcode.");
            return false;
        }
        if (!etDoctorZipCode.getText().matches("[0-9]{5}(?:-[0-9]{4})?$")) {
            JOptionPane.showMessageDialog(this, "Enter zipcode in the form of xxxxx or xxxxx-xxxx.");
            return false;
        }
        if ("".equals(etDoctorCity.getText())) {
            JOptionPane.showMessageDialog(this, "Enter City.");
            return false;
        }
        if (!etDoctorCity.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper city.");
            return false;
        }
        if ("".equals(etDoctorState.getText())) {
            JOptionPane.showMessageDialog(this, "Enter State.");
            return false;
        }
        if (!etDoctorState.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper state.");
            return false;
        }
        if (!etDoctorPhoneNumber.getText().matches("[0-9]+")) {
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

        etDoctorState = new javax.swing.JTextField();
        etDoctorSpecialization = new javax.swing.JTextField();
        lblDoctorAddress = new javax.swing.JLabel();
        etDoctorZipCode = new javax.swing.JTextField();
        lblDoctorName = new javax.swing.JLabel();
        bViewDoctor = new javax.swing.JButton();
        lblDoctorPhoneNumber = new javax.swing.JLabel();
        etDoctorCity = new javax.swing.JTextField();
        lblDoctorSpecialization = new javax.swing.JLabel();
        etDoctorName = new javax.swing.JTextField();
        lblDoctorCity = new javax.swing.JLabel();
        bDeleteDoctor = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        etDoctorID = new javax.swing.JTextField();
        lblDoctorCommunity = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllDoctor = new javax.swing.JTable();
        etDoctorAddress = new javax.swing.JTextField();
        etDoctorPhoneNumber = new javax.swing.JTextField();
        bUpdateDoctor = new javax.swing.JButton();
        lblDoctorZipCode = new javax.swing.JLabel();
        etDoctorCommunity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblDoctorState = new javax.swing.JLabel();
        lblDocDOB = new javax.swing.JLabel();
        lblDocAge = new javax.swing.JLabel();
        txtFieldDocAge = new javax.swing.JTextField();
        dateChooserDocDOB = new com.toedter.calendar.JDateChooser();

        lblDoctorAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorAddress.setText("Address :");

        lblDoctorName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorName.setText("Name :");

        bViewDoctor.setText("View");
        bViewDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewDoctorActionPerformed(evt);
            }
        });

        lblDoctorPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorPhoneNumber.setText("Phone Number :");

        lblDoctorSpecialization.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorSpecialization.setText("Organization :");

        lblDoctorCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCity.setText("City :");

        bDeleteDoctor.setText("Delete");
        bDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteDoctorActionPerformed(evt);
            }
        });

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID :");

        lblDoctorCommunity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCommunity.setText("Community :");

        tableAllDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Organization", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAllDoctor);

        etDoctorAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etDoctorAddressActionPerformed(evt);
            }
        });

        bUpdateDoctor.setText("Update");
        bUpdateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateDoctorActionPerformed(evt);
            }
        });

        lblDoctorZipCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorZipCode.setText("Zip Code :");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Doctor Details");

        lblDoctorState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorState.setText("State :");

        lblDocDOB.setText("DOB :");

        lblDocAge.setText("Age :");

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
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(bViewDoctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(bUpdateDoctor)
                        .addGap(115, 115, 115)
                        .addComponent(bDeleteDoctor)
                        .addGap(103, 103, 103)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDocAge)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDoctorSpecialization, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDoctorPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addComponent(lblDoctorName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblDocDOB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etDoctorID, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(etDoctorName)
                    .addComponent(etDoctorPhoneNumber)
                    .addComponent(etDoctorSpecialization)
                    .addComponent(txtFieldDocAge)
                    .addComponent(dateChooserDocDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(etDoctorAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etDoctorCommunity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDoctorCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDoctorState, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDoctorZipCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bViewDoctor)
                    .addComponent(bUpdateDoctor)
                    .addComponent(bDeleteDoctor))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(etDoctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoctorAddress)
                    .addComponent(etDoctorAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorName)
                    .addComponent(lblDoctorCommunity)
                    .addComponent(etDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDoctorCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorCity)
                    .addComponent(etDoctorPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoctorPhoneNumber)
                    .addComponent(etDoctorCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorState)
                    .addComponent(etDoctorState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoctorSpecialization)
                    .addComponent(etDoctorSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDoctorZipCode)
                        .addComponent(etDoctorZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDocDOB))
                    .addComponent(dateChooserDocDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocAge)
                    .addComponent(txtFieldDocAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bViewDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewDoctorActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableAllDoctor.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllDoctor.getModel();
        Doctor doc = (Doctor) model.getValueAt(selectedRow, 0);

        etDoctorID.setText(String.valueOf(doc.getDoctorID()));
        etDoctorName.setText(doc.getDoctorName());
        etDoctorCity.setText(doc.getDoctorCity());
        dateChooserDocDOB.setDate(doc.getDoctorDOB());
        txtFieldDocAge.setText(doc.getDoctorAge());
        etDoctorCommunity.setText(doc.getDoctorCommunity());
        etDoctorZipCode.setText(doc.getDoctorZipCode());
        etDoctorState.setText(doc.getDoctorState());
        etDoctorAddress.setText(doc.getDoctorAddress());
        etDoctorPhoneNumber.setText(doc.getDoctorPhoneNumber());
        etDoctorSpecialization.setText(doc.getDoctorSpeciality());
//        etHospitalName.setText(doc.getHospitalName());
    }//GEN-LAST:event_bViewDoctorActionPerformed

    private void bDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteDoctorActionPerformed
        // TODO add your handling code here:

        int selectedRow = tableAllDoctor.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllDoctor.getModel();
        Doctor doc = (Doctor) model.getValueAt(selectedRow, 0);

        doctorDirectory.deleteDoc(doc);

        try {
            String deleteStatement = "DELETE from hospital where userID=? AND role=?";

            PreparedStatement p2p = sqliteConnection.prepareStatement(deleteStatement);
            p2p.setInt(1, doc.getDoctorID());
            p2p.setString(2, "Doctor");
            boolean output = p2p.execute();

            if (output == false) {
                System.out.println("row deleted !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        populateDoctorTable();

        etDoctorID.setText("");
        txtFieldDocAge.setText("");
//        dateChooserDocDOB.setDate();
        etDoctorName.setText("");
        etDoctorPhoneNumber.setText("");
        etDoctorAddress.setText("");
        etDoctorCommunity.setText("");
        etDoctorCity.setText("");
        etDoctorState.setText("");
        etDoctorZipCode.setText("");
        etDoctorSpecialization.setText("");
    }//GEN-LAST:event_bDeleteDoctorActionPerformed

    private void etDoctorAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etDoctorAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etDoctorAddressActionPerformed

    private void bUpdateDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateDoctorActionPerformed
        // TODO add your handling code here:

        if (validatedata()) {
            
            etDoctorID.setEditable(false);

//            + "userID VARCHAR(200) NOT NULL," + "name VARCHAR(200) NOT NULL,"
//            + "DOB VARCHAR(200) NOT NULL," + "age VARCHAR(200) NOT NULL,"
//            + "organization VARCHAR(200) NOT NULL," + "phoneNumber VARCHAR(200) NOT NULL,"
//            + "address VARCHAR(200) NOT NULL," + "community VARCHAR(200) NOT NULL,"
//            + "state VARCHAR(200) NOT NULL," + "zipcode VARCHAR(200) NOT NULL,"
//            + "role VARCHAR(200) NOT NULL);";

            try {
                String updateCommand = "Update hospital set organization=?, "
                    + "phoneNumber=?, address=?, community=?, state=?, zipcode=? where userID=? AND role=?;";

                PreparedStatement p2p = sqliteConnection.prepareStatement(updateCommand);
                p2p.setString(1, etDoctorSpecialization.getText());
                p2p.setString(2,etDoctorPhoneNumber.getText());
                p2p.setString(3, etDoctorAddress.getText());
                p2p.setString(4, etDoctorCommunity.getText());
                p2p.setString(5, etDoctorState.getText());
                p2p.setString(6, etDoctorZipCode.getText());
                p2p.setString(7, etDoctorID.getText());
                p2p.setString(8, "Doctor");
                boolean output = p2p.execute();

                if (output == false) {
                    System.out.println("row updated !");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            LocalDate localDOB = LocalDate.parse(((JTextField) dateChooserDocDOB.getDateEditor().getUiComponent()).getText());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            int editDoctorID = Integer.parseInt(etDoctorID.getText());
            String editDoctorName = etDoctorName.getText();
            Date editDoctorDOB = java.sql.Date.valueOf(localDOB);
            String editDoctorAge = txtFieldDocAge.getText();
            String editDoctorPhoneNumber = etDoctorPhoneNumber.getText();
            String editDoctorAddress = etDoctorAddress.getText();
            String editDoctorCommunity = etDoctorCommunity.getText();
            String editDoctorCity = etDoctorCity.getText();
            String editDoctorState = etDoctorState.getText();
            String editDoctorZipCode = etDoctorZipCode.getText();
            String editDoctorSpeciality = etDoctorSpecialization.getText();

            for (Doctor doc : doctorDirectory.getListOfDoctors()) {

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
                    doc.setDoctorSpeciality(editDoctorSpeciality);

                    JOptionPane.showMessageDialog(this, "Updated Doctor Details!");

                    populateDoctorTable();

                    etDoctorID.setText("");
                    etDoctorName.setText("");
                    txtFieldDocAge.setText("");
                    etDoctorPhoneNumber.setText("");
                    etDoctorAddress.setText("");
                    etDoctorCommunity.setText("");
                    etDoctorCity.setText("");
                    etDoctorState.setText("");
                    etDoctorZipCode.setText("");
                    etDoctorSpecialization.setText("");

                }

            }
        }

    }//GEN-LAST:event_bUpdateDoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeleteDoctor;
    private javax.swing.JButton bUpdateDoctor;
    private javax.swing.JButton bViewDoctor;
    private com.toedter.calendar.JDateChooser dateChooserDocDOB;
    private javax.swing.JTextField etDoctorAddress;
    private javax.swing.JTextField etDoctorCity;
    private javax.swing.JTextField etDoctorCommunity;
    private javax.swing.JTextField etDoctorID;
    private javax.swing.JTextField etDoctorName;
    private javax.swing.JTextField etDoctorPhoneNumber;
    private javax.swing.JTextField etDoctorSpecialization;
    private javax.swing.JTextField etDoctorState;
    private javax.swing.JTextField etDoctorZipCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDocAge;
    private javax.swing.JLabel lblDocDOB;
    private javax.swing.JLabel lblDoctorAddress;
    private javax.swing.JLabel lblDoctorCity;
    private javax.swing.JLabel lblDoctorCommunity;
    private javax.swing.JLabel lblDoctorName;
    private javax.swing.JLabel lblDoctorPhoneNumber;
    private javax.swing.JLabel lblDoctorSpecialization;
    private javax.swing.JLabel lblDoctorState;
    private javax.swing.JLabel lblDoctorZipCode;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tableAllDoctor;
    private javax.swing.JTextField txtFieldDocAge;
    // End of variables declaration//GEN-END:variables

    public void populateDoctorTable() {

        DefaultTableModel model = (DefaultTableModel) tableAllDoctor.getModel();
        model.setRowCount(0);

        for (Doctor doc : doctorDirectory.getListOfDoctors()) {
            Object[] row = new Object[4];

            row[0] = doc;
            row[1] = doc.getDoctorName();
            row[2] = doc.getDoctorSpeciality();
            row[3] = doc.getDoctorAge();

            model.addRow(row);
        }
    }
}

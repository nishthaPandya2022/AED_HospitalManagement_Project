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
import model.LabAssistant;
import model.Pharmacist;
import model.PharmacistDirectory;
import org.sqlite.SQLiteDataSource;
import static ui.admin.AllPharmacistJPanel.sqliteConnection;

/**
 *
 * @author nishthapandya
 */
public class AllPharmacistJPanel extends javax.swing.JPanel {
    
    private PharmacistDirectory pharmacistDirectory;    //doctorDirectory;
    private ArrayList<Pharmacist> labAssistDirectory;     //docDirectory
    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;

    String GET_ALL_LAB_ASSISTANT_FROM_HOSPITAL = "SELECT userID, name, DOB, age, organization, email, address, community, state, zipcode, role from hospital WHERE role=\"Pharmacist\"";

    /**
     * Creates new form PharmacistJPanel
     */
    public AllPharmacistJPanel(SQLiteDataSource dataSource, Connection connection) {
        initComponents();
        
        this.ds = dataSource;
        this.sqliteConnection = connection;
        this.pharmacistDirectory = new PharmacistDirectory();
        labAssistDirectory = new ArrayList<Pharmacist>();

        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_ALL_LAB_ASSISTANT_FROM_HOSPITAL);
            ResultSet output = p2p.executeQuery();
            while (output.next()) {
                Pharmacist doc = new Pharmacist();
                doc.setPharmacistID(Integer.parseInt(output.getString("userID")));
                doc.setPharmacistName(output.getString("name"));
//                Date date = output.getDate("DOB");
                System.out.println("dob : " + output.getString("DOB"));
                doc.setPharmacistDOB(java.sql.Date.valueOf(output.getString("DOB")));
                doc.setPharmacistAge(output.getString("age"));
                doc.setPharmacistEmail(output.getString("email"));
                doc.setPharmacistAddress(output.getString("address"));
                doc.setPharmacistCommunity(output.getString("community"));
                doc.setPharmacistState(output.getString("state"));
                doc.setPharmacistZipCode(output.getString("zipcode"));

                labAssistDirectory.add(doc);
            }

            this.pharmacistDirectory.setPharmacistDirectory(labAssistDirectory);

            populatePharmacistTable();

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
        if (!etDoctorEmail.getText().matches("[0-9]+")) {
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

        lblDocAge = new javax.swing.JLabel();
        lblDoctorName = new javax.swing.JLabel();
        etDoctorCity = new javax.swing.JTextField();
        etDoctorEmail = new javax.swing.JTextField();
        lblDoctorCommunity = new javax.swing.JLabel();
        lblDoctorEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDoctorCity = new javax.swing.JLabel();
        lblDoctorState = new javax.swing.JLabel();
        bUpdateDoctor = new javax.swing.JButton();
        dateChooserDocDOB = new com.toedter.calendar.JDateChooser();
        etDoctorZipCode = new javax.swing.JTextField();
        lblDoctorAddress = new javax.swing.JLabel();
        etDoctorAddress = new javax.swing.JTextField();
        lblDocDOB = new javax.swing.JLabel();
        bViewDoctor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllPharmacist = new javax.swing.JTable();
        etDoctorID = new javax.swing.JTextField();
        etDoctorState = new javax.swing.JTextField();
        bDeleteDoctor = new javax.swing.JButton();
        etDoctorName = new javax.swing.JTextField();
        etDoctorCommunity = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblDoctorZipCode = new javax.swing.JLabel();
        txtFieldDocAge = new javax.swing.JTextField();

        lblDocAge.setText("Age :");

        lblDoctorName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorName.setText("Name :");

        lblDoctorCommunity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCommunity.setText("Community :");

        lblDoctorEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorEmail.setText("Email :");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Pharmacist Details");

        lblDoctorCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCity.setText("City :");

        lblDoctorState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorState.setText("State :");

        bUpdateDoctor.setText("Update");
        bUpdateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateDoctorActionPerformed(evt);
            }
        });

        lblDoctorAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorAddress.setText("Address :");

        etDoctorAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etDoctorAddressActionPerformed(evt);
            }
        });

        lblDocDOB.setText("DOB :");

        bViewDoctor.setText("View");
        bViewDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewDoctorActionPerformed(evt);
            }
        });

        tableAllPharmacist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Age"
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
        jScrollPane1.setViewportView(tableAllPharmacist);

        bDeleteDoctor.setText("Delete");
        bDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteDoctorActionPerformed(evt);
            }
        });

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID :");

        lblDoctorZipCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorZipCode.setText("Zip Code :");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
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
                        .addComponent(lblDoctorEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addComponent(lblDoctorName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblDocDOB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etDoctorID, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(etDoctorName)
                    .addComponent(etDoctorEmail)
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
                    .addComponent(etDoctorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoctorEmail)
                    .addComponent(etDoctorCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDoctorState)
                        .addComponent(etDoctorState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDocDOB))
                    .addComponent(dateChooserDocDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorZipCode)
                    .addComponent(etDoctorZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDocAge)
                    .addComponent(txtFieldDocAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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
                String updateCommand = "Update hospital set "
                + "email=?, address=?, community=?, state=?, zipcode=? where userID=? AND role=?;";

                PreparedStatement p2p = sqliteConnection.prepareStatement(updateCommand);
                p2p.setString(1,etDoctorEmail.getText());
                p2p.setString(2, etDoctorAddress.getText());
                p2p.setString(3, etDoctorCommunity.getText());
                p2p.setString(4, etDoctorState.getText());
                p2p.setString(5, etDoctorZipCode.getText());
                p2p.setString(6, etDoctorID.getText());
                p2p.setString(7, "Nurse");
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
            String editDoctorEmail = etDoctorEmail.getText();
            String editDoctorAddress = etDoctorAddress.getText();
            String editDoctorCommunity = etDoctorCommunity.getText();
            String editDoctorCity = etDoctorCity.getText();
            String editDoctorState = etDoctorState.getText();
            String editDoctorZipCode = etDoctorZipCode.getText();

            for (Pharmacist pharmacist : pharmacistDirectory.getPharmacistDirectory()) {

                int id = pharmacist.getPharmacistID();
                if (editDoctorID == id) {
                    pharmacist.setPharmacistID(editDoctorID);
                    pharmacist.setPharmacistDOB(editDoctorDOB);
                    pharmacist.setPharmacistAge(editDoctorAge);
                    pharmacist.setPharmacistName(editDoctorName);
                    pharmacist.setPharmacistAddress(editDoctorAddress);
                    pharmacist.setPharmacistCommunity(editDoctorCommunity);
                    pharmacist.setPharmacistCity(editDoctorCity);
                    pharmacist.setPharmacistState(editDoctorState);
                    pharmacist.setPharmacistZipCode(editDoctorZipCode);
                    pharmacist.setPharmacistEmail(editDoctorEmail);

                    JOptionPane.showMessageDialog(this, "Updated Lab Assistant Details!");

                    populatePharmacistTable();

                    etDoctorID.setText("");
                    etDoctorName.setText("");
                    txtFieldDocAge.setText("");
                    etDoctorEmail.setText("");
                    etDoctorAddress.setText("");
                    etDoctorCommunity.setText("");
                    etDoctorCity.setText("");
                    etDoctorState.setText("");
                    etDoctorZipCode.setText("");

                }
            }
        }
    }//GEN-LAST:event_bUpdateDoctorActionPerformed

    private void etDoctorAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etDoctorAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etDoctorAddressActionPerformed

    private void bViewDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewDoctorActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableAllPharmacist.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllPharmacist.getModel();
        Pharmacist pharmacist = (Pharmacist) model.getValueAt(selectedRow, 0);

        etDoctorID.setText(String.valueOf(pharmacist.getPharmacistID()));
        etDoctorName.setText(pharmacist.getPharmacistName());
        etDoctorCity.setText(pharmacist.getPharmacistCity());
        dateChooserDocDOB.setDate(pharmacist.getPharmacistDOB());
        txtFieldDocAge.setText(pharmacist.getPharmacistAge());
        etDoctorCommunity.setText(pharmacist.getPharmacistCommunity());
        etDoctorZipCode.setText(pharmacist.getPharmacistZipCode());
        etDoctorState.setText(pharmacist.getPharmacistState());
        etDoctorAddress.setText(pharmacist.getPharmacistAddress());
        etDoctorEmail.setText(pharmacist.getPharmacistEmail());
    }//GEN-LAST:event_bViewDoctorActionPerformed

    private void bDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteDoctorActionPerformed
        // TODO add your handling code here:

        int selectedRow = tableAllPharmacist.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllPharmacist.getModel();
        Pharmacist pharmacist = (Pharmacist) model.getValueAt(selectedRow, 0);

        pharmacistDirectory.deletePharmacist(pharmacist);

        try {
            String deleteStatement = "DELETE from hospital where userID=? AND role=?";

            PreparedStatement p2p = sqliteConnection.prepareStatement(deleteStatement);
            p2p.setInt(1, pharmacist.getPharmacistID());
            p2p.setString(2, "Pharmacist");
            boolean output = p2p.execute();

            if (output == false) {
                System.out.println("row deleted !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        populatePharmacistTable();

        etDoctorID.setText("");
        txtFieldDocAge.setText("");
        etDoctorName.setText("");
        etDoctorEmail.setText("");
        etDoctorAddress.setText("");
        etDoctorCommunity.setText("");
        etDoctorCity.setText("");
        etDoctorState.setText("");
        etDoctorZipCode.setText("");
    }//GEN-LAST:event_bDeleteDoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeleteDoctor;
    private javax.swing.JButton bUpdateDoctor;
    private javax.swing.JButton bViewDoctor;
    private com.toedter.calendar.JDateChooser dateChooserDocDOB;
    private javax.swing.JTextField etDoctorAddress;
    private javax.swing.JTextField etDoctorCity;
    private javax.swing.JTextField etDoctorCommunity;
    private javax.swing.JTextField etDoctorEmail;
    private javax.swing.JTextField etDoctorID;
    private javax.swing.JTextField etDoctorName;
    private javax.swing.JTextField etDoctorState;
    private javax.swing.JTextField etDoctorZipCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDocAge;
    private javax.swing.JLabel lblDocDOB;
    private javax.swing.JLabel lblDoctorAddress;
    private javax.swing.JLabel lblDoctorCity;
    private javax.swing.JLabel lblDoctorCommunity;
    private javax.swing.JLabel lblDoctorEmail;
    private javax.swing.JLabel lblDoctorName;
    private javax.swing.JLabel lblDoctorState;
    private javax.swing.JLabel lblDoctorZipCode;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tableAllPharmacist;
    private javax.swing.JTextField txtFieldDocAge;
    // End of variables declaration//GEN-END:variables

    public void populatePharmacistTable() {

        DefaultTableModel model = (DefaultTableModel) tableAllPharmacist.getModel();
        model.setRowCount(0);

        for (Pharmacist doc : pharmacistDirectory.getPharmacistDirectory()) {
            Object[] row = new Object[4];

            row[0] = doc;
            row[1] = doc.getPharmacistName();
            row[2] = doc.getPharmacistEmail();
            row[3] = doc.getPharmacistAge();

            model.addRow(row);
        }
    }
}

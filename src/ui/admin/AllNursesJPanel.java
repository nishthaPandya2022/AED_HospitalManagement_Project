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
import model.Nurses;
import model.NursesDirectory;
import org.sqlite.SQLiteDataSource;
import static ui.admin.AllDoctorsJPanel.sqliteConnection;

/**
 *
 * @author nishthapandya
 */
public class AllNursesJPanel extends javax.swing.JPanel {

    private NursesDirectory nursesDirectory ;   //doctorDirectory;
    private ArrayList<Nurses> nurseDirectory;   //docDirectory;
    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;

    String GET_ALL_NURSES_FROM_HOSPITAL = "SELECT userID, name, DOB, age, organization, email, address, community, state, zipcode, role from hospital WHERE role=\"Nurse\"";
    
    /**
     * Creates new form JPanel
     */
    public AllNursesJPanel(SQLiteDataSource dataSource, Connection connection) {
        initComponents();
        
        this.ds = dataSource;
        this.sqliteConnection = connection;
        this.nursesDirectory = new NursesDirectory();
        nurseDirectory = new ArrayList<Nurses>();
        
        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_ALL_NURSES_FROM_HOSPITAL);
            ResultSet output = p2p.executeQuery();
            while (output.next()) {
                Nurses nurse = new Nurses();
                nurse.setNurseID(Integer.parseInt(output.getString("userID")));
                nurse.setNurseName(output.getString("name"));
//                Date date = output.getDate("DOB");
                System.out.println("dob : " + output.getString("DOB"));
                nurse.setNurseDOB(java.sql.Date.valueOf(output.getString("DOB")));
                nurse.setNurseAge(output.getString("age"));
                nurse.setNurseEmail(output.getString("email"));
                nurse.setNurseAddress(output.getString("address"));
                nurse.setNurseCommunity(output.getString("community"));
                nurse.setNurseState(output.getString("state"));
                nurse.setNurseZipCode(output.getString("zipcode"));

                nurseDirectory.add(nurse);
            }

            this.nursesDirectory.setListOfNurses(nurseDirectory);

            populateNurseTable();

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

        lblDoctorName = new javax.swing.JLabel();
        lblDocDOB = new javax.swing.JLabel();
        txtFieldDocAge = new javax.swing.JTextField();
        lblDoctorAddress = new javax.swing.JLabel();
        etDoctorName = new javax.swing.JTextField();
        etDoctorID = new javax.swing.JTextField();
        lblDoctorEmail = new javax.swing.JLabel();
        lblDocAge = new javax.swing.JLabel();
        lblDoctorZipCode = new javax.swing.JLabel();
        lblDoctorState = new javax.swing.JLabel();
        lblDoctorCity = new javax.swing.JLabel();
        bDeleteDoctor = new javax.swing.JButton();
        bViewDoctor = new javax.swing.JButton();
        etDoctorState = new javax.swing.JTextField();
        etDoctorEmail = new javax.swing.JTextField();
        lblDoctorCommunity = new javax.swing.JLabel();
        etDoctorAddress = new javax.swing.JTextField();
        etDoctorCity = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        dateChooserDocDOB = new com.toedter.calendar.JDateChooser();
        bUpdateDoctor = new javax.swing.JButton();
        etDoctorCommunity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllNurses = new javax.swing.JTable();
        etDoctorZipCode = new javax.swing.JTextField();

        lblDoctorName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorName.setText("Name :");

        lblDocDOB.setText("DOB :");

        lblDoctorAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorAddress.setText("Address :");

        lblDoctorEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorEmail.setText("Email :");

        lblDocAge.setText("Age :");

        lblDoctorZipCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorZipCode.setText("Zip Code :");

        lblDoctorState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorState.setText("State :");

        lblDoctorCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCity.setText("City :");

        bDeleteDoctor.setText("Delete");
        bDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteDoctorActionPerformed(evt);
            }
        });

        bViewDoctor.setText("View");
        bViewDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewDoctorActionPerformed(evt);
            }
        });

        lblDoctorCommunity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorCommunity.setText("Community :");

        etDoctorAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etDoctorAddressActionPerformed(evt);
            }
        });

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID :");

        bUpdateDoctor.setText("Update");
        bUpdateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateDoctorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Doctor Details");

        tableAllNurses.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableAllNurses);

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
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteDoctorActionPerformed
        // TODO add your handling code here:

        int selectedRow = tableAllNurses.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllNurses.getModel();
        Nurses nurse = (Nurses) model.getValueAt(selectedRow, 0);

        nursesDirectory.deleteNurses(nurse);

        try {
            String deleteStatement = "DELETE from hospital where userID=? AND role=?";

            PreparedStatement p2p = sqliteConnection.prepareStatement(deleteStatement);
            p2p.setInt(1, nurse.getNurseID());
            p2p.setString(2, "Nurse");
            boolean output = p2p.execute();

            if (output == false) {
                System.out.println("row deleted !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        populateNurseTable();

        etDoctorID.setText("");
        txtFieldDocAge.setText("");
        //        dateChooserDocDOB.setDate();
        etDoctorName.setText("");
        etDoctorEmail.setText("");
        etDoctorAddress.setText("");
        etDoctorCommunity.setText("");
        etDoctorCity.setText("");
        etDoctorState.setText("");
        etDoctorZipCode.setText("");
    }//GEN-LAST:event_bDeleteDoctorActionPerformed

    private void bViewDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewDoctorActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableAllNurses.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllNurses.getModel();
        Nurses doc = (Nurses) model.getValueAt(selectedRow, 0);

        etDoctorID.setText(String.valueOf(doc.getNurseID()));
        etDoctorName.setText(doc.getNurseName());
        etDoctorCity.setText(doc.getNurseCity());
        dateChooserDocDOB.setDate(doc.getNurseDOB());
        txtFieldDocAge.setText(doc.getNurseAge());
        etDoctorCommunity.setText(doc.getNurseCommunity());
        etDoctorZipCode.setText(doc.getNurseZipCode());
        etDoctorState.setText(doc.getNurseState());
        etDoctorAddress.setText(doc.getNurseAddress());
        etDoctorEmail.setText(doc.getNurseEmail());
    }//GEN-LAST:event_bViewDoctorActionPerformed

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

            for (Nurses doc : nursesDirectory.getListOfNurses()) {

                int id = doc.getNurseID();
                if (editDoctorID == id) {
                    doc.setNurseID(editDoctorID);
                    doc.setNurseDOB(editDoctorDOB);
                    doc.setNurseAge(editDoctorAge);
                    doc.setNurseName(editDoctorName);
                    doc.setNurseAddress(editDoctorAddress);
                    doc.setNurseCommunity(editDoctorCommunity);
                    doc.setNurseCity(editDoctorCity);
                    doc.setNurseState(editDoctorState);
                    doc.setNurseZipCode(editDoctorZipCode);
                    doc.setNurseEmail(editDoctorEmail);

                    JOptionPane.showMessageDialog(this, "Updated Nurse Details!");

                    populateNurseTable();

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
    private javax.swing.JTable tableAllNurses;
    private javax.swing.JTextField txtFieldDocAge;
    // End of variables declaration//GEN-END:variables

    public void populateNurseTable() {

        DefaultTableModel model = (DefaultTableModel) tableAllNurses.getModel();
        model.setRowCount(0);

        for (Nurses doc : nursesDirectory.getListOfNurses()) {
            Object[] row = new Object[4];

            row[0] = doc;
            row[1] = doc.getNurseName();
            row[2] = doc.getNurseEmail();
            row[3] = doc.getNurseAge();

            model.addRow(row);
        }
    }
}

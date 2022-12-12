/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Doctor;
import model.DoctorDirectory;
import model.Patients;
import model.PatientsDirectory;
import org.sqlite.SQLiteDataSource;
import static ui.admin.AllDoctorsJPanel.sqliteConnection;

/**
 *
 * @author nishthapandya
 */
public class AllPatientsJPanel extends javax.swing.JPanel {
    
    private PatientsDirectory patientsDirectory;   //private DoctorDirectory doctorDirectory;
    private ArrayList<Patients> patDirectory;      //private ArrayList<Doctor> docDirectory;
    
    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;

    String GET_ALL_PATIENTS_FROM_HOSPITAL = "SELECT userID, name, DOB, age, organization, email, address, community, state, zipcode, role from hospital WHERE role=\"Patient\"";

    /**
     * Creates new form AllPatientsJPanel
     */
    public AllPatientsJPanel(SQLiteDataSource dataSource, Connection connection) {
        initComponents();
        
        this.ds = dataSource;
        this.sqliteConnection = connection;
        this.patientsDirectory = new PatientsDirectory();
        patDirectory = new ArrayList<Patients>();

        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_ALL_PATIENTS_FROM_HOSPITAL);
            ResultSet output = p2p.executeQuery();
            while (output.next()) {
                Patients patient = new Patients();
                patient.setPatientID(Integer.parseInt(output.getString("userID")));
                patient.setPatientName(output.getString("name"));
                patient.setPatientDOB(java.sql.Date.valueOf(output.getString("DOB")));
                patient.setPatientAge(output.getString("age"));
                patient.setPatientPhoneNumber(output.getString("phoneNumber"));
                patient.setPatientAddress(output.getString("address"));
                patient.setPatientCommunity(output.getString("community"));
                patient.setPatientState(output.getString("state"));
                patient.setPatientZipCode(output.getString("zipcode"));
//                patient.setPatientDocName(output.getString);

                patDirectory.add(patient);
            }

            this.patientsDirectory.setPatientDirectory(patDirectory);

            populatePatientTable();

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

        etDoctorName = new javax.swing.JTextField();
        etPatientZipCode = new javax.swing.JTextField();
        etPatientID = new javax.swing.JTextField();
        lblPatientCity = new javax.swing.JLabel();
        lblPatientAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePatient = new javax.swing.JTable();
        lblPatientZipCode = new javax.swing.JLabel();
        etPatientState = new javax.swing.JTextField();
        etPatientCommunity = new javax.swing.JTextField();
        lblPatientID = new javax.swing.JLabel();
        lblDoctorName = new javax.swing.JLabel();
        bViewPatient = new javax.swing.JButton();
        etPatientPhoneNumber = new javax.swing.JTextField();
        lblPatientPhoneNumber = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        etPatientName = new javax.swing.JTextField();
        lblPatientState = new javax.swing.JLabel();
        lblPatientCommunity = new javax.swing.JLabel();
        etPatientAddress = new javax.swing.JTextField();
        etPatientCity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dateChooserPatientDOB = new com.toedter.calendar.JDateChooser();
        lblPatientDOB = new javax.swing.JLabel();
        lblPatientAge = new javax.swing.JLabel();
        txtFieldPatientAge = new javax.swing.JTextField();

        lblPatientCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientCity.setText("City :");

        lblPatientAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientAddress.setText("Address :");

        tablePatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Doctor Name", "ZipCode"
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
        jScrollPane1.setViewportView(tablePatient);

        lblPatientZipCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientZipCode.setText("Zip Code :");

        lblPatientID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientID.setText("Patient ID :");

        lblDoctorName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorName.setText("Doctor Name :");

        bViewPatient.setText("View");
        bViewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewPatientActionPerformed(evt);
            }
        });

        lblPatientPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientPhoneNumber.setText("Patient Phone Number :");

        lblPatientName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientName.setText("Patient Name :");

        lblPatientState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientState.setText("State :");

        lblPatientCommunity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientCommunity.setText("Community :");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Patient Details");

        lblPatientDOB.setText("DOB :");

        lblPatientAge.setText("Age :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bViewPatient)
                .addGap(357, 357, 357))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPatientAge))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPatientName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPatientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPatientPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDoctorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPatientDOB)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etPatientID)
                    .addComponent(etPatientName)
                    .addComponent(etDoctorName)
                    .addComponent(etPatientPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(dateChooserPatientDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFieldPatientAge))
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPatientZipCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPatientCommunity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPatientAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPatientCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPatientState, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etPatientState)
                    .addComponent(etPatientCommunity)
                    .addComponent(etPatientCity)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etPatientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(etPatientZipCode))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(bViewPatient)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPatientAddress)
                        .addComponent(etPatientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPatientCommunity)
                                .addComponent(etPatientCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPatientCity)
                                .addComponent(etPatientCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDoctorName)
                                .addComponent(etDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPatientState)
                                .addComponent(etPatientState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPatientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etPatientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateChooserPatientDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPatientID)
                                .addComponent(etPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPatientName)
                                .addComponent(etPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(117, 117, 117)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPatientZipCode)
                                .addComponent(etPatientZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPatientDOB)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientAge)
                    .addComponent(txtFieldPatientAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bViewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewPatientActionPerformed
        // TODO add your handling code here:

        int selectedRow = tablePatient.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tablePatient.getModel();
        Patients patient = (Patients) model.getValueAt(selectedRow, 0);

        etPatientID.setText(String.valueOf(patient.getPatientID()));
        etPatientName.setText(patient.getPatientName());
        etDoctorName.setText(patient.getPatientDocName());
        etPatientPhoneNumber.setText(patient.getPatientPhoneNumber());
        etPatientAddress.setText(patient.getPatientAddress());
        etPatientCommunity.setText(patient.getPatientCommunity());
        etPatientCity.setText(patient.getPatientCity());
        etPatientState.setText(patient.getPatientState());
        etPatientZipCode.setText(patient.getPatientZipCode());

    }//GEN-LAST:event_bViewPatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bViewPatient;
    private com.toedter.calendar.JDateChooser dateChooserPatientDOB;
    private javax.swing.JTextField etDoctorName;
    private javax.swing.JTextField etPatientAddress;
    private javax.swing.JTextField etPatientCity;
    private javax.swing.JTextField etPatientCommunity;
    private javax.swing.JTextField etPatientID;
    private javax.swing.JTextField etPatientName;
    private javax.swing.JTextField etPatientPhoneNumber;
    private javax.swing.JTextField etPatientState;
    private javax.swing.JTextField etPatientZipCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDoctorName;
    private javax.swing.JLabel lblPatientAddress;
    private javax.swing.JLabel lblPatientAge;
    private javax.swing.JLabel lblPatientCity;
    private javax.swing.JLabel lblPatientCommunity;
    private javax.swing.JLabel lblPatientDOB;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JLabel lblPatientPhoneNumber;
    private javax.swing.JLabel lblPatientState;
    private javax.swing.JLabel lblPatientZipCode;
    private javax.swing.JTable tablePatient;
    private javax.swing.JTextField txtFieldPatientAge;
    // End of variables declaration//GEN-END:variables

    public void populatePatientTable() {

        DefaultTableModel model = (DefaultTableModel) tablePatient.getModel();
        model.setRowCount(0);

        for (Patients patient : patientsDirectory.getPatientDirectory()) {
            Object[] row = new Object[4];

            row[0] = patient;
            row[1] = patient.getPatientName();
            row[2] = patient.getPatientDocName();
            row[3] = patient.getPatientZipCode();

            model.addRow(row);
        }
    }
}

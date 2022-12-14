/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.doctor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Appointment;
import model.AppointmentDirectory;
import model.Doctor;
import model.Patients;
import model.PatientsDirectory;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author nishthapandya
 */
public class PatientListJPanel extends javax.swing.JPanel {

    private AppointmentDirectory appointmentDirectory;   //private DoctorDirectory doctorDirectory;
    private ArrayList<Appointment> appointDirectory;      //private ArrayList<Doctor> docDirectory;

    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;

    Appointment appointment;
    String GET_ALL_PATIENTS_FROM_HOSPITAL = "SELECT h.userID, h.name, h.DOB, h.age, h.organization, h.email, h.address, h.community, state, zipcode, role from hospital h, appointment appoint WHERE role=\"Patient\" AND doctorID";
    String GET_PATIENTS_FOR_A_PARTICULAR_DOCTOR = "SELECT appointmentID, patientID, patientName, status, appointmentDate, bloodPressure, temperature, height, weight, heartRate from appointment where doctorID=?;";

    /**
     * Creates new form PatientListJPanel
     */
    public PatientListJPanel(SQLiteDataSource dataSource, Connection connection) {
        initComponents();

        this.ds = dataSource;
        this.sqliteConnection = connection;
        this.appointmentDirectory = new AppointmentDirectory();
        appointDirectory = new ArrayList<Appointment>();

        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_PATIENTS_FOR_A_PARTICULAR_DOCTOR);
            ResultSet output = p2p.executeQuery();
            while (output.next()) {
                Appointment appoint = new Appointment();
                appoint.setAppointmentID(output.getString("appointmentID"));
                appoint.setPatientID(output.getString("patientID"));
                appoint.setPatientName(output.getString("patientName"));
                appoint.setDoctorID(output.getString("doctorID"));
                appoint.setDoctorName(output.getString("doctorName"));
                appoint.setAppointmentDate(java.sql.Date.valueOf(output.getString("appointmentDate")));
                appoint.setAppointmentTime(output.getString("appointmentTime"));
                appoint.setTemperature(output.getString("temperature"));
                appoint.setBloodPressure(output.getString("bloodPressure"));
                appoint.setHeight(output.getString("height"));
                appoint.setWeight(output.getString("weight"));
                appoint.setHeartRate(output.getString("heartRate"));
                appoint.setDiagnosis(output.getString("diagnosis"));
                appoint.setAppointmentStatus(output.getString("status"));

                appointDirectory.add(appoint);
            }

            this.appointmentDirectory.setListOfAppointment(appointDirectory);

            populatePatientTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validatedata() {

        if ("".equals(etPatientID.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Id.");
            return false;
        }
        if (!etPatientID.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Id.");
            return false;
        }
        if ("".equals(etPatientName.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Name.");
            return false;
        }
        if (!etPatientName.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Name.");
            return false;
        }
        if ("".equals(etStatus.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Status.");
            return false;
        }
        if (!etStatus.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper Status.");
            return false;
        }
        if ("".equals(etPatientDiagnosis.getText())) {
            JOptionPane.showMessageDialog(this, "Enter patient diagnosis.");
            return false;
        }
        if (!etPatientDiagnosis.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper patient diagnosis.");
            return false;
        }

        if ("".equals(etBloodPressure.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Blood Pressure.");
            return false;
        }
        if (!etBloodPressure.getText().matches("[0-9. ]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Blood Pressure.");
            return false;
        }
        if ("".equals(etTemperature.getText())) {
            JOptionPane.showMessageDialog(this, "Enter temperature.");
            return false;
        }
        if (!etTemperature.getText().matches("[0-9F. ]+")) {
            JOptionPane.showMessageDialog(this, "Enter temperature in fahrenheit");
            return false;
        }
        if ("".equals(etHeight.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Height.");
            return false;
        }
        if (!etHeight.getText().matches("[0-9cm ]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper Height.");
            return false;
        }
        if ("".equals(etWeight.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Weight.");
            return false;
        }
        if (!etWeight.getText().matches("[0-9.]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper Weight.");
            return false;
        }
        if ("".equals(etHeartRate.getText())) {
            JOptionPane.showMessageDialog(this, "Enter heart rate.");
            return false;
        }
        if (!etHeartRate.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper heart rate");
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

        jLabel7 = new javax.swing.JLabel();
        etPatientName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bGetDetails = new javax.swing.JButton();
        lblPatientDiagnosis = new javax.swing.JLabel();
        etPatientDiagnosis = new javax.swing.JTextField();
        etTemperature = new javax.swing.JTextField();
        etHeartRate = new javax.swing.JTextField();
        etStatus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etHeight = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePatientList = new javax.swing.JTable();
        etPatientID = new javax.swing.JTextField();
        lblPatientID = new javax.swing.JLabel();
        etBloodPressure = new javax.swing.JTextField();
        bAddVitals = new javax.swing.JButton();
        etWeight = new javax.swing.JTextField();
        etDate = new javax.swing.JTextField();

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Height :");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Date :");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Heart Rate :");

        bGetDetails.setText("Get Details");
        bGetDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGetDetailsActionPerformed(evt);
            }
        });

        lblPatientDiagnosis.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientDiagnosis.setText("Patient Diagnosis :");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Status :");

        lblPatientName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientName.setText("Patient Name :");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Weight :");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List of Patients");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Temperature :");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Blood Pressure :");

        tablePatientList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Status", "Date & Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePatientList);

        lblPatientID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientID.setText("Patient ID :");

        bAddVitals.setText("Add Vitals");
        bAddVitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddVitalsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPatientName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPatientDiagnosis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etPatientName)
                            .addComponent(etPatientID)
                            .addComponent(etStatus)
                            .addComponent(etDate)
                            .addComponent(etPatientDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etBloodPressure)
                            .addComponent(etTemperature)
                            .addComponent(etHeight)
                            .addComponent(etWeight)
                            .addComponent(etHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAddVitals, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGetDetails))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(bGetDetails)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientID)
                    .addComponent(etPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(etBloodPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientName)
                    .addComponent(etPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(etTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(etStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(etHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(etDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(etWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientDiagnosis)
                    .addComponent(etPatientDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(etHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAddVitals)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bGetDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGetDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tablePatientList.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tablePatientList.getModel();
        Appointment appoint = (Appointment) model.getValueAt(selectedRow, 0);
        appointment = new Appointment();
        appointment = appoint;
        //TODO: Add there

        etPatientID.setText(appoint.getPatientID());
        etPatientName.setText(appoint.getPatientName());
        etStatus.setText(appoint.getAppointmentStatus());
        etDate.setText(appoint.getAppointmentDate().toString());
        etPatientDiagnosis.setText(appoint.getDiagnosis());
        etBloodPressure.setText(appoint.getBloodPressure());
        etHeight.setText(appoint.getHeight());
        etWeight.setText(appoint.getWeight());
        etTemperature.setText(appoint.getTemperature());
        etHeartRate.setText(appoint.getHeartRate());

    }//GEN-LAST:event_bGetDetailsActionPerformed

    private void bAddVitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddVitalsActionPerformed
        // TODO add your handling code here:

        if (validatedata()) {
            //TODO : vital signs

            Appointment appoint = new Appointment();
            appoint.setAppointmentID(appointment.getAppointmentID());
            appoint.setPatientID(appointment.getPatientID());
            appoint.setPatientName(appointment.getPatientName());
            appoint.setDoctorID(appointment.getDoctorID());
            appoint.setDoctorName(appointment.getDoctorName());
            appoint.setAppointmentDate(appointment.getAppointmentDate());
            appoint.setAppointmentTime(appointment.getAppointmentTime());
            appoint.setTemperature(appointment.getTemperature());
            appoint.setBloodPressure(appointment.getBloodPressure());
            appoint.setHeight(appointment.getHeight());
            appoint.setWeight(appointment.getWeight());
            appoint.setHeartRate(appointment.getHeartRate());
            appoint.setDiagnosis(appointment.getDiagnosis());
            appoint.setAppointmentStatus("COMPLETED");

            try {
                String updateAppointment = "Update appointment set bloodPressure=?,height=?, weight=?, heartRate=?, diagnosis=?, status=? where appointmentID=? AND doctorID=? ";
                PreparedStatement p2p = sqliteConnection.prepareStatement(updateAppointment);
                p2p.setString(1, appoint.getBloodPressure());
                p2p.setString(2, appoint.getHeight());
                p2p.setString(3, appoint.getWeight());
                p2p.setString(4, appoint.getHeartRate());
                p2p.setString(5, appoint.getDiagnosis());
                p2p.setString(6, appoint.getAppointmentStatus());
                p2p.setString(7, appoint.getAppointmentID());
                p2p.setString(8, appoint.getDoctorID());
                boolean output = p2p.execute();
                if(output==false){
                    System.out.println(" output updated !");
                } else {
                    System.out.println(" output not updated !");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_bAddVitalsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddVitals;
    private javax.swing.JButton bGetDetails;
    private javax.swing.JTextField etBloodPressure;
    private javax.swing.JTextField etDate;
    private javax.swing.JTextField etHeartRate;
    private javax.swing.JTextField etHeight;
    private javax.swing.JTextField etPatientDiagnosis;
    private javax.swing.JTextField etPatientID;
    private javax.swing.JTextField etPatientName;
    private javax.swing.JTextField etStatus;
    private javax.swing.JTextField etTemperature;
    private javax.swing.JTextField etWeight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPatientDiagnosis;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JTable tablePatientList;
    // End of variables declaration//GEN-END:variables

    public void populatePatientTable() {

        DefaultTableModel model = (DefaultTableModel) tablePatientList.getModel();
        model.setRowCount(0);

        for (Appointment patient : appointmentDirectory.getListOfAppointment()) {
            Object[] row = new Object[4];

            row[0] = patient;
            row[1] = patient.getPatientName();
            row[2] = patient.getAppointmentStatus();
            row[3] = patient.getAppointmentDate() + patient.getAppointmentTime();

            model.addRow(row);
        }
    }
}

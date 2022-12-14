/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.receptionist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Appointment;
import model.Doctor;
import model.DoctorDirectory;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author nishthapandya
 */
public class BookAppointmentJPanel extends javax.swing.JPanel {

    private DoctorDirectory doctorDirectory;
    private ArrayList<Doctor> docDirectory;
    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;
    String doctorID;

    String GET_ALL_APPOINTMENTS = "Select count(*) from appointment";

    String GET_ALL_DOCTORS_FROM_HOSPITAL = "SELECT userID, name, DOB, age, organization, email, address, community, state, zipcode, role from hospital WHERE role=\"Doctor\"";

    String SEARCH_PATIENT_FROM_HOSPITAL = "SELECT userID, name from hospital WHERE role=\"Patient\"";

    /**
     * Creates new form BookAppointmentJPanel
     */
    public BookAppointmentJPanel(SQLiteDataSource dataSource, Connection connection) {
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
                doc.setDoctorEmail(output.getString("email"));
                doc.setDoctorAddress(output.getString("address"));
                doc.setDoctorCommunity(output.getString("community"));
                doc.setDoctorState(output.getString("state"));
                doc.setDoctorZipCode(output.getString("zipcode"));

                docDirectory.add(doc);
            }

            this.doctorDirectory.setListOfDoctors(docDirectory);

//            populateDoctorTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validatedata() {

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

        lblBookAppointment = new javax.swing.JLabel();
        lblDoctorName = new javax.swing.JLabel();
        etDoctorName = new javax.swing.JTextField();
        lblDoctorSpecialization = new javax.swing.JLabel();
        etDoctorSpecialization = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateChooserAppointment = new com.toedter.calendar.JDateChooser();
        txtAppointmentTime = new javax.swing.JTextField();
        bBookAppointment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllDoctor = new javax.swing.JTable();
        bViewDoctor = new javax.swing.JButton();
        lblPatientID = new javax.swing.JLabel();
        etPatientID = new javax.swing.JTextField();
        etPatientName = new javax.swing.JTextField();
        lblPatientName = new javax.swing.JLabel();
        bSearchPatient = new javax.swing.JButton();

        lblBookAppointment.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblBookAppointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBookAppointment.setText("Book An Appointment");

        lblDoctorName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorName.setText("Name :");

        lblDoctorSpecialization.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDoctorSpecialization.setText("Organization :");

        jLabel1.setText("Date :");

        jLabel2.setText("Time :");

        bBookAppointment.setText("Book Appointment");
        bBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBookAppointmentActionPerformed(evt);
            }
        });

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
        tableAllDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllDoctorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAllDoctor);

        bViewDoctor.setText("View");
        bViewDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewDoctorActionPerformed(evt);
            }
        });

        lblPatientID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientID.setText("Patient ID :");

        lblPatientName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientName.setText("Patient Name :");

        bSearchPatient.setText("Search");
        bSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBookAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(lblPatientName)
                        .addGap(38, 38, 38)
                        .addComponent(etPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(bSearchPatient))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDoctorSpecialization, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDoctorName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etDoctorName)
                            .addComponent(etDoctorSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateChooserAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAppointmentTime, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPatientID)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bViewDoctor))
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bBookAppointment)
                        .addGap(262, 262, 262))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblBookAppointment)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientName)
                    .addComponent(etPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSearchPatient))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatientID))
                .addGap(30, 30, 30)
                .addComponent(bViewDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDoctorName)
                        .addComponent(etDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(dateChooserAppointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorSpecialization)
                    .addComponent(etDoctorSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtAppointmentTime, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(bBookAppointment)
                .addGap(91, 91, 91))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableAllDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllDoctorMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tableAllDoctorMouseClicked

    private void bViewDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewDoctorActionPerformed
        int selectedRow = tableAllDoctor.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableAllDoctor.getModel();
        Doctor doc = (Doctor) model.getValueAt(selectedRow, 0);

        doctorID = String.valueOf(doc.getDoctorID());
        etDoctorName.setText(doc.getDoctorName());
        etDoctorSpecialization.setText(doc.getDoctorSpeciality());
    }//GEN-LAST:event_bViewDoctorActionPerformed

    private void bBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBookAppointmentActionPerformed
        // TODO add your handling code here:

        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_ALL_APPOINTMENTS);
            ResultSet output = p2p.executeQuery();
            int userID = Integer.parseInt(output.getString("count(*)"));
            userID++;
            if (validatedata()) {
                Appointment appoint = new Appointment();
                appoint.setAppointmentID(String.valueOf(userID));
                appoint.setPatientID(etPatientID.getText());
                appoint.setPatientName(etPatientName.getText());
                appoint.setDoctorID(doctorID);
                appoint.setDoctorName(etDoctorName.getText());
                appoint.setAppointmentDate(Date.valueOf(((JTextField) dateChooserAppointment.getDateEditor().getUiComponent()).getText()));
                appoint.setAppointmentTime(txtAppointmentTime.getText());
                appoint.setTemperature("0");
                appoint.setBloodPressure("0");
                appoint.setHeight("0");
                appoint.setWeight("0");
                appoint.setHeartRate("0");
                appoint.setDiagnosis("Null");
                appoint.setAppointmentStatus("PENDING");
                
                JOptionPane.showMessageDialog(this, "Appointment Booked !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bBookAppointmentActionPerformed

    private void bSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchPatientActionPerformed
        // TODO add your handling code here:

        String patientName = etPatientName.getText();
        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(SEARCH_PATIENT_FROM_HOSPITAL);
            ResultSet output = p2p.executeQuery();
            if (output.next() == false) {
                JOptionPane.showMessageDialog(this, "No Patient details Found !");
            } else {
                while (output.next()) {

                    etPatientID.setText(output.getString("patientID"));
                    populateDoctorTable();
                }
            }

            this.doctorDirectory.setListOfDoctors(docDirectory);

            populateDoctorTable();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_bSearchPatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBookAppointment;
    private javax.swing.JButton bSearchPatient;
    private javax.swing.JButton bViewDoctor;
    private com.toedter.calendar.JDateChooser dateChooserAppointment;
    private javax.swing.JTextField etDoctorName;
    private javax.swing.JTextField etDoctorSpecialization;
    private javax.swing.JTextField etPatientID;
    private javax.swing.JTextField etPatientName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBookAppointment;
    private javax.swing.JLabel lblDoctorName;
    private javax.swing.JLabel lblDoctorSpecialization;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JTable tableAllDoctor;
    private javax.swing.JTextField txtAppointmentTime;
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

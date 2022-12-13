/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.receptionist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.HospitalUsers;
import model.Patients;
import model.PatientsDirectory;
import org.sqlite.SQLiteDataSource;
import static ui.admin.AddMembersJPanel.calculateAge;

/**
 *
 * @author nishthapandya
 */
public class PatientRegistrationJPanel extends javax.swing.JPanel {

    private PatientsDirectory patientsDirectory;   //private DoctorDirectory doctorDirectory;
    private ArrayList<Patients> patDirectory;      //private ArrayList<Doctor> docDirectory;

    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;

    String GET_ALL_PATIENTS_FROM_HOSPITAL = "SELECT userID, name, DOB, age, organization, email, address, community, state, zipcode, role from hospital WHERE role=\"Patient\"";

    private static final String GET_DATA_COUNT_FROM_HOSPITAL = "SELECT count(*) from hospital";

    /**
     * Creates new form PatientRegistrationJPanel
     */
    public PatientRegistrationJPanel(SQLiteDataSource dataSource, Connection connection) {
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
                patient.setPatientEmail(output.getString("email"));
                patient.setPatientAddress(output.getString("address"));
                patient.setPatientCommunity(output.getString("community"));
                patient.setPatientState(output.getString("state"));
                patient.setPatientZipCode(output.getString("zipcode"));
//                patient.setPatientDocName(output.getString);

                patDirectory.add(patient);
            }
            
            output.close();
            p2p.close();

            this.patientsDirectory.setPatientDirectory(patDirectory);

//            populatePatientTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validatedata() {

        if ("".equals(etRegPatientID.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Id.");
            return false;
        }
        if (!etRegPatientID.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Id.");
            return false;
        }
        if ("".equals(etRegBloodGroup.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Blood Group.");
            return false;
        }
        if (!etRegBloodGroup.getText().matches("^(A|B|AB|O)[+-]$")) {
            JOptionPane.showMessageDialog(this, "Enter Proper Blood Group.");
            return false;
        }
        if ("".equals(etRegPatientName.getText())) {
            JOptionPane.showMessageDialog(this, "Enter First Name.");
            return false;
        }
        if (!etRegPatientName.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter Proper First Name.No spaces are allowed!");
            return false;
        }
        if ("".equals(etPatientAddress.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Address.");
            return false;
        }
        if (!etPatientAddress.getText().matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper Address.");
            return false;
        }
        if ("".equals(etPatientCommunity.getText())) {
            JOptionPane.showMessageDialog(this, "Enter Community.");
            return false;
        }
        if (!etPatientCommunity.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper community.");
            return false;
        }
        if ("".equals(etPatientZipCode.getText())) {
            JOptionPane.showMessageDialog(this, "Enter zipcode.");
            return false;
        }
        if (!etPatientZipCode.getText().matches("[0-9]{5}(?:-[0-9]{4})?$")) {
            JOptionPane.showMessageDialog(this, "Enter zipcode in the form of xxxxx or xxxxx-xxxx.");
            return false;
        }
        if ("".equals(etPatientCity.getText())) {
            JOptionPane.showMessageDialog(this, "Enter City.");
            return false;
        }
        if (!etPatientCity.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper city.");
            return false;
        }
        if ("".equals(etPatientState.getText())) {
            JOptionPane.showMessageDialog(this, "Enter State.");
            return false;
        }
        if (!etPatientState.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Enter proper state.");
            return false;
        }
        if (!etRegPatientEmail.getText().matches("[0-9]+")) {
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

        lblRegPatientAddress = new javax.swing.JLabel();
        etRegPatientEmail = new javax.swing.JTextField();
        etPatientZipCode = new javax.swing.JTextField();
        etPatientCity = new javax.swing.JTextField();
        etPatientState = new javax.swing.JTextField();
        lblRegPatientZipCode = new javax.swing.JLabel();
        lblRegPatientName = new javax.swing.JLabel();
        lblRegPatientState = new javax.swing.JLabel();
        lblPatientPhoneNumber = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        lblRegPatientCommunity = new javax.swing.JLabel();
        etRegPatientID = new javax.swing.JTextField();
        etPatientCommunity = new javax.swing.JTextField();
        lblRegPatientGender = new javax.swing.JLabel();
        etRegPatientName = new javax.swing.JTextField();
        bRegisterPatient = new javax.swing.JButton();
        lblRegPatientID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        etPatientAddress = new javax.swing.JTextField();
        lblRegPatientCity = new javax.swing.JLabel();
        lblRegBloodGroup = new javax.swing.JLabel();
        etRegBloodGroup = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dateChooserPatientDOB = new com.toedter.calendar.JDateChooser();

        lblRegPatientAddress.setText("Address :");

        lblRegPatientZipCode.setText("Zip Code :");

        lblRegPatientName.setText("Patient Name :");

        lblRegPatientState.setText("State :");

        lblPatientPhoneNumber.setText("Email :");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        cbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenderActionPerformed(evt);
            }
        });

        lblRegPatientCommunity.setText("Community :");

        lblRegPatientGender.setText("Gender :");

        bRegisterPatient.setText("Register");
        bRegisterPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegisterPatientActionPerformed(evt);
            }
        });

        lblRegPatientID.setText("Patient ID :");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient Registration");

        lblRegPatientCity.setText("City :");

        lblRegBloodGroup.setText("Blood Group :");

        jLabel2.setText("Date Of Birth :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(bRegisterPatient))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblPatientPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegBloodGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegPatientAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegPatientCommunity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegPatientCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegPatientID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegPatientName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegPatientGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegPatientState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegPatientZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etRegPatientName)
                            .addComponent(etRegPatientID)
                            .addComponent(etRegBloodGroup)
                            .addComponent(etPatientZipCode)
                            .addComponent(etPatientAddress)
                            .addComponent(etPatientCommunity)
                            .addComponent(etPatientCity)
                            .addComponent(etPatientState)
                            .addComponent(etRegPatientEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(dateChooserPatientDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegPatientID)
                    .addComponent(etRegPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegPatientName)
                    .addComponent(etRegPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegPatientGender)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateChooserPatientDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etRegBloodGroup)
                    .addComponent(lblRegBloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegPatientAddress)
                    .addComponent(etPatientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegPatientCommunity)
                    .addComponent(etPatientCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegPatientCity)
                    .addComponent(etPatientCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegPatientState)
                    .addComponent(etPatientState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegPatientZipCode)
                    .addComponent(etPatientZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientPhoneNumber)
                    .addComponent(etRegPatientEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(bRegisterPatient)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGenderActionPerformed

    private void bRegisterPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegisterPatientActionPerformed
        // TODO add your handling code here:

        if (validatedata()) {

            try {
                PreparedStatement p2p = sqliteConnection.prepareStatement(GET_DATA_COUNT_FROM_HOSPITAL);
                ResultSet output = p2p.executeQuery();
                int userID = Integer.parseInt(output.getString("count(*)"));
                System.out.println("GET_DATA_COUNT_FROM_HOSPITAL : " + userID);
                String editRegPatientName = etRegPatientName.getText();
                String editRegPatientGender = cbGender.getSelectedItem().toString();
                String editRegPatientBloodGroup = etRegBloodGroup.getText();
                String editRegPatientAddress = etPatientAddress.getText();
                String editRegPatientCommunity = etPatientCommunity.getText();
                String editRegPatientCity = etPatientCity.getText();
                String editRegPatientState = etPatientState.getText();
                String editRegPatientZipCode = etPatientZipCode.getText();
                String editRegPatientEmail= etRegPatientEmail.getText();

                HospitalUsers hospUser = new HospitalUsers();
                userID++;
                hospUser.setUserID(String.valueOf(userID));
                hospUser.setName(editRegPatientName);
//            hospUser.setDOB(((JTextField) dateChooserDOB.getDateEditor().getUiComponent()).getText());
                hospUser.setDOB(Date.valueOf(((JTextField) dateChooserPatientDOB.getDateEditor().getUiComponent()).getText()));
                LocalDate localDOB = LocalDate.parse(((JTextField) dateChooserPatientDOB.getDateEditor().getUiComponent()).getText());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                System.out.println(formatter.format(localDOB));
                int age = calculateAge(localDOB);
                hospUser.setAge(String.valueOf(age));
                hospUser.setOrganization("Null");
                hospUser.setEmail(editRegPatientEmail);
                hospUser.setAddress(editRegPatientAddress);
                hospUser.setCommunity(editRegPatientCommunity);
                hospUser.setState(editRegPatientState);
                hospUser.setZipcode(editRegPatientZipCode);
                hospUser.setRole("Patient");

                boolean dataInserted = insertDataToDB(hospUser);
                System.out.println("dataInserted : " + dataInserted);
            } catch (Exception e) {
                e.printStackTrace();
            }

            etRegPatientID.setText("");
            etRegPatientName.setText("");
            cbGender.setSelectedIndex(0);
            etRegBloodGroup.setText("");
            etPatientAddress.setText("");
            etPatientCity.setText("");
            etPatientCommunity.setText("");
            etPatientState.setText("");
            etPatientZipCode.setText("");
            etRegPatientEmail.setText("");
        }
    }//GEN-LAST:event_bRegisterPatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRegisterPatient;
    private javax.swing.JComboBox<String> cbGender;
    private com.toedter.calendar.JDateChooser dateChooserPatientDOB;
    private javax.swing.JTextField etPatientAddress;
    private javax.swing.JTextField etPatientCity;
    private javax.swing.JTextField etPatientCommunity;
    private javax.swing.JTextField etPatientState;
    private javax.swing.JTextField etPatientZipCode;
    private javax.swing.JTextField etRegBloodGroup;
    private javax.swing.JTextField etRegPatientEmail;
    private javax.swing.JTextField etRegPatientID;
    private javax.swing.JTextField etRegPatientName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPatientPhoneNumber;
    private javax.swing.JLabel lblRegBloodGroup;
    private javax.swing.JLabel lblRegPatientAddress;
    private javax.swing.JLabel lblRegPatientCity;
    private javax.swing.JLabel lblRegPatientCommunity;
    private javax.swing.JLabel lblRegPatientGender;
    private javax.swing.JLabel lblRegPatientID;
    private javax.swing.JLabel lblRegPatientName;
    private javax.swing.JLabel lblRegPatientState;
    private javax.swing.JLabel lblRegPatientZipCode;
    // End of variables declaration//GEN-END:variables

    public boolean insertDataToDB(HospitalUsers hospUser) {

        int loginID;
        boolean output;
        String username = hospUser.getName() + hospUser.getUserID();
        String password = hospUser.getRole() + hospUser.getUserID() + hospUser.getAge();
        String GET_DATA_COUNT_FROM_LOGIN = "SELECT count(*) from login;";

        try {
            PreparedStatement p1p = sqliteConnection.prepareStatement(GET_DATA_COUNT_FROM_LOGIN);
            ResultSet loginCountOutput = p1p.executeQuery();
            loginID = Integer.parseInt(loginCountOutput.getString("count(*)"));
            System.out.println("loginID : " + loginID);
            loginID++;
            System.out.println("after update loginID : " + loginID);

            String INSERT_DATA_INTO_HOSPITAL = "INSERT INTO hospital"
                    + "(userID, name, DOB, age, organization, email, address, community, state, zipcode, role)"
                    + "VALUES ('" + hospUser.getUserID() + "','" + hospUser.getName()
                    + "','" + hospUser.getDOB() + "','" + hospUser.getAge()
                    + "','" + hospUser.getOrganization() + "','" + hospUser.getEmail()
                    + "','" + hospUser.getAddress() + "','" + hospUser.getCommunity()
                    + "','" + hospUser.getState() + "','" + hospUser.getZipcode()
                    + "','" + hospUser.getRole() + "');";

            String INSERT_DATA_INTO_LOGIN = "INSERT INTO login(loginID, userID, username, password)"
                    + " VALUES ('" + loginID + "','" + hospUser.getUserID() + "','" + username + "','" + password + "');";

            PreparedStatement p2p = sqliteConnection.prepareStatement(INSERT_DATA_INTO_HOSPITAL);
            output = p2p.execute();
            if (output == false) {
                PreparedStatement p3p = sqliteConnection.prepareStatement(INSERT_DATA_INTO_LOGIN);
                boolean loginOutput = p3p.execute();
                if (loginOutput == false) {
                    JOptionPane.showMessageDialog(this, "UserName :"
                            + username + "\n Password : " + password + "\n User added to Hospital!");
                    return false;
                } else {
                    System.out.println("loginOutput == false");
                }
            } else {
                System.out.println("hospital Output == false");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static int calculateAge(LocalDate dob) {
//creating an instance of the LocalDate class and invoking the now() method      
//now() method obtains the current date from the system clock in the default time zone      
        LocalDate curDate = LocalDate.now();
//calculates the amount of time between two dates and returns the years  
        if ((dob != null) && (curDate != null)) {
            return Period.between(dob, curDate).getYears();
        } else {
            return 0;
        }
    }
}

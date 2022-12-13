/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.admin;

import com.raven.component.Message;
import java.sql.Connection;
import java.time.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.HospitalUserDirectory;
import model.HospitalUsers;
import org.sqlite.SQLiteDataSource;
import java.sql.Date;
import model.LoginCredentials;
import model.ModelMessage;
import model.ServiceMail;
import model.ServiceUser;

/**
 *
 * @author nishthapandya
 */
public class AddMembersJPanel extends javax.swing.JPanel {

    private static final String GET_DATA_FROM_HOSPITAL = "SELECT * FROM hospital";

    private static final String GET_DATA_COUNT_FROM_HOSPITAL = "SELECT count(*) from hospital";

    HospitalUserDirectory hospDirectory;
    static SQLiteDataSource ds = null;
    static Connection sqliteConnection;

    /**
     * Creates new form AddMembersJPanel
     */
    public AddMembersJPanel(SQLiteDataSource dataSource, Connection connection) {
        initComponents();

        this.ds = dataSource;
        this.sqliteConnection = connection;
        hospDirectory = new HospitalUserDirectory();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAddHospitalMembers = new javax.swing.JLabel();
        lblAddMemberName = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        txtFieldMemberName = new javax.swing.JTextField();
        lblAddMemberRole = new javax.swing.JLabel();
        lblAddMemberOrganization = new javax.swing.JLabel();
        comboBoxOrganization = new javax.swing.JComboBox<>();
        lblAddMemberAddress = new javax.swing.JLabel();
        lblAddMemberCommunity = new javax.swing.JLabel();
        lblAddMemberEmail = new javax.swing.JLabel();
        lblAddMemberCity = new javax.swing.JLabel();
        txtFieldEmail = new javax.swing.JTextField();
        txtFieldAddress = new javax.swing.JTextField();
        txtFieldCommunity = new javax.swing.JTextField();
        txtFieldCity = new javax.swing.JTextField();
        lblAddMemberState = new javax.swing.JLabel();
        lblAddMemberZipCode = new javax.swing.JLabel();
        txtFieldState = new javax.swing.JTextField();
        txtFieldZipCode = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        comboBoxRole = new javax.swing.JComboBox<>();
        dateChooserDOB = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(252, 229, 229));

        lblAddHospitalMembers.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblAddHospitalMembers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddHospitalMembers.setText("Add Hospital Members");

        lblAddMemberName.setText("Name :");

        lblDateOfBirth.setText("Date Of Birth :");

        lblAddMemberRole.setText("Role :");

        lblAddMemberOrganization.setText("Organization :");

        comboBoxOrganization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an option", "General", "Radiology", "Cardiology", "OBGYN", "Neurology", "Pediatrics", "Pharmacy", "Laboratory", "Pathology ( Blood Bank )", "Dermatology" }));

        lblAddMemberAddress.setText("Address :");

        lblAddMemberCommunity.setText("Community :");

        lblAddMemberEmail.setText("Email :");

        lblAddMemberCity.setText("City :");

        txtFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEmailActionPerformed(evt);
            }
        });

        lblAddMemberState.setText("State :");

        lblAddMemberZipCode.setText("Zip Code :");

        btnAdd.setText("Add Member");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        comboBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an option", "Receptionist", "Doctor", "Intern Doctor", "Nurse", "Patient", "LabAssistant", "Pharmacist", "Pathologist" }));
        comboBoxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRoleActionPerformed(evt);
            }
        });

        dateChooserDOB.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddHospitalMembers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddMemberRole)
                    .addComponent(lblDateOfBirth)
                    .addComponent(lblAddMemberName)
                    .addComponent(lblAddMemberEmail)
                    .addComponent(lblAddMemberOrganization))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxOrganization, 0, 1, Short.MAX_VALUE)
                    .addComponent(txtFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtFieldMemberName)
                    .addComponent(comboBoxRole, 0, 1, Short.MAX_VALUE)
                    .addComponent(dateChooserDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblAddMemberAddress)
                            .addGap(35, 35, 35))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblAddMemberCommunity)
                            .addGap(18, 18, 18))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAddMemberState)
                                .addComponent(lblAddMemberZipCode))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAddMemberCity)
                        .addGap(61, 61, 61)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtFieldAddress)
                        .addComponent(txtFieldCommunity)
                        .addComponent(txtFieldState)
                        .addComponent(txtFieldZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(322, 322, 322))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblAddHospitalMembers)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddMemberName)
                    .addComponent(txtFieldMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddMemberAddress)
                    .addComponent(txtFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDateOfBirth)
                        .addComponent(lblAddMemberCommunity)
                        .addComponent(txtFieldCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooserDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddMemberRole)
                    .addComponent(lblAddMemberCity)
                    .addComponent(txtFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddMemberOrganization)
                    .addComponent(comboBoxOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddMemberState)
                    .addComponent(txtFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddMemberEmail)
                    .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddMemberZipCode)
                    .addComponent(txtFieldZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(174, 174, 174))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEmailActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
            PreparedStatement p2p = sqliteConnection.prepareStatement(GET_DATA_COUNT_FROM_HOSPITAL);
            ResultSet output = p2p.executeQuery();
            int userID = Integer.parseInt(output.getString("count(*)"));
            System.out.println("GET_DATA_COUNT_FROM_HOSPITAL : " + userID);
            String role = (String) comboBoxRole.getSelectedItem();
            System.out.println("role : " + role);
            System.out.println("dateChooserDOB.getDateFormatString() : " + ((JTextField) dateChooserDOB.getDateEditor().getUiComponent()).getText());
//            System.out.println("dob : " + dateChooserDOB.getDate());

            LocalDate localDOB = LocalDate.parse(((JTextField) dateChooserDOB.getDateEditor().getUiComponent()).getText());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println(formatter.format(localDOB));
            int age = calculateAge(localDOB);
            System.out.println("age : " + age);

            String organization = (String) comboBoxOrganization.getSelectedItem();
            if (organization.equals("Select an option")) {
                organization = "Null";
            }
            System.out.println("organization : " + organization);

            HospitalUsers hospUser = hospDirectory.addNewHospitalUsers();
            userID++;
            hospUser.setUserID(String.valueOf(userID));
            hospUser.setName(txtFieldMemberName.getText());
//            hospUser.setDOB(((JTextField) dateChooserDOB.getDateEditor().getUiComponent()).getText());
            hospUser.setDOB(Date.valueOf(((JTextField) dateChooserDOB.getDateEditor().getUiComponent()).getText()));
            hospUser.setAge(String.valueOf(age));
            hospUser.setOrganization(organization);
            hospUser.setEmail(txtFieldEmail.getText());
            hospUser.setAddress(txtFieldAddress.getText());
            hospUser.setCommunity(txtFieldCommunity.getText());
            hospUser.setState(txtFieldState.getText());
            hospUser.setZipcode(txtFieldZipCode.getText());
            hospUser.setRole(comboBoxRole.getSelectedItem().toString());

            boolean dataInserted = insertDataToDB(hospUser);
            System.out.println("dataInserted : " + dataInserted);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void comboBoxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRoleActionPerformed
        String role = comboBoxRole.getSelectedItem().toString();

        if (role.equals("Patient")) {
            comboBoxOrganization.setSelectedIndex(0);
            comboBoxOrganization.setEnabled(false);
        } else {
            comboBoxOrganization.setEnabled(true);
        }

    }//GEN-LAST:event_comboBoxRoleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> comboBoxOrganization;
    private javax.swing.JComboBox<String> comboBoxRole;
    private com.toedter.calendar.JDateChooser dateChooserDOB;
    private javax.swing.JLabel lblAddHospitalMembers;
    private javax.swing.JLabel lblAddMemberAddress;
    private javax.swing.JLabel lblAddMemberCity;
    private javax.swing.JLabel lblAddMemberCommunity;
    private javax.swing.JLabel lblAddMemberEmail;
    private javax.swing.JLabel lblAddMemberName;
    private javax.swing.JLabel lblAddMemberOrganization;
    private javax.swing.JLabel lblAddMemberRole;
    private javax.swing.JLabel lblAddMemberState;
    private javax.swing.JLabel lblAddMemberZipCode;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JTextField txtFieldAddress;
    private javax.swing.JTextField txtFieldCity;
    private javax.swing.JTextField txtFieldCommunity;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldMemberName;
    private javax.swing.JTextField txtFieldState;
    private javax.swing.JTextField txtFieldZipCode;
    // End of variables declaration//GEN-END:variables

    public boolean insertDataToDB(HospitalUsers hospUser) {

        int loginID;
        boolean output;
        String username = hospUser.getEmail();
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

            PreparedStatement p2p = sqliteConnection.prepareStatement(INSERT_DATA_INTO_HOSPITAL);
            output = p2p.execute();
            if (output == false) {
                //user credentials
                LoginCredentials loginUser = new LoginCredentials();
                loginUser.setUsername(hospUser.getEmail());
                loginUser.setPassword(password);
                loginUser.setLoginID(String.valueOf(loginID));
                loginUser.setUserID(hospUser.getUserID());

                //service class called
                ServiceUser serviceUser = new ServiceUser(sqliteConnection);
//            serviceUser.insertUser(loginUser);

                try {
                    if (serviceUser.checkDuplicateEmail(loginUser.getUsername())) {
                        System.out.println("ui.admin.AddMembersJPanel.insertDataToDB():checkDuplicationEMAIL ()");
//                    showMessage(serviceUser.MessageType.ERROR, "Email already exit");
                    } else {
                        System.out.println("before serviceUSER.insertUSER");
                        serviceUser.insertUser(loginUser);
                        System.out.println("after serviceUSER.insertUSER");
                        sendMain(loginUser, serviceUser);
                        System.out.println("after sendMain");
                    }

                    JOptionPane.showMessageDialog(this, "UserName :"
                            + username + "\n Password : " + password + "\n User added to Hospital!");
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
//                showMessage(Message.MessageType.ERROR, "Error Register");
                }

                //older-code - DONOT DELETE
                String INSERT_DATA_INTO_LOGIN = "INSERT INTO login(loginID, userID, username, password)"
                        + " VALUES ('" + loginID + "','" + hospUser.getUserID() + "','" + username + "','" + password + "');";

//                PreparedStatement p3p = sqliteConnection.prepareStatement(INSERT_DATA_INTO_LOGIN);
//                boolean loginOutput = p3p.execute();
//                if (loginOutput == false) {
//                    JOptionPane.showMessageDialog(this, "UserName :"
//                            + username + "\n Password : " + password + "\n User added to Hospital!");
//                    return false;
//                } else {
//                    System.out.println("loginOutput == false");
//                }
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

    private void sendMain(LoginCredentials user, ServiceUser serviceUser) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                ModelMessage ms = new ServiceMail().sendMain(user.getUsername(), user.getVerifyCode());
//                ModelMessage ms = new ServiceMail().sendMain( user.getVerifyCode());
                System.out.println("ms : " + ms.isSuccess());
                System.out.println("ms : " + ms.getMessage());
                if (ms.isSuccess()) {
//                    loading.setVisible(false);
                    CredentialsJFrame credential = new CredentialsJFrame(user, serviceUser);
                    credential.setVisible(true);
                } else {
                    System.out.println("Error !");
//                    loading.setVisible(false);
//                    showMessage(Message.MessageType.ERROR, ms.getMessage());
                }
            }
        }).start();

    }
}

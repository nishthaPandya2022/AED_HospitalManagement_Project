 package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

public class ServiceUser {

    private final Connection connection;

    public ServiceUser(Connection con) {
        this.connection = con;
    }

    public void insertUser(LoginCredentials user) throws SQLException {
        PreparedStatement p = connection.prepareStatement("insert into login (loginID, userID, username, password, verifyCode) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        String code = generateVerifyCode();
        p.setString(1, user.getLoginID());
        p.setString(2, user.getUserID());
        p.setString(3, user.getUsername());
        p.setString(4, user.getPassword());
        p.setString(5, code);
        p.execute();
        ResultSet r = p.getGeneratedKeys();
        r.next();
        int userID = r.getInt(1);
        r.close();
        p.close();
        user.setUserID(String.valueOf(userID));
        user.setVerifycode(code);
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = connection.prepareStatement("select userID from login where verifyCode=? limit 1");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateEmail(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = connection.prepareStatement("select username from login where username=? and status='Verified' limit 1");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = connection.prepareStatement("update login set verifyCode='', `status`='Verified' where loginID=?");
        p.setInt(1, userID);
        p.execute();
        p.close();
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        boolean verify = false;
        PreparedStatement p = connection.prepareStatement("select loginID from  `login` where loginID=? and verifyCode=?");
        p.setInt(1, userID);
        p.setString(2, code);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            verify = true;
        }
        r.close();
        p.close();
        return verify;
    }
}

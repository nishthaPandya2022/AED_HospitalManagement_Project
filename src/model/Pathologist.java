/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author nishthapandya
 */
public class Pathologist {
    
    private int pathologistID;
    private String pathologistName;
    private Date pathologistDOB;
    private String pathologistAge;
    private String pathologistAddress;
    private String pathologistCommunity;
    private String pathologistCity;
    private String pathologistState;
    private String pathologistZipCode;
    private String pathologistEmail;

    public int getPathologistID() {
        return pathologistID;
    }

    public void setPathologistID(int pathologistID) {
        this.pathologistID = pathologistID;
    }

    public String getPathologistName() {
        return pathologistName;
    }

    public void setPathologistName(String pathologistName) {
        this.pathologistName = pathologistName;
    }

    public Date getPathologistDOB() {
        return pathologistDOB;
    }

    public void setPathologistDOB(Date pathologistDOB) {
        this.pathologistDOB = pathologistDOB;
    }

    public String getPathologistAge() {
        return pathologistAge;
    }

    public void setPathologistAge(String pathologistAge) {
        this.pathologistAge = pathologistAge;
    }

    public String getPathologistAddress() {
        return pathologistAddress;
    }

    public void setPathologistAddress(String pathologistAddress) {
        this.pathologistAddress = pathologistAddress;
    }

    public String getPathologistCommunity() {
        return pathologistCommunity;
    }

    public void setPathologistCommunity(String pathologistCommunity) {
        this.pathologistCommunity = pathologistCommunity;
    }

    public String getPathologistCity() {
        return pathologistCity;
    }

    public void setPathologistCity(String pathologistCity) {
        this.pathologistCity = pathologistCity;
    }

    public String getPathologistState() {
        return pathologistState;
    }

    public void setPathologistState(String pathologistState) {
        this.pathologistState = pathologistState;
    }

    public String getPathologistZipCode() {
        return pathologistZipCode;
    }

    public void setPathologistZipCode(String pathologistZipCode) {
        this.pathologistZipCode = pathologistZipCode;
    }

    public String getPathologistEmail() {
        return pathologistEmail;
    }

    public void setPathologistEmail(String pathologistEmail) {
        this.pathologistEmail = pathologistEmail;
    }

    @Override
    public String toString() {
        return String.valueOf(pathologistID);
    }
    
    
    
}

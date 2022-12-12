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
public class Receptionist {
    
    private int receptionistID;
    private String receptionistName;
    private Date receptionistDOB;
    private String receptionistAge;
    private String receptionistAddress;
    private String receptionistCommunity;
    private String receptionistCity;
    private String receptionistState;
    private String receptionistZipCode;
    private String receptionistEmail;

    public int getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(int receptionistID) {
        this.receptionistID = receptionistID;
    }

    public String getReceptionistName() {
        return receptionistName;
    }

    public void setReceptionistName(String receptionistName) {
        this.receptionistName = receptionistName;
    }

    public Date getReceptionistDOB() {
        return receptionistDOB;
    }

    public void setReceptionistDOB(Date receptionistDOB) {
        this.receptionistDOB = receptionistDOB;
    }

    public String getReceptionistAge() {
        return receptionistAge;
    }

    public void setReceptionistAge(String receptionistAge) {
        this.receptionistAge = receptionistAge;
    }

    public String getReceptionistAddress() {
        return receptionistAddress;
    }

    public void setReceptionistAddress(String receptionistAddress) {
        this.receptionistAddress = receptionistAddress;
    }

    public String getReceptionistCommunity() {
        return receptionistCommunity;
    }

    public void setReceptionistCommunity(String receptionistCommunity) {
        this.receptionistCommunity = receptionistCommunity;
    }

    public String getReceptionistCity() {
        return receptionistCity;
    }

    public void setReceptionistCity(String receptionistCity) {
        this.receptionistCity = receptionistCity;
    }

    public String getReceptionistState() {
        return receptionistState;
    }

    public void setReceptionistState(String receptionistState) {
        this.receptionistState = receptionistState;
    }

    public String getReceptionistZipCode() {
        return receptionistZipCode;
    }

    public void setReceptionistZipCode(String receptionistZipCode) {
        this.receptionistZipCode = receptionistZipCode;
    }

    public String getReceptionistEmail() {
        return receptionistEmail;
    }

    public void setReceptionistEmail(String receptionistEmail) {
        this.receptionistEmail = receptionistEmail;
    }
    
    @Override
    public String toString(){
        return String.valueOf(receptionistID);
    }
    
}

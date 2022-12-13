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
public class Pharmacist {
    
    private int pharmacistID;
    private String pharmacistName;
    private Date pharmacistDOB;
    private String pharmacistAge;
    private String pharmacistAddress;
    private String pharmacistCommunity;
    private String pharmacistCity;
    private String pharmacistState;
    private String pharmacistZipCode;
    private String pharmacistEmail;

    public int getPharmacistID() {
        return pharmacistID;
    }

    public void setPharmacistID(int pharmacistID) {
        this.pharmacistID = pharmacistID;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public void setPharmacistName(String pharmacisttName) {
        this.pharmacistName = pharmacisttName;
    }

    public Date getPharmacistDOB() {
        return pharmacistDOB;
    }

    public void setPharmacistDOB(Date pharmacistDOB) {
        this.pharmacistDOB = pharmacistDOB;
    }

    public String getPharmacistAge() {
        return pharmacistAge;
    }

    public void setPharmacistAge(String pharmacistAge) {
        this.pharmacistAge = pharmacistAge;
    }

    public String getPharmacistAddress() {
        return pharmacistAddress;
    }

    public void setPharmacistAddress(String pharmacistAddress) {
        this.pharmacistAddress = pharmacistAddress;
    }

    public String getPharmacistCommunity() {
        return pharmacistCommunity;
    }

    public void setPharmacistCommunity(String pharmacistCommunity) {
        this.pharmacistCommunity = pharmacistCommunity;
    }

    public String getPharmacistCity() {
        return pharmacistCity;
    }

    public void setPharmacistCity(String pharmacistCity) {
        this.pharmacistCity = pharmacistCity;
    }

    public String getPharmacistState() {
        return pharmacistState;
    }

    public void setPharmacistState(String pharmacistState) {
        this.pharmacistState = pharmacistState;
    }

    public String getPharmacistZipCode() {
        return pharmacistZipCode;
    }

    public void setPharmacistZipCode(String pharmacistZipCode) {
        this.pharmacistZipCode = pharmacistZipCode;
    }

    public String getPharmacistEmail() {
        return pharmacistEmail;
    }

    public void setPharmacistEmail(String pharmacistEmail) {
        this.pharmacistEmail = pharmacistEmail;
    }

    @Override
    public String toString() {
        return String.valueOf(pharmacistID);
    }
    
    
    
}

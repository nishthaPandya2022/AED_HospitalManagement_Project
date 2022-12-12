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
public class Nurses {
    
    private int nurseID;
    private String nurseName;
    private Date nurseDOB;
    private String nurseAge;
    private String nurseAddress;
    private String nurseCommunity;
    private String nurseCity;
    private String nurseState;
    private String nurseZipCode;
    private String nurseEmail;

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public Date getNurseDOB() {
        return nurseDOB;
    }

    public void setNurseDOB(Date nurseDOB) {
        this.nurseDOB = nurseDOB;
    }

    public String getNurseAge() {
        return nurseAge;
    }

    public void setNurseAge(String nurseAge) {
        this.nurseAge = nurseAge;
    }

    public String getNurseAddress() {
        return nurseAddress;
    }

    public void setNurseAddress(String nurseAddress) {
        this.nurseAddress = nurseAddress;
    }

    public String getNurseCommunity() {
        return nurseCommunity;
    }

    public void setNurseCommunity(String nurseCommunity) {
        this.nurseCommunity = nurseCommunity;
    }

    public String getNurseCity() {
        return nurseCity;
    }

    public void setNurseCity(String nurseCity) {
        this.nurseCity = nurseCity;
    }

    public String getNurseState() {
        return nurseState;
    }

    public void setNurseState(String nurseState) {
        this.nurseState = nurseState;
    }

    public String getNurseZipCode() {
        return nurseZipCode;
    }

    public void setNurseZipCode(String nurseZipCode) {
        this.nurseZipCode = nurseZipCode;
    }

    public String getNurseEmail() {
        return nurseEmail;
    }

    public void setNurseEmail(String nurseEmail) {
        this.nurseEmail = nurseEmail;
    }

    @Override
    public String toString() {
        return String.valueOf(nurseID);
    }
    
    
    
}

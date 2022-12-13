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
public class LabAssistant {
    
    private int labAssistantID;
    private String labAssistantName;
    private Date labAssistantDOB;
    private String labAssistantAge;
    private String labAssistantAddress;
    private String labAssistantCommunity;
    private String labAssistantCity;
    private String labAssistantState;
    private String labAssistantZipCode;
    private String labAssistantEmail;

    public int getLabAssistantID() {
        return labAssistantID;
    }

    public void setLabAssistantID(int labAssistantID) {
        this.labAssistantID = labAssistantID;
    }

    public String getLabAssistantName() {
        return labAssistantName;
    }

    public void setLabAssistantName(String labAssistantName) {
        this.labAssistantName = labAssistantName;
    }

    public Date getLabAssistantDOB() {
        return labAssistantDOB;
    }

    public void setLabAssistantDOB(Date labAssistantDOB) {
        this.labAssistantDOB = labAssistantDOB;
    }

    public String getLabAssistantAge() {
        return labAssistantAge;
    }

    public void setLabAssistantAge(String labAssistantAge) {
        this.labAssistantAge = labAssistantAge;
    }

    public String getLabAssistantAddress() {
        return labAssistantAddress;
    }

    public void setLabAssistantAddress(String labAssistantAddress) {
        this.labAssistantAddress = labAssistantAddress;
    }

    public String getLabAssistantCommunity() {
        return labAssistantCommunity;
    }

    public void setLabAssistantCommunity(String labAssistantCommunity) {
        this.labAssistantCommunity = labAssistantCommunity;
    }

    public String getLabAssistantCity() {
        return labAssistantCity;
    }

    public void setLabAssistantCity(String labAssistantCity) {
        this.labAssistantCity = labAssistantCity;
    }

    public String getLabAssistantState() {
        return labAssistantState;
    }

    public void setLabAssistantState(String labAssistantState) {
        this.labAssistantState = labAssistantState;
    }

    public String getLabAssistantZipCode() {
        return labAssistantZipCode;
    }

    public void setLabAssistantZipCode(String labAssistantZipCode) {
        this.labAssistantZipCode = labAssistantZipCode;
    }

    public String getLabAssistantEmail() {
        return labAssistantEmail;
    }

    public void setLabAssistantEmail(String labAssistantEmail) {
        this.labAssistantEmail = labAssistantEmail;
    }

    @Override
    public String toString() {
        return String.valueOf(labAssistantID);
    }
    
    
    
}

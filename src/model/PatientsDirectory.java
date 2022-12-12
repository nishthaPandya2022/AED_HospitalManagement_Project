/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author nishthapandya
 */
public class PatientsDirectory {
    
    private ArrayList<Patients> listOfPatients;
    
    public PatientsDirectory() {
        this.listOfPatients = new ArrayList<>();
    }

    public ArrayList<Patients> getPatientDirectory() {
        return listOfPatients;
    }

    public void setPatientDirectory(ArrayList<Patients> patientDirectory) {
        this.listOfPatients = patientDirectory;
    }
    
    public void deletePatients(Patients patient) {
        listOfPatients.remove(patient);
    }
    
}

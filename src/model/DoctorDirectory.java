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
public class DoctorDirectory {
    
    private ArrayList<Doctor> listOfDoctors;

    public DoctorDirectory() {
        this.listOfDoctors = new ArrayList<>();
    }

    public ArrayList<Doctor> getListOfDoctors() {
        return listOfDoctors;
    }

    public void setListOfDoctors(ArrayList<Doctor> listOfDoctors) {
        this.listOfDoctors = listOfDoctors;
    }
    
    public void deleteEmp(Doctor doc) {
        listOfDoctors.remove(doc);
    }
}

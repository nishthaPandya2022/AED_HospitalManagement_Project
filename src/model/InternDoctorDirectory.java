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
public class InternDoctorDirectory {
    
    private ArrayList<InternDoctor> listOfInternDoctors;

    public InternDoctorDirectory() {
        this.listOfInternDoctors = new ArrayList<>();
    }

    public ArrayList<InternDoctor> getListOfInternDoctors() {
        return listOfInternDoctors;
    }

    public void setListOfInternDoctors(ArrayList<InternDoctor> listOfInternDoctors) {
        this.listOfInternDoctors = listOfInternDoctors;
    }
    
    public void deleteInternDoctor(InternDoctor doc) {
        listOfInternDoctors.remove(doc);
    }
    
}

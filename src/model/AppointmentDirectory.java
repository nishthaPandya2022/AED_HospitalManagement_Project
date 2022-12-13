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
public class AppointmentDirectory {
    private ArrayList<Appointment> listOfAppointment;

    public AppointmentDirectory() {
        this.listOfAppointment = new ArrayList<>();
    }

    public ArrayList<Appointment> getListOfAppointment() {
        return listOfAppointment;
    }

    public void setListOfAppointment(ArrayList<Appointment> listOfAppointment) {
        this.listOfAppointment = listOfAppointment;
    }
    
    public void deleteAppointment(Appointment doc) {
        listOfAppointment.remove(doc);
    }
}

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
public class ReceptionistDirectory {
    
    private ArrayList<Receptionist> listOfReceptionist;

    public ReceptionistDirectory() {
        this.listOfReceptionist = new ArrayList<Receptionist>();
    }

    public ArrayList<Receptionist> getListOfReceptionist() {
        return listOfReceptionist;
    }

    public void setListOfReceptionist(ArrayList<Receptionist> listOfReceptionist) {
        this.listOfReceptionist = listOfReceptionist;
    }
    
    public void deleteReceptionist(Receptionist recp) {
        listOfReceptionist.remove(recp);
    }
    
    
    
}

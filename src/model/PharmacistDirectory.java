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
public class PharmacistDirectory {
    
    private ArrayList<Pharmacist> listOfPharmacist;
    
    public PharmacistDirectory() {
        this.listOfPharmacist = new ArrayList<>();
    }

    public ArrayList<Pharmacist> getPharmacistDirectory() {
        return listOfPharmacist;
    }

    public void setPharmacistDirectory(ArrayList<Pharmacist> labAssistantDirectory) {
        this.listOfPharmacist = labAssistantDirectory;
    }
    
    public void deletePharmacist(Pharmacist pharm) {
        listOfPharmacist.remove(pharm);
    }
    
}

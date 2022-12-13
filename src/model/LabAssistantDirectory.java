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
public class LabAssistantDirectory {
    
    private ArrayList<LabAssistant> listOfLabAssistant;
    
    public LabAssistantDirectory() {
        this.listOfLabAssistant = new ArrayList<>();
    }

    public ArrayList<LabAssistant> getLabAssistantDirectory() {
        return listOfLabAssistant;
    }

    public void setLabAssistantDirectory(ArrayList<LabAssistant> labAssistantDirectory) {
        this.listOfLabAssistant = labAssistantDirectory;
    }
    
    public void deleteLabAssistant(LabAssistant lab) {
        listOfLabAssistant.remove(lab);
    }
    
}

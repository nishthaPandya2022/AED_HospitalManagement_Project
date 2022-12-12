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
public class PathologistDirectory {
    
    private ArrayList<Pathologist> listOfPathologist;
    
    public PathologistDirectory() {
        this.listOfPathologist = new ArrayList<>();
    }

    public ArrayList<Pathologist> getPathologistDirectory() {
        return listOfPathologist;
    }

    public void setPathologistDirectory(ArrayList<Pathologist> labAssistantDirectory) {
        this.listOfPathologist = labAssistantDirectory;
    }
    
    public void deletePathologist(Pathologist pathologist) {
        listOfPathologist.remove(pathologist);
    }
    
}

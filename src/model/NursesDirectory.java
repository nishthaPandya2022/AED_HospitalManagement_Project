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
public class NursesDirectory {
    
    private ArrayList<Nurses> listOfNurses;
    
    public NursesDirectory() {
        this.listOfNurses = new ArrayList<>();
    }

    public ArrayList<Nurses> getListOfNurses() {
        return listOfNurses;
    }

    public void setListOfNurses(ArrayList<Nurses> listOfNurses) {
        this.listOfNurses = listOfNurses;
    }
    
    public void deleteNurses(Nurses nurses) {
        listOfNurses.remove(nurses);
    }
    
}

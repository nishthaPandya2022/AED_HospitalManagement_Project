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
public class HospitalUserDirectory {
    
    private ArrayList<HospitalUsers> listOfHospUsers;

    public HospitalUserDirectory() {
        this.listOfHospUsers = new ArrayList<>();
    }
    
    public ArrayList<HospitalUsers> getListOfHospUsers() {
        return listOfHospUsers;
    }

    public void setListOfHospUsers(ArrayList<HospitalUsers> listOfHospUsers) {
        this.listOfHospUsers = listOfHospUsers;
    }
    
    public HospitalUsers addNewHospitalUsers() {
        HospitalUsers newUser = new HospitalUsers();
        listOfHospUsers.add(newUser);
        return newUser;
    }
    
    public void deleteEmp(HospitalUsers community) {
        listOfHospUsers.remove(community);
    }
    
}

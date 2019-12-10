/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListUser {
    ArrayList<User> lstUser;

    public ListUser() {
        this.lstUser = new ArrayList<User>();;
    }

    public ListUser(ArrayList<User> lstUser) {
        this.lstUser = lstUser;
    }

    public ArrayList<User> getLstUser() {
        return lstUser;
    }

    public void setLstUser(ArrayList<User> lstUser) {
        this.lstUser = lstUser;
    }
    
    public ArrayList<User> getFileUser() throws IOException{
       lstUser = DocFileUser.docFileTaiKhoan("USER.txt");
       return lstUser;
    }
     
    public void ghiFileTaiKhoan() throws FileNotFoundException{
        DocFileUser.ghiFileTaiKhoan("USER.txt", lstUser);
    }
    
    //Add user
    public void add(User user) {
        lstUser.add(user);
    }
    
    //Sua user
    public void update(User user) {
       for (User us : lstUser) {
            if (us.getTenTK().equals(user.getTenTK())) {
                us.setMatKhau(user.getMatKhau());
            }
        }
    }
    
    //ham tim kiem
    public User find(String sMa) {
        for (User user : lstUser) {
            if (user.getTenTK().equals(sMa)) {
                return user;
            }
        }
        return null;
    }
    
    
}

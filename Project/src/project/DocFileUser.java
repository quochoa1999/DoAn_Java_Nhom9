/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class DocFileUser {
    public static ArrayList<User> docFileTaiKhoan(String fName) throws FileNotFoundException, IOException {
        ArrayList<User> lstTaiKhoan = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(fName))) {
            String line;
            while((line = bf.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(line,":");
                while(tokens.hasMoreTokens()){
                    String tenTK = tokens.nextToken();
                    String matKhau = tokens.nextToken();
                    User tk = new User(tenTK, matKhau);
                    lstTaiKhoan.add(tk);
                }
            }
        }
        return lstTaiKhoan;
    }
    
    public static  void ghiFileTaiKhoan(String fName, ArrayList<User> listTaiKhoan) throws FileNotFoundException{
        PrintWriter fOut = new PrintWriter(fName);
        for(User tk : listTaiKhoan){
            fOut.println(tk.stringGhiFile());
        }
        fOut.close();
    }
}

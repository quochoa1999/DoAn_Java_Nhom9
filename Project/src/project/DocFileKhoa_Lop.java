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
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DocFileKhoa_Lop {
    public static ArrayList<Khoa> docFileKhoa(String fName) throws FileNotFoundException, IOException {
        ArrayList<Khoa> lstKhoa = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(fName))) {
            String line;
            while((line = bf.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(line,":");
                while(tokens.hasMoreTokens()){
                    ListLop lstLop = new ListLop();
                    String maKhoa = tokens.nextToken();
                    String tenKhoa = tokens.nextToken();
                    while(tokens.hasMoreTokens()){
                        String maLop = tokens.nextToken();
                        String tenLop = tokens.nextToken();
                        lstLop.add(new Lop(maLop, tenLop));
                    }
                    lstKhoa.add(new Khoa(maKhoa, tenKhoa, lstLop));
                }
            }
        }
        return lstKhoa;
    }
    
    public static  void ghiFileKhoa(String fName, ArrayList<Khoa> listKhoa) throws FileNotFoundException{
        PrintWriter fOut = new PrintWriter(fName);
        for(Khoa khoa : listKhoa){
            fOut.println(khoa.stringGhiFile());
        }
        fOut.close();
    }
}

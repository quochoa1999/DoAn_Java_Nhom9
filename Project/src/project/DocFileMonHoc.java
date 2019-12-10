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
public class DocFileMonHoc {
    public static void docFileKhoa(String fName,  ListKhoa qlkhoa) throws FileNotFoundException, IOException {
        try (BufferedReader bf = new BufferedReader(new FileReader(fName))) {
            String line;
            while((line = bf.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(line,":");
                while(tokens.hasMoreTokens()){
                    ListMonHoc ListMH = new ListMonHoc();
                    String maKhoa = tokens.nextToken();
                    
                    while(tokens.hasMoreTokens()){
                        MonHoc MH = new MonHoc();
                        MH.setMaMon(tokens.nextToken());
                        MH.setTenMon(tokens.nextToken());
                        ListMH.add(MH);
                    }
                    qlkhoa.find(maKhoa).setDsMonHoc(ListMH);
                }
            }
        }
    }
    
    public static  void ghiFileKhoa(String fName, ArrayList<Khoa> listKhoa) throws FileNotFoundException{
        PrintWriter fOut = new PrintWriter(fName);
        for(Khoa khoa : listKhoa){
            fOut.println(khoa.stringGhiFileMonHoc());
        }
        fOut.close();
    }
}

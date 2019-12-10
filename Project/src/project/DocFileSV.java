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
public class DocFileSV {
    public static ArrayList<SinhVien> docFileSinhVien(String fName, ListKhoa qlkhoa) throws FileNotFoundException, IOException {
        ArrayList<SinhVien> lstSinhVien = new ArrayList<>();
        Lop lop = new Lop();
        try (BufferedReader bf = new BufferedReader(new FileReader(fName))) {
            String line;
            while((line = bf.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(line,":");
                while(tokens.hasMoreTokens()){
                    String maSV = tokens.nextToken();
                    String tenSV = tokens.nextToken();
                    String namSinh = tokens.nextToken();
                   
                    String tenKhoa = tokens.nextToken();
                    Khoa khoa = qlkhoa.findName(tenKhoa);
                    String tenLop = tokens.nextToken();
                    lop = khoa.getDSLop().findName(tenLop);
                    String diaChi = tokens.nextToken();
                    SinhVien sv = new SinhVien(maSV, tenSV, namSinh, lop, khoa, diaChi);
                    lstSinhVien.add(sv);
                }
            }
        }
        return lstSinhVien;
    }
    
    public static  void ghiFileSinhVien(String fName, ArrayList<SinhVien> lstSV) throws FileNotFoundException{
        PrintWriter fOut = new PrintWriter(fName);
        for(SinhVien sv : lstSV){
            fOut.println(sv.stringGhiFile());
        }
        fOut.close();
    }
}

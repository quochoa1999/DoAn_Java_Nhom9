/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ASUS
 */
public class ListKhoa {
    ArrayList<Khoa> lstKhoa;

    public ListKhoa() {
        this.lstKhoa = new ArrayList<Khoa>();
    }

    public ListKhoa(ArrayList<Khoa> lstKhoa) {
        this.lstKhoa = lstKhoa;
    }

    public ArrayList<Khoa> getLstKhoa() {
        return lstKhoa;
    }
    
    public ArrayList<Khoa> getFileKhoa() throws IOException {
       lstKhoa = DocFileKhoa_Lop.docFileKhoa("Khoa.txt");
       return lstKhoa;
    }
    
    public void ghiFileKhoa() throws FileNotFoundException{
        DocFileKhoa_Lop.ghiFileKhoa("Khoa.txt", lstKhoa);
    }
    
    public void ghiFileKhoaToMonHoc() throws FileNotFoundException{
        DocFileMonHoc.ghiFileKhoa("MonHoc.txt", lstKhoa);
    }

    public void setLstKhoa(ArrayList<Khoa> lstKhoa) {
        this.lstKhoa = lstKhoa;
    }
    
    //Add khoa
    public void add(Khoa khoa) {
        lstKhoa.add(khoa);
    }

    //Xoa khoa
    public void delete(String sKhoa) {
        for (Khoa khoa : lstKhoa) {
            if (sKhoa.equals(khoa.getMaKhoa())) {
                lstKhoa.remove(khoa);
                return;
            }
        }
    }

    //Sua khoa
    public void update(String sMa, Khoa newKhoa) {
        for(Khoa khoa : lstKhoa){
            if(khoa.getMaKhoa().equals(sMa)){
                khoa.setMaKhoa(newKhoa.getMaKhoa());
                khoa.setTenKhoa(newKhoa.getTenKhoa());
            }
        }
        
       
    }

    //ham tim kiem
    public Khoa find(String sMa) {
        for (Khoa khoa : lstKhoa) {
            if (khoa.getMaKhoa().equals(sMa)) {
                return khoa;
            }
        }
        return null;
    }
    
    //ham tim kiem ten
    public Khoa findName(String sMa) {
        for (Khoa khoa : lstKhoa) {
            if (khoa.getTenKhoa().equals(sMa)) {
                return khoa;
            }
        }
        return null;
    }
    
    //Sap xếp Khoa theo Mã
    public void sortKhoaByMa() {
        Collections.sort(lstKhoa, new Comparator<Khoa>() {
            public int compare(Khoa khoa1, Khoa khoa2) {
                return khoa1.getMaKhoa().compareTo(khoa2.getMaKhoa());
            }
        });
    }
    //Sap xếp Khoa theo Tên
    public void sortKhoaByName() {
        Collections.sort(lstKhoa, new Comparator<Khoa>() {
            public int compare(Khoa khoa1, Khoa khoa2) {
                return khoa1.getTenKhoa().compareTo(khoa2.getTenKhoa());
            }
        });
    }
    
}

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
public class ListDiemMonHoc {
    ArrayList<DiemMonHoc> lstDiemMH;

    public ListDiemMonHoc() {
        lstDiemMH = new ArrayList<>();
    }

    public ListDiemMonHoc(ArrayList<DiemMonHoc> lstDiemMH) {
        this.lstDiemMH = lstDiemMH;
    }

    public ArrayList<DiemMonHoc> getLstDiemMH() {
        return lstDiemMH;
    }

    public void setLstDiemMH(ArrayList<DiemMonHoc> lstDiemMH) {
        this.lstDiemMH = lstDiemMH;
    }
    
    public void ghiFileDiemMH() throws FileNotFoundException{
        DocFileDiemMonHoc.ghiFile("DiemMonHoc.txt", lstDiemMH);
    }
    
    public void add(DiemMonHoc diemMH){
        lstDiemMH.add(diemMH);
    }
    
    public void detele(String sMa, String sMonHoc){
        for(DiemMonHoc dMH : lstDiemMH){
            if(dMH.getSinhVien().getMaSV().equals(sMa) && dMH.getMonHoc().getTenMon().equals(sMonHoc)){
                lstDiemMH.remove(dMH);
                return;
            }
        }
    }
    
    public void upload(String sMa, String sMonHoc, DiemMonHoc diemMH){
        for(DiemMonHoc dMH : lstDiemMH){
            if(dMH.getSinhVien().getMaSV().equals(sMa) && dMH.getMonHoc().getTenMon().equals(sMonHoc)){
                dMH.setSinhVien(diemMH.getSinhVien());
                dMH.setMonHoc(diemMH.getMonHoc());
                dMH.setDiem(diemMH.getDiem());
            }
        }
    }
    
  
    
    
}

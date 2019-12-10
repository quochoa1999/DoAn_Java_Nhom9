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
public class ListSV {
    ArrayList<SinhVien> lstSV;

    public ListSV() {
        this.lstSV = new ArrayList<SinhVien>();
    }

    public ListSV(ArrayList<SinhVien> lstSV) {
        this.lstSV = lstSV;
    }

    public ArrayList<SinhVien> getLstSV() {
        return lstSV;
    }

    public void setLstSV(ArrayList<SinhVien> lstSV) {
        this.lstSV = lstSV;
    }
    
    public ArrayList<SinhVien> getFileSinhVien(ListKhoa qlkhoa) throws IOException{
       lstSV = DocFileSV.docFileSinhVien("SinhVien.txt", qlkhoa);
       return lstSV;
    }
    
    //ghi thong tin cac sinh vien xuong file
    public void ghiFileSinhVien() throws FileNotFoundException{
        DocFileSV.ghiFileSinhVien("sinhVien.txt", lstSV);
    }
    
    //Add sv
    public void add(SinhVien sv) {
        lstSV.add(sv);
    }

    //Xoa sv
    public void delete(String sMa) {
        for (SinhVien sv : lstSV) {
            if (sMa.equals(sv.getMaSV())) {
                lstSV.remove(sv);
                return;
            }
        }
    }

    //Sua sv
    public void update(String sSinhVien, SinhVien newSV) {
        for(SinhVien sv : lstSV){
            if(sv.getMaSV().equals(sSinhVien)){
                sv.setMaSV(newSV.getMaSV());
                sv.setTenSV(newSV.getTenSV());
                sv.setNamSinh(newSV.getNamSinh());
                sv.setLop(newSV.getLop());
                sv.setKhoa(newSV.getKhoa());
                sv.setDiaChi(newSV.getDiaChi());
            }
        }
    }

    //ham tim kiem
    public SinhVien find(String sMa) {
        for (SinhVien sv : lstSV) {
            if (sv.getMaSV().equals(sMa)) {
                return sv;
            }
        }
        return null;
    }
    
    //ham tim kiem
    public SinhVien findName(String sMa) {
        for (SinhVien sv : lstSV) {
            if (sv.getTenSV().equals(sMa)) {
                return sv;
            }
        }
        return null;
    }
    //Sap xếp Sinh Vien theo mã
    public void sortSVByMaSV() {
        Collections.sort(lstSV, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getMaSV().compareTo(sv2.getMaSV());
            }
        });
    }
    
    //Sap xếp Sinh Vien theo Tên
    public void sortSVByName() {
        Collections.sort(lstSV, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getTenSV().compareTo(sv2.getTenSV());
            }
        });
    }
    
    //Sap xếp Sinh Vien theo Năm Sinh
    public void sortSVByMaBirthday() {
        Collections.sort(lstSV, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getNamSinh().compareTo(sv2.getNamSinh());
            }
        });
    }
    
    //Sap xếp Sinh Vien theo Lớp
    public void sortSVByClass() {
        Collections.sort(lstSV, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getLop().getTenLop().compareTo(sv2.getLop().getTenLop());
            }
        });
    }
    
    //Sap xếp Sinh Vien theo Khoa
    public void sortSVByKhoa() {
        Collections.sort(lstSV, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getKhoa().getTenKhoa().compareTo(sv2.getKhoa().getTenKhoa());
            }
        });
    }
    
    //Sap xếp Sinh Vien theo Addpress
    public void sortSVByAddpress() {
        Collections.sort(lstSV, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getDiaChi().compareTo(sv2.getDiaChi());
            }
        });
    }  
}

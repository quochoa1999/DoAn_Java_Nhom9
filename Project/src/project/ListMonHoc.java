/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ASUS
 */
public class ListMonHoc {
    ArrayList<MonHoc> lstMonHoc;

    public ListMonHoc() {
        lstMonHoc = new ArrayList<>();
    }

    public ListMonHoc(ArrayList<MonHoc> lstMonHoc) {
        this.lstMonHoc = lstMonHoc;
    }

    public ArrayList<MonHoc> getLstMonHoc() {
        return lstMonHoc;
    }

    public void setLstMonHoc(ArrayList<MonHoc> lstMonHoc) {
        this.lstMonHoc = lstMonHoc;
    }
    
    //Add MonHoc
    public void add(MonHoc mh) {
        lstMonHoc.add(mh);
    }

    //Xoa MonHoc
    public void delete(MonHoc mh) {
        for (MonHoc monHoc : lstMonHoc) {
            if (monHoc.getMaMon().equals(mh.getMaMon())) {
                lstMonHoc.remove(monHoc);
                return;
            }
        }
    }

    //Sua MonHoc
    public void update(String sMa, MonHoc mh) {
        for (MonHoc monHoc :lstMonHoc) {
            if (sMa.equals(monHoc.getMaMon())) {
                monHoc.setMaMon(mh.getMaMon());
                monHoc.setTenMon(mh.getTenMon());
                
            }
        }
    }

    //ham tim kiem
    public MonHoc find(String sMa) {
        for (MonHoc mh : lstMonHoc) {
            if (mh.getMaMon().equals(sMa)) {
                return mh;
            }
        }
        return null;
    }
    
    //ham tim kiem ten
    public MonHoc findName(String sMa) {
        for (MonHoc mh : lstMonHoc) {
            if (mh.getTenMon().equals(sMa)) {
                return mh;
            }
        }
        return null;
    }
    
    //Sap xếp Lớp theo Mã
    public void sortMonByMa() {
        Collections.sort(lstMonHoc, new Comparator<MonHoc>() {
            public int compare(MonHoc mh1, MonHoc mh2) {
                return mh1.getMaMon().compareTo(mh2.getMaMon());
            }
        });
    }
    //Sap xếp Lop theo Tên
    public void sortMonByName() {
        Collections.sort(lstMonHoc, new Comparator<MonHoc>() {
            public int compare(MonHoc mh1, MonHoc mh2) {
                return mh1.getTenMon().compareTo(mh2.getTenMon());
            }
        });
    }
}

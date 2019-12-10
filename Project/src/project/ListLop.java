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
public class ListLop {
    ArrayList<Lop> lstLop;

    public ListLop() {
        this.lstLop = new ArrayList<Lop>();
    }

    public ListLop(ArrayList<Lop> lstLop) {
        this.lstLop = lstLop;
    }

    public ArrayList<Lop> getLstLop() {
        return lstLop;
    }

    public void setLstLop(ArrayList<Lop> lstLop) {
        this.lstLop = lstLop;
    }
    
    //Add Lop
    public void add(Lop lop) {
        lstLop.add(lop);
    }

    //Xoa lop
    public void delete(Lop newLop) {
        for (Lop lop : lstLop) {
            if (newLop.getMaLop().equals(lop.getMaLop())) {
                lstLop.remove(lop);
                return;
            }
        }
    }

    //Sua lop
    public void update(String sMa, Lop newLop) {
        for (Lop lop : lstLop) {
            if (sMa.equals(lop.getMaLop())) {
                lop.setMaLop(newLop.getMaLop());
                lop.setTenLop(newLop.getTenLop());
                
            }
        }
    }

    //ham tim kiem
    public Lop find(String sMa) {
        for (Lop lop : lstLop) {
            if (lop.getMaLop().equals(sMa)) {
                return lop;
            }
        }
        return null;
    }
    
    //ham tim kiem ten
    public Lop findName(String sMa) {
        for (Lop lop : lstLop) {
            if (lop.getTenLop().equals(sMa)) {
                return lop;
            }
        }
        return null;
    }
    
    //Sap xếp Lớp theo Mã
    public void sortLopByMa() {
        Collections.sort(lstLop, new Comparator<Lop>() {
            public int compare(Lop lop1, Lop lop2) {
                return lop1.getMaLop().compareTo(lop2.getMaLop());
            }
        });
    }
    //Sap xếp Lop theo Tên
    public void sortLopByName() {
        Collections.sort(lstLop, new Comparator<Lop>() {
            public int compare(Lop lop1, Lop lop2) {
                return lop1.getTenLop().compareTo(lop2.getTenLop());
            }
        });
    }
}

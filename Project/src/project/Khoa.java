/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private ListLop dsLop = new ListLop();
    private ListMonHoc dsMonHoc = new ListMonHoc();

    public Khoa() {
    }
    
    public Khoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public Khoa(String maKhoa, String tenKhoa, ListLop lstLop) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.dsLop = lstLop;
    }
    
    public Khoa(String maKhoa, String tenKhoa, ListLop lstLop, ListMonHoc lstMonHoc) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.dsLop = lstLop;
        this.dsMonHoc = lstMonHoc;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public ListLop getDSLop() {
        return dsLop;
    }

    public void setDSLop(ListLop lstLop) {
        this.dsLop = lstLop;
    }

    public ListMonHoc getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(ListMonHoc dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }
 
    
    public String stringGhiFile() {
        String s = maKhoa + ":" + tenKhoa;
        for(Lop lop : dsLop.getLstLop()){
            s = s + ":" + lop.stringGhiFile();
        }
        return s;
    }
    
    public String stringGhiFileMonHoc() {
        String s = maKhoa;
        for(MonHoc mh : dsMonHoc.getLstMonHoc()){
            s = s + ":" + mh.stringGhiFile();
        }
        return s;
    }

    
    
}

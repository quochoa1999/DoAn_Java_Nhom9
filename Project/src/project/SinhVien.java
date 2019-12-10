/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author ASUS
 */
public class SinhVien {
    private String maSV;
    private String tenSV;
    private String namSinh;
    private Lop lop;
    private Khoa khoa;
    private String diaChi;

    public SinhVien() {
    }

    public SinhVien(String maSV, String tenSV, String namSinh, Lop lop, Khoa khoa, String diaChi) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.namSinh = namSinh;
        this.lop = lop;
        this.khoa = khoa;
        this.diaChi = diaChi;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public String stringGhiFile(){
        return this.maSV + ":" + this.tenSV + ":" + this.namSinh + ":" + 
                khoa.getTenKhoa() + ":" + lop.getTenLop() + ":" + this.diaChi;
    }
    
}

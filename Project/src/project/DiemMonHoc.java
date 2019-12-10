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
public class DiemMonHoc {
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private String diem;

    public DiemMonHoc() {
    }

    public DiemMonHoc(SinhVien sinhVien, MonHoc monHoc, String Diem) {
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.diem = Diem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String Diem) {
        this.diem = Diem;
    }
    
    public String stringGhiFile(){
        return sinhVien.getMaSV() + ":" + monHoc.getTenMon() + ":" + diem;
    }
}

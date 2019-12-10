/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Graphics;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *  Project Nhóm 9
 *  Name: Quản Lý Sinh Viên
 */

/**
 * Các Thành Viên
 *  Lê Quốc Hòa
 *  Huỳnh Đỗ Vương
 *  Nguyễn Thị Tâm Như
 */
public class FormMain extends javax.swing.JFrame {
    //Khoi tao các list : ListUser , ListSinhVien, ListKhoa
    private ListUser qluser = new ListUser();
    private ListSV qlsv = new ListSV();
    private ListKhoa qlkhoa = new ListKhoa();
    private ListDiemMonHoc qlDiemMH = new ListDiemMonHoc();

    /**
     * Creates new form FormMain
     */
    public FormMain() throws IOException {
        qluser.getFileUser();
        qlkhoa.getFileKhoa();
        DocFileMonHoc.docFileKhoa("MonHoc.txt", qlkhoa);
        qlsv.getFileSinhVien(qlkhoa);
        DocFileDiemMonHoc.docFile("DiemMonHoc.txt", qlDiemMH, qlsv, qlkhoa);
        initComponents();
        //Hien thi Page
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(TrangChu);
        Page.repaint();
        Page.revalidate();
    }
    //Load ComBoBox Sắp Xếp Sinh Viên
    public void loadCbbSapXepSV() {
        cbbSapxepSV.removeAllItems();
        cbbSapxepSV.addItem("Sắp xếp theo Mã");
        cbbSapxepSV.addItem("Sắp xếp theo Tên");
        cbbSapxepSV.addItem("Sắp xếp theo Năm Sinh");
        cbbSapxepSV.addItem("Sắp xếp theo Lớp");
        cbbSapxepSV.addItem("Sắp xếp theo Khoa");
        cbbSapxepSV.addItem("Sắp xếp theo Địa Chỉ");
    }
    //Load ComBoBox Sắp Xếp Khoa
    public void loadCbbSapXepKhoa() {
        cbbSapxepKhoa.removeAllItems();
        cbbSapxepKhoa.addItem("Sắp xếp theo Mã");
        cbbSapxepKhoa.addItem("Sắp xếp theo Tên");
    }
    
    //Load ComBoBox Sắp Xếp Lớp
    public void loadCbbSapXepLop() {
        cbbSapxepLop.removeAllItems();
        cbbSapxepLop.addItem("Sắp xếp theo Mã");
        cbbSapxepLop.addItem("Sắp xếp theo Tên");
    }
    
    //Load ComBoBox Sắp Xếp Môn Học
    public void loadCbbSapXepMon() {
        cbbSapxepMon.removeAllItems();
        cbbSapxepMon.addItem("Sắp xếp theo Mã");
        cbbSapxepMon.addItem("Sắp xếp theo Tên");
    }
    //Load ComBoBox Lop Trang Sinh Vien
    public void loadCbbLop(String skhoa) {
        cbbLop.removeAllItems();
        cbbLop.addItem("Chọn Lớp");
        for (Khoa stKhoa : qlkhoa.getLstKhoa()) {
            if (stKhoa.getMaKhoa().equals(skhoa)) {
                for (Lop lop : stKhoa.getDSLop().lstLop) {
                    cbbLop.addItem(lop.getTenLop());
                }
            }
        }
    }
    //Load ComBoBox Lop Trang Sinh Vien Không Có dữ Liệu
    public void loadCbbLopHollow() {
        cbbLop.removeAllItems();
        cbbLop.addItem("Chọn Lớp");
    }
    
     //Load ComBoBox MonHoc Trang DiemMOnHoc Không Có dữ Liệu
    public void loadCbbMonHocHollow() {
        cbbMonHocToDiemMH.removeAllItems();
        cbbMonHocToDiemMH.addItem("Chọn Môn Học");
    }
    
     //Load ComBoBox MonHoc Trang DiemMOnHoc Không Có dữ Liệu
    public void loadCbbSinhVienHollow() {
        cbbSinhVienToDiemMH.removeAllItems();
        cbbSinhVienToDiemMH.addItem("Chọn Sinh Viên");
    }
    //Load ComBoBox Khoa Trang Sinh Vien
    public void loadCbbKhoa() {
        cbbKhoa.removeAllItems();
        cbbKhoa.addItem("Chọn Khoa");
        for (Khoa khoa : qlkhoa.lstKhoa) {
            cbbKhoa.addItem(khoa.getTenKhoa());
        }
    }
    //Load Combobox Khoa Trang Lớp
    public void loadCbbKhoaToLop() {
        cbbKhoaToLop.removeAllItems();
        cbbKhoaToLop.addItem("Tất cả Khoa");
        for (Khoa khoa : qlkhoa.lstKhoa) {
            cbbKhoaToLop.addItem(khoa.getTenKhoa());
        }
    }
    
    //Load Combobox Khoa Trang MonHoc
    public void loadCbbKhoaToMon() {
        cbbKhoaToMonHoc.removeAllItems();
        cbbKhoaToMonHoc.addItem("Tất cả Khoa");
        for (Khoa khoa : qlkhoa.lstKhoa) {
            cbbKhoaToMonHoc.addItem(khoa.getTenKhoa());
        }
    }
    //Load Combobox Khoa Trang DiemMonHoc
    public void loadCbbKhoaToDMH() {
        cbbKhoaToDiemMH.removeAllItems();
        cbbKhoaToDiemMH.addItem("Chọn Khoa");
        for (Khoa khoa : qlkhoa.lstKhoa) {
            cbbKhoaToDiemMH.addItem(khoa.getTenKhoa());
        }
    }
    
    //Load Combobox MonHoc Trang DiemMOnHoc
    public void loadCbbMonHocToDMH(String sKhoa) {
        cbbMonHocToDiemMH.removeAllItems();
        cbbMonHocToDiemMH.addItem("Chọn Môn Học");
        for (Khoa stKhoa : qlkhoa.getLstKhoa()) {
            if (stKhoa.getMaKhoa().equals(sKhoa)) {
                for (MonHoc mh : stKhoa.getDsMonHoc().getLstMonHoc()) {
                    cbbMonHocToDiemMH.addItem(mh.getTenMon());
                }
            }
        }
    }
    //Load Combobox SinhVien Trang DiemMonHoc
    public void loadSVToDMH(String sKhoa){
        cbbSinhVienToDiemMH.removeAllItems();
        cbbSinhVienToDiemMH.addItem("Chọn Sinh Viên");
        for(SinhVien sv : qlsv.getLstSV()){
            if(sv.getKhoa().getMaKhoa().equals(sKhoa)){
                cbbSinhVienToDiemMH.addItem(sv.getTenSV());
            }
        }
    }
    
    //Lấy dữ liệu Field Sinh Vien
    public SinhVien GetFieldSinhVien() {
        SinhVien sv = new SinhVien();
        sv.setMaSV(txtMaSv.getText());
        sv.setTenSV(txtTenSV.getText());
        sv.setNamSinh(txtNamSinh.getText());
        sv.setKhoa(qlkhoa.findName(cbbKhoa.getSelectedItem().toString()));
        sv.setLop(sv.getKhoa().getDSLop().findName(cbbLop.getSelectedItem().toString()));
        sv.setDiaChi(txtDiaChi.getText());
        return sv;
    }
    //Lấy dữ liệu Field DiemMonHoc
    public DiemMonHoc GetFieldDiemMH() {
        DiemMonHoc dmh = new DiemMonHoc();
        
        dmh.setSinhVien(qlsv.findName(cbbSinhVienToDiemMH.getSelectedItem().toString()));
        dmh.setMonHoc(qlkhoa.find(dmh.getSinhVien().getKhoa().getMaKhoa()).getDsMonHoc().findName(cbbMonHocToDiemMH.getSelectedItem().toString()));
        dmh.setDiem(txtDiem.getText());
        return dmh;
    }
    //Lấy dữ liệu Field Lớp
    public Lop GetFieldLop() {
        Lop lop = new Lop();
        lop.setMaLop(txtMaLop.getText());
        lop.setTenLop(txtTenLop.getText());
        return lop;
    }
    
    //Lấy dữ liệu Field Môn Học
    public MonHoc GetFieldMon() {
        MonHoc mh = new MonHoc();
        mh.setMaMon(txtMaMon.getText());
        mh.setTenMon(txtTenMon.getText());
        return mh;
    }
    //Lấy dữ liệu Field Khoa
    public Khoa GetFieldKhoa() {
        Khoa khoa = new Khoa();
        khoa.setMaKhoa(txtMaKhoa.getText());
        khoa.setTenKhoa(txtTenKhoa.getText());
        return khoa;
    }
    //Load dữ liệu Table Trang Sinh Vien
    public void HienThiSV() {
        DefaultTableModel model = (DefaultTableModel) tblSinhVien.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (SinhVien sv : qlsv.getLstSV()) {
            model.addRow(new Object[]{stt, sv.getMaSV(), sv.getTenSV(), sv.getNamSinh(),
                sv.getLop().getTenLop(), sv.getKhoa().getTenKhoa(), sv.getDiaChi()});
            stt++;
        }
        txtTongSV.setText(String.valueOf(stt - 1));
    }
    //Load dữ liệu Table Trang Khoa
    public void HienThiKhoa() {
        DefaultTableModel model = (DefaultTableModel) tblKhoa.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            model.addRow(new Object[]{stt, khoa.getMaKhoa(), khoa.getTenKhoa()});
            stt++;
        }
        txtTongKhoa.setText(String.valueOf(stt - 1));
    }
    //Load dữ liệu Table Trang Lop
    public void HienThiLop() {
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            if (cbbKhoaToLop.getSelectedItem() == khoa.getTenKhoa()) {
                HienThiLopToKhoa(qlkhoa.findName(khoa.getTenKhoa()).getMaKhoa());
                return;
            }
        }
        DefaultTableModel model = (DefaultTableModel) tblLop.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            for (Lop lop : khoa.getDSLop().getLstLop()) {
                model.addRow(new Object[]{stt, lop.getMaLop(), lop.getTenLop()});
                stt++;
            }
        }
        txtTongLop.setText(String.valueOf(stt - 1));
    }
    //Load dữ liệu Table Trang MonHoc
    public void HienThiMonHoc() {
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            if (cbbKhoaToMonHoc.getSelectedItem() == khoa.getTenKhoa()) {
                HienThiMonToKhoa(qlkhoa.findName(khoa.getTenKhoa()).getMaKhoa());
                return;
            }
        }
        DefaultTableModel model = (DefaultTableModel) tblMonHoc.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            for (MonHoc mh : khoa.getDsMonHoc().getLstMonHoc()) {
                model.addRow(new Object[]{stt, mh.getMaMon(), mh.getTenMon()});
                stt++;
            }
        }
        txtTongMon.setText(String.valueOf(stt - 1));
    }
    /*
    * Hien thi Lop cho tung Khoa 
    * Trang Lớp
     */
    public void HienThiLopToKhoa(String sKhoa) {
        DefaultTableModel model = (DefaultTableModel) tblLop.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (Khoa stKhoa : qlkhoa.getLstKhoa()) {
            if (stKhoa.getMaKhoa().equals(sKhoa)) {
                for (Lop lop : stKhoa.getDSLop().lstLop) {
                    model.addRow(new Object[]{stt, lop.getMaLop(), lop.getTenLop()});
                    stt++;
                }
            }
        }
        txtTongLop.setText(String.valueOf(stt - 1));
    }
    /*
    * Hien thi MonHoc cho tung Khoa 
    * Trang Môn Học
     */
    public void HienThiMonToKhoa(String sKhoa) {
        DefaultTableModel model = (DefaultTableModel) tblMonHoc.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (Khoa stKhoa : qlkhoa.getLstKhoa()) {
            if (stKhoa.getMaKhoa().equals(sKhoa)) {
                for (MonHoc mh : stKhoa.getDsMonHoc().getLstMonHoc()) {
                    model.addRow(new Object[]{stt, mh.getMaMon(), mh.getTenMon()});
                    stt++;
                }
            }
        }
        txtTongMon.setText(String.valueOf(stt - 1));
    }
    
    //Hien Thi DiemMonHoc 
    public void HienThiDiemMonHoc(){
        DefaultTableModel model = (DefaultTableModel) tblDiemMonHoc.getModel();
        model.setRowCount(0);
        int stt = 1;
        for(DiemMonHoc dmh : qlDiemMH.getLstDiemMH()){
            model.addRow(new Object[]{stt, dmh.getSinhVien().getMaSV(), dmh.getSinhVien().getTenSV(),
            dmh.getSinhVien().getKhoa().getTenKhoa(), dmh.getMonHoc().getTenMon(), dmh.getDiem()});
            stt++;
        }
        txtTongDiemMH.setText(String.valueOf(stt-1));
    }
    //xoa cac text feild cua sinh vien
    public void xoaFieldSinhVien() {
        txtMaSv.setText("");
        txtTenSV.setText("");
        txtNamSinh.setText("");
        txtDiaChi.setText("");
        loadCbbKhoa();
        loadCbbLopHollow();
    }
    //xoa cac text feild cua khoa
    private void xoaFieldKhoa() {
        txtMaKhoa.setText("");
        txtTenKhoa.setText("");
    }
    //xoa cac text feild cua lop
    private void xoaFieldLop() {
        txtMaLop.setText("");
        txtTenLop.setText("");
    }
    
    //xoa cac text feild cua MonHoc
    private void xoaFieldMon() {
        txtMaMon.setText("");
        txtTenMon.setText("");
    }
    //Xoa Sinh Vien trong Table Trang SinhVien
    public void xoaSinhVien() {
        int index = tblSinhVien.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Muốn Xóa\nSinh Viên: " + String.valueOf(tblSinhVien.getValueAt(index, 2)));
        if (click == JOptionPane.YES_OPTION) {
            qlsv.delete(String.valueOf(tblSinhVien.getValueAt(index, 1)));
            setDiemMHtoDeteleSV(String.valueOf(tblSinhVien.getValueAt(index, 1)));
            xoaFieldSinhVien();
            HienThiSV();
        }
    }
    
    //Xoa DiemMonHoc trong Table Trang DiemMonHoc
    public void xoaDiemMonHoc() {
        int index = tblDiemMonHoc.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Muốn Xóa\nSinh Viên: " + String.valueOf(tblDiemMonHoc.getValueAt(index, 2)) + 
                        " | Môn Học: " + String.valueOf(tblDiemMonHoc.getValueAt(index, 4)));
        if (click == JOptionPane.YES_OPTION) {
            qlDiemMH.detele(String.valueOf(tblDiemMonHoc.getValueAt(index, 1)), String.valueOf(tblDiemMonHoc.getValueAt(index, 4)));
            HienThiDiemMonHoc();
        }
    }
    //Xoa Khoa trong Table Trang Khoa
    public void xoaKhoa() {
        int index = tblKhoa.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Muốn Xóa\nKhoa: " + String.valueOf(tblKhoa.getValueAt(index, 2)));
        if (click == JOptionPane.YES_OPTION) {
            qlkhoa.delete(String.valueOf(tblKhoa.getValueAt(index, 1)));
            xoaFieldKhoa();
            HienThiKhoa();
        }
    }
    //Xoa Lop trong Table Trang Lop
    public void xoaLop() {
        int index = tblLop.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Chắc Chắn Muốn Xóa\nLớp: " + String.valueOf(tblLop.getValueAt(index, 2)));
        if (click == JOptionPane.YES_OPTION) {
            for (Khoa khoa : qlkhoa.getLstKhoa()) {
                for (Lop lop : khoa.getDSLop().getLstLop()) {
                    if (lop.getMaLop().equals(String.valueOf(tblLop.getValueAt(index, 1)))) {
                        khoa.getDSLop().getLstLop().remove(lop);
                        xoaFieldLop();
                        HienThiLop();
                        return;
                    }
                }
            }
        }
    }
    //Xoa MOnHoc trong Table Trang MonHoc
    public void xoaMon() {
        int index = tblMonHoc.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Chắc Chắn Muốn Xóa\nMôn Học: " + String.valueOf(tblMonHoc.getValueAt(index, 2)));
        if (click == JOptionPane.YES_OPTION) {
            for (Khoa khoa : qlkhoa.getLstKhoa()) {
                for (MonHoc mh : khoa.getDsMonHoc().getLstMonHoc()) {
                    if (mh.getMaMon().equals(String.valueOf(tblMonHoc.getValueAt(index, 1)))) {
                        khoa.getDsMonHoc().lstMonHoc.remove(mh);
                        setDiemMHtoMonHoc(mh.getMaMon());
                        xoaFieldMon();
                        HienThiMonHoc();
                        return;
                    }
                }
            }
        }
    }
    //Upload Sinh Vien trong Table Trang SinhVien
    public void upLoadSinhVien(SinhVien sv) {
        int index = tblSinhVien.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Muốn Sửa\nSinh Viên: " + String.valueOf(tblSinhVien.getValueAt(index, 1)));
        if (click == JOptionPane.YES_OPTION) {
            qlsv.update(String.valueOf(tblSinhVien.getValueAt(index, 1)), sv);
            HienThiSV();
        }
    }
    //Upload Trang Khoa
    public void upLoadKhoa(Khoa khoa) {
        int index = tblKhoa.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Muốn Sửa\nKhoa: " + String.valueOf(tblKhoa.getValueAt(index, 1)));
        if (click == JOptionPane.YES_OPTION) {
            qlkhoa.update(String.valueOf(tblKhoa.getValueAt(index, 1)), khoa);
            HienThiKhoa();
        }
    }
    
    //Upload Trang DiemMonHoc
    public void upLoadDiemMH(DiemMonHoc dmh) {
        int index = tblDiemMonHoc.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Muốn Sửa\nSinh Viên: " + String.valueOf(tblDiemMonHoc.getValueAt(index, 2)) + 
                        " | Môn Học: " + String.valueOf(tblDiemMonHoc.getValueAt(index, 4)));
        if (click == JOptionPane.YES_OPTION) {
            qlDiemMH.upload(String.valueOf(tblDiemMonHoc.getValueAt(index, 1)), String.valueOf(tblDiemMonHoc.getValueAt(index, 4)), dmh);
            HienThiDiemMonHoc();
        }
    }
    //Sửa Lop trong Table Trang Lop
    public void upLoadLop(Lop newLop) {
        int index = tblLop.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Muốn Sửa\nLớp: " + String.valueOf(tblLop.getValueAt(index, 2)));
        if (click == JOptionPane.YES_OPTION) {
            for (Khoa khoa : qlkhoa.getLstKhoa()) {
                for (Lop lop : khoa.getDSLop().getLstLop()) {
                    if (lop.getMaLop().equals(String.valueOf(tblLop.getValueAt(index, 1)))) {
                        lop.setMaLop(newLop.getMaLop());
                        lop.setTenLop(newLop.getTenLop());
                        HienThiLop();
                        return;
                    }
                }
            }
        }
    }
    //Sửa MonHoc trong Table Trang MonHoc
    public void upLoadMonHoc(MonHoc newMonHoc) {
        int index = tblMonHoc.getSelectedRow();
        int click = JOptionPane.showConfirmDialog(null,
                "Bạn Có Muốn Sửa\nMôn Học: " + String.valueOf(tblMonHoc.getValueAt(index, 2)));
        if (click == JOptionPane.YES_OPTION) {
            for (Khoa khoa : qlkhoa.getLstKhoa()) {
                for (MonHoc mh : khoa.getDsMonHoc().getLstMonHoc()) {
                    if (mh.getMaMon().equals(String.valueOf(tblMonHoc.getValueAt(index, 1)))) {
                        mh.setMaMon(newMonHoc.getMaMon());
                        mh.setTenMon(newMonHoc.getTenMon());
                        HienThiMonHoc();
                        return;
                    }
                }
            }
        }
    }
    //Kiểm tra Mã Sinh Viên
    public boolean ktraMaSV(String sMa) {
        for (SinhVien sv : qlsv.getLstSV()) {
            if (sv.getMaSV().equals(sMa)) {
                return false;
            }
        }
        return true;
    }
    //Kiểm tra Mã Khoa
    public boolean ktraMaKhoa(String sMa) {
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            if (khoa.getMaKhoa().equals(sMa)) {
                return false;
            }
        }
        return true;
    }
    //Kiểm tra Tên Khoa
    public boolean ktraTenKhoa(String sMa) {
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            if (khoa.getTenKhoa().equals(sMa)) {
                return false;
            }
        }
        return true;
    }
    //Kiểm tra Mã Lớp
    public boolean ktraMaLop(String sMa) {
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            for (Lop lop : khoa.getDSLop().getLstLop()) {
                if (lop.getMaLop().equals(sMa)) {
                    return false;
                }
            }
        }
        return true;
    }
    //Kiểm tra Tên Lớp
    public boolean ktraTenLop(String sMa) {
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            for (Lop lop : khoa.getDSLop().getLstLop()) {
                if (lop.getTenLop().equals(sMa)) {
                    return false;
                }
            }
        }
        return true;
    }
    //Kiểm tra Mã Môn Học
    public boolean ktraMaMon(String sMa) {
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            for (MonHoc mh : khoa.getDsMonHoc().getLstMonHoc()) {
                if (mh.getMaMon().equals(sMa)) {
                    return false;
                }
            }
        }
        return true;
    }
    //Kiểm tra Diem Mon Hoc
    public boolean ktraDiemMonHoc(DiemMonHoc dmh) {
        for (DiemMonHoc diemMH : qlDiemMH.getLstDiemMH()) {
            if(diemMH.getSinhVien().getMaSV().equals(dmh.getSinhVien().getMaSV()) && 
                    diemMH.getMonHoc().getMaMon().equals(dmh.getMonHoc().getMaMon())){
                return false;
            }
        }
        return true;
    }
    //Kiểm tra Tên Môn Học
    public boolean ktraTenMon(String sMa) {
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            for (MonHoc mh : khoa.getDsMonHoc().getLstMonHoc()) {
                if (mh.getTenMon().equals(sMa)) {
                    return false;
                }
            }
        }
        return true;
    }
    //Kiểm tra Field SinhVien
    public boolean kiemTraThongTinSV() {
        if (txtMaSv.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Mã Sinh Viên", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (txtTenSV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Tên Sinh Viên", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (txtNamSinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Năm Sinh", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (txtDiaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Địa Chỉ", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (cbbKhoa.getSelectedItem() == "Chọn Khoa") {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Khoa", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (cbbLop.getSelectedItem() == "Chọn Lớp") {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Lớp", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    //Kiểm tra Field DiemMonHoc
    public boolean kiemTraThongTinDMH() {
        if (cbbKhoaToDiemMH.getSelectedItem() == "Chọn Khoa") {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Khoa", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (cbbMonHocToDiemMH.getSelectedItem() == "Chọn Môn Học") {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Môn Học", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if (cbbSinhVienToDiemMH.getSelectedItem() == "Chọn Sinh Viên") {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Sinh Viên", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if (txtDiem.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Điểm", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    //Kiểm tra Field Khoa
    public boolean kiemTraThongTinKhoa() {
        if (txtMaKhoa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Mã Khoa", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (txtTenKhoa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Tên Khoa", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    //Kiểm tra Field Lớp
    public boolean kiemTraThongTinLop() {
        if (txtMaLop.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Mã Lớp", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (txtTenLop.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Tên Lớp", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    //Kiểm tra Field MonHoc
    public boolean kiemTraThongTinMon() {
        if (txtMaMon.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Mã Môn", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (txtTenMon.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Tên Môn", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    //Kiểm tra Field Đổi Mật Khẩu
    public boolean kiemTraThongTinDMK() {
        String s = Login.getUserLogin.getMatKhau().toString();
        if (txtmkcu.getText().equals(s)) {
            if (txtmkmoi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mật Khẩu không được để trống!", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
                return false;
            } else if (txtmkmoi.getText().equals(txtmkmoiv2.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Mật Khẩu không trùng khớp", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    //Thay Sinh Viên khi Upload Khoa
    public void setSinhVientoKhoa(String sMa, Khoa khoa){
        for(SinhVien sv : qlsv.getLstSV()){
            if(sv.getKhoa().getMaKhoa().equals(sMa)){
                sv.setKhoa(khoa);
            }
        }
    }
    
    //Thay Sinh Viên khi Upload Lớp
    public void setSinhVientoLop(String sMa, Lop lop){
        for(SinhVien sv : qlsv.getLstSV()){
            if(sv.getLop().getMaLop().equals(sMa)){
                sv.setLop(lop);
            }
        }
    }
    //thay đỏi Điểm môn học khi upload Sinh Viên
    public void setDiemMHtoSV(String sMa){
        ListDiemMonHoc qldmh = new ListDiemMonHoc();
        for(DiemMonHoc dmh : qlDiemMH.getLstDiemMH()){
            if(dmh.getSinhVien().getMaSV().equals(sMa)){
                
            }else{
                qldmh.add(dmh);
            }
        }
        qlDiemMH = qldmh;
    }
    
    //thay đỏi Điểm môn học khi Xóa Sinh Viên
    public void setDiemMHtoDeteleSV(String sMa){
        ListDiemMonHoc qldmh = new ListDiemMonHoc();
        for(DiemMonHoc dmh : qlDiemMH.getLstDiemMH()){
            if(dmh.getSinhVien().getMaSV().equals(sMa)){
                
            }else{
                qldmh.add(dmh);
            }
        }
        qlDiemMH = qldmh;
    }
    
    //Thay đổi Điểm Môn Học khi xóa Môn Học
    public void setDiemMHtoMonHoc(String sMa){
        ListDiemMonHoc qldmh = new ListDiemMonHoc();
        for(DiemMonHoc dmh : qlDiemMH.getLstDiemMH()){
            if(dmh.getMonHoc().getMaMon().equals(sMa)){
                
            }else{
                qldmh.add(dmh);
            }
        }
        qlDiemMH = qldmh;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Page = new javax.swing.JPanel();
        Lop = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        txtTongLop = new javax.swing.JTextField();
        txtTenLop = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLop = new javax.swing.JTable();
        btnaddLop = new javax.swing.JButton();
        btndeteleLop = new javax.swing.JButton();
        btnuploadLop = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSaveLop = new javax.swing.JButton();
        btnTimKiemLop = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbbSapxepLop = new javax.swing.JComboBox<String>();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbKhoaToLop = new javax.swing.JComboBox<String>();
        TrangChu = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        SinhVien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSv = new javax.swing.JTextField();
        txtTenSV = new javax.swing.JTextField();
        txtNamSinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        cbbKhoa = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbLop = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        btnaddSV = new javax.swing.JButton();
        btndeteleSV = new javax.swing.JButton();
        btnuploadSV = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTongSV = new javax.swing.JTextField();
        cbbSapxepSV = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        btnTimKiemSV = new javax.swing.JButton();
        btnSaveSV = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Khoa = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtMaKhoa = new javax.swing.JTextField();
        txtTongKhoa = new javax.swing.JTextField();
        txtTenKhoa = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblKhoa = new javax.swing.JTable();
        btnaddKhoa = new javax.swing.JButton();
        btndeteleKhoa = new javax.swing.JButton();
        btnuploadKhoa = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnSaveKhoa = new javax.swing.JButton();
        btnTimKiemKhoa = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cbbSapxepKhoa = new javax.swing.JComboBox<String>();
        jLabel24 = new javax.swing.JLabel();
        DMK = new javax.swing.JPanel();
        btnuploadpass = new javax.swing.JButton();
        btnThoatDMK = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtmkcu = new javax.swing.JPasswordField();
        txtmkmoi = new javax.swing.JPasswordField();
        txtmkmoiv2 = new javax.swing.JPasswordField();
        ThongTin = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        MonHoc = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        txtTongMon = new javax.swing.JTextField();
        txtTenMon = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMonHoc = new javax.swing.JTable();
        btnaddMon = new javax.swing.JButton();
        btndeteleMon = new javax.swing.JButton();
        btnuploadMon = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnSaveMon = new javax.swing.JButton();
        btnTimKiemMon = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cbbSapxepMon = new javax.swing.JComboBox<String>();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        cbbKhoaToMonHoc = new javax.swing.JComboBox<String>();
        DiemMonHoc = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtTongDiemMH = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDiemMonHoc = new javax.swing.JTable();
        btnaddDiemMH = new javax.swing.JButton();
        btndeteleDiemMH = new javax.swing.JButton();
        btnuploadDiemMH = new javax.swing.JButton();
        btnThoatDiemMH = new javax.swing.JButton();
        btnSaveDiemMH = new javax.swing.JButton();
        btnTimKiemDiemMH = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cbbSinhVienToDiemMH = new javax.swing.JComboBox<String>();
        jLabel46 = new javax.swing.JLabel();
        cbbKhoaToDiemMH = new javax.swing.JComboBox<String>();
        jLabel47 = new javax.swing.JLabel();
        cbbMonHocToDiemMH = new javax.swing.JComboBox<String>();
        jLabel48 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        Menu = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JButton();
        btnSV = new javax.swing.JButton();
        btnKhoa = new javax.swing.JButton();
        btnLop = new javax.swing.JButton();
        btnsetpass = new javax.swing.JButton();
        btndangxuat = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnMonHoc = new javax.swing.JButton();
        btnDiemMH = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chương Trình Quản Lý Sinh Viên");
        setBackground(new java.awt.Color(251, 251, 251));
        setBounds(new java.awt.Rectangle(500, 200, 925, 500));
        setForeground(new java.awt.Color(251, 251, 251));
        setMinimumSize(new java.awt.Dimension(925, 500));

        Page.setBackground(new java.awt.Color(251, 251, 251));
        Page.setLayout(new java.awt.CardLayout());

        Lop.setPreferredSize(new java.awt.Dimension(767, 500));

        jLabel15.setText("Tổng Số Lớp: ");

        txtMaLop.setBackground(new java.awt.Color(204, 255, 255));

        txtTongLop.setBackground(new java.awt.Color(0, 255, 153));

        txtTenLop.setBackground(new java.awt.Color(204, 255, 255));

        tblLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Lớp", "Tên Lớp"
            }
        ));
        tblLop.setMaximumSize(null);
        tblLop.setRequestFocusEnabled(false);
        tblLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLop);
        if (tblLop.getColumnModel().getColumnCount() > 0) {
            tblLop.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnaddLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_add.png"))); // NOI18N
        btnaddLop.setText("Thêm");
        btnaddLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddLopActionPerformed(evt);
            }
        });

        btndeteleLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_delete.png"))); // NOI18N
        btndeteleLop.setText("Xóa");
        btndeteleLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeteleLopActionPerformed(evt);
            }
        });

        btnuploadLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_edit.png"))); // NOI18N
        btnuploadLop.setText("Sửa");
        btnuploadLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadLopActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnSaveLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSaveLop.setText("Lưu");
        btnSaveLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveLopActionPerformed(evt);
            }
        });

        btnTimKiemLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnTimKiemLop.setText("Tìm kiếm");
        btnTimKiemLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemLopActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Quản Lý Lớp");

        jLabel17.setText("Sắp xếp theo:");

        jLabel18.setText("Mã Lớp:");

        cbbSapxepLop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSapxepLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapxepLopActionPerformed(evt);
            }
        });

        jLabel19.setText("Tên Lớp:");

        jLabel10.setText("Khoa:");

        cbbKhoaToLop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhoaToLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhoaToLopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LopLayout = new javax.swing.GroupLayout(Lop);
        Lop.setLayout(LopLayout);
        LopLayout.setHorizontalGroup(
            LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LopLayout.createSequentialGroup()
                .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(LopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LopLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 339, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LopLayout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(LopLayout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(17, 17, 17)))
                            .addGroup(LopLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(30, 30, 30)))
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbKhoaToLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTimKiemLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnaddLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSaveLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnuploadLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btndeteleLop, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LopLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongLop, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSapxepLop, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        LopLayout.setVerticalGroup(
            LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(80, 80, 80)
                .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LopLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbKhoaToLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(LopLayout.createSequentialGroup()
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnaddLop)
                            .addComponent(btndeteleLop))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnuploadLop)
                            .addComponent(btnTimKiemLop))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(btnSaveLop))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(LopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTongLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSapxepLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Page.add(Lop, "card3");

        TrangChu.setPreferredSize(new java.awt.Dimension(767, 500));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quan-ly-phan-mem.jpg"))); // NOI18N

        javax.swing.GroupLayout TrangChuLayout = new javax.swing.GroupLayout(TrangChu);
        TrangChu.setLayout(TrangChuLayout);
        TrangChuLayout.setHorizontalGroup(
            TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangChuLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TrangChuLayout.setVerticalGroup(
            TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Page.add(TrangChu, "card4");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setText("Mã Sinh Viên: ");

        jLabel3.setText("Tên Sinh Viên:");

        jLabel4.setText("Năm Sinh:");

        jLabel5.setText("Địa Chỉ:");

        txtMaSv.setBackground(new java.awt.Color(204, 255, 255));

        txtTenSV.setBackground(new java.awt.Color(204, 255, 255));

        txtNamSinh.setBackground(new java.awt.Color(204, 255, 255));

        txtDiaChi.setBackground(new java.awt.Color(204, 255, 255));

        cbbKhoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKhoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbKhoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbbKhoaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbKhoaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbKhoaMouseReleased(evt);
            }
        });
        cbbKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhoaActionPerformed(evt);
            }
        });

        jLabel6.setText("Khoa:");

        jLabel7.setText("Lớp:");

        cbbLop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLopActionPerformed(evt);
            }
        });

        tblSinhVien.setBackground(new java.awt.Color(240, 240, 240));
        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Năm Sinh", "Lớp", "Khoa", "Địa Chỉ"
            }
        ));
        tblSinhVien.setMaximumSize(null);
        tblSinhVien.setRequestFocusEnabled(false);
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);
        if (tblSinhVien.getColumnModel().getColumnCount() > 0) {
            tblSinhVien.getColumnModel().getColumn(0).setMaxWidth(50);
            tblSinhVien.getColumnModel().getColumn(3).setMaxWidth(100);
            tblSinhVien.getColumnModel().getColumn(3).setHeaderValue("Năm Sinh");
            tblSinhVien.getColumnModel().getColumn(4).setMaxWidth(100);
            tblSinhVien.getColumnModel().getColumn(4).setHeaderValue("Lớp");
            tblSinhVien.getColumnModel().getColumn(5).setMaxWidth(100);
            tblSinhVien.getColumnModel().getColumn(5).setHeaderValue("Khoa");
            tblSinhVien.getColumnModel().getColumn(6).setMaxWidth(150);
            tblSinhVien.getColumnModel().getColumn(6).setHeaderValue("Địa Chỉ");
        }

        btnaddSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_add.png"))); // NOI18N
        btnaddSV.setText("Thêm");
        btnaddSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddSVActionPerformed(evt);
            }
        });

        btndeteleSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_delete.png"))); // NOI18N
        btndeteleSV.setText("Xóa");
        btndeteleSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeteleSVActionPerformed(evt);
            }
        });

        btnuploadSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_edit.png"))); // NOI18N
        btnuploadSV.setText("Sửa");
        btnuploadSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadSVActionPerformed(evt);
            }
        });

        jLabel8.setText("Tổng Số Sinh Viên: ");

        txtTongSV.setBackground(new java.awt.Color(0, 255, 153));

        cbbSapxepSV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSapxepSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapxepSVActionPerformed(evt);
            }
        });

        jLabel9.setText("Sắp xếp theo:");

        btnTimKiemSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnTimKiemSV.setText("Tìm kiếm");
        btnTimKiemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSVActionPerformed(evt);
            }
        });

        btnSaveSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSaveSV.setText("Lưu");
        btnSaveSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSVActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SinhVienLayout = new javax.swing.GroupLayout(SinhVien);
        SinhVien.setLayout(SinhVienLayout);
        SinhVienLayout.setHorizontalGroup(
            SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SinhVienLayout.createSequentialGroup()
                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(SinhVienLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTongSV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(523, 523, 523))
                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SinhVienLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SinhVienLayout.createSequentialGroup()
                                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtNamSinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                            .addComponent(txtDiaChi)
                                            .addComponent(txtTenSV, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGroup(SinhVienLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SinhVienLayout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbSapxepSV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SinhVienLayout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbLop, 0, 190, Short.MAX_VALUE)
                                            .addComponent(cbbKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(SinhVienLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnaddSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnTimKiemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btndeteleSV, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                            .addComponent(btnSaveSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnuploadSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1)))))
                            .addGroup(SinhVienLayout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(jLabel1))))
                    .addGroup(SinhVienLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        SinhVienLayout.setVerticalGroup(
            SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SinhVienLayout.createSequentialGroup()
                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SinhVienLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnuploadSV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(SinhVienLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SinhVienLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SinhVienLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnaddSV)
                                    .addComponent(btndeteleSV))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTimKiemSV)
                                    .addComponent(btnSaveSV))))))
                .addGap(18, 18, 18)
                .addGroup(SinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTongSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSapxepSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        Page.add(SinhVien, "card2");

        Khoa.setPreferredSize(new java.awt.Dimension(767, 500));

        jLabel20.setText("Tổng Số Khoa: ");

        txtMaKhoa.setBackground(new java.awt.Color(204, 255, 255));

        txtTongKhoa.setBackground(new java.awt.Color(0, 255, 153));

        txtTenKhoa.setBackground(new java.awt.Color(204, 255, 255));

        tblKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Khoa", "Tên Khoa"
            }
        ));
        tblKhoa.setMaximumSize(null);
        tblKhoa.setName(""); // NOI18N
        tblKhoa.setRequestFocusEnabled(false);
        tblKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblKhoa);
        if (tblKhoa.getColumnModel().getColumnCount() > 0) {
            tblKhoa.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnaddKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_add.png"))); // NOI18N
        btnaddKhoa.setText("Thêm");
        btnaddKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddKhoaActionPerformed(evt);
            }
        });

        btndeteleKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_delete.png"))); // NOI18N
        btndeteleKhoa.setText("Xóa");
        btndeteleKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeteleKhoaActionPerformed(evt);
            }
        });

        btnuploadKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_edit.png"))); // NOI18N
        btnuploadKhoa.setText("Sửa");
        btnuploadKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadKhoaActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jButton4.setText("Thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnSaveKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSaveKhoa.setText("Lưu");
        btnSaveKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveKhoaActionPerformed(evt);
            }
        });

        btnTimKiemKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnTimKiemKhoa.setText("Tìm kiếm");
        btnTimKiemKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKhoaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Quản Lý Khoa");

        jLabel22.setText("Sắp xếp theo:");

        jLabel23.setText("Mã Khoa:");

        cbbSapxepKhoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSapxepKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapxepKhoaActionPerformed(evt);
            }
        });

        jLabel24.setText("Tên Khoa:");

        javax.swing.GroupLayout KhoaLayout = new javax.swing.GroupLayout(Khoa);
        Khoa.setLayout(KhoaLayout);
        KhoaLayout.setHorizontalGroup(
            KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhoaLayout.createSequentialGroup()
                .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(KhoaLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KhoaLayout.createSequentialGroup()
                        .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KhoaLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23))
                                .addGap(26, 26, 26)
                                .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(KhoaLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KhoaLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnTimKiemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnaddKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSaveKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnuploadKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btndeteleKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhoaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(cbbSapxepKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(KhoaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        KhoaLayout.setVerticalGroup(
            KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(46, 46, 46)
                .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhoaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTongKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSapxepKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(KhoaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnaddKhoa)
                            .addComponent(btndeteleKhoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnuploadKhoa)
                            .addComponent(btnTimKiemKhoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(KhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(btnSaveKhoa))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        Page.add(Khoa, "card3");

        DMK.setPreferredSize(new java.awt.Dimension(731, 426));

        btnuploadpass.setText("Cập Nhật");
        btnuploadpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadpassActionPerformed(evt);
            }
        });

        btnThoatDMK.setText("Thoát");
        btnThoatDMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatDMKActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Đổi Mật Khẩu");

        jLabel28.setText("Nhập Password Cũ: ");

        jLabel29.setText("Nhập Password Mới:");

        jLabel30.setText("Nhập lại Password:");

        javax.swing.GroupLayout DMKLayout = new javax.swing.GroupLayout(DMK);
        DMK.setLayout(DMKLayout);
        DMKLayout.setHorizontalGroup(
            DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DMKLayout.createSequentialGroup()
                .addGroup(DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DMKLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel28))
                        .addGap(23, 23, 23)
                        .addGroup(DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmkcu)
                            .addComponent(txtmkmoi)
                            .addComponent(txtmkmoiv2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                    .addGroup(DMKLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DMKLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnuploadpass, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThoatDMK, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        DMKLayout.setVerticalGroup(
            DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DMKLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel26)
                .addGap(63, 63, 63)
                .addGroup(DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtmkcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtmkmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtmkmoiv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(DMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnuploadpass)
                    .addComponent(btnThoatDMK))
                .addContainerGap())
        );

        Page.add(DMK, "card3");

        ThongTin.setPreferredSize(new java.awt.Dimension(767, 500));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel14.setText("THÔNG TIN PHẦN MỀM");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel13.setText("Chương trình quản lý Sinh Viên");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Chức năng: Quản lý Sinh Viên, quản lý Khoa, quản lý Lớp");

        jLabel27.setText("Phần mềm được viết bởi Nhóm 9");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Chủ sản phẩm: Nhóm 9");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Các thành viên tham gia:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Lê Quốc Hòa");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("Huỳnh Đỗ Vương");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setText("Nguyễn Thị Tâm Như");

        javax.swing.GroupLayout ThongTinLayout = new javax.swing.GroupLayout(ThongTin);
        ThongTin.setLayout(ThongTinLayout);
        ThongTinLayout.setHorizontalGroup(
            ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinLayout.createSequentialGroup()
                .addGroup(ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongTinLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel14))
                    .addGroup(ThongTinLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel25))
                    .addGroup(ThongTinLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel31))
                    .addGroup(ThongTinLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addGroup(ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ThongTinLayout.createSequentialGroup()
                .addGroup(ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongTinLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel13))
                    .addGroup(ThongTinLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel27)))
                .addGap(0, 117, Short.MAX_VALUE))
        );
        ThongTinLayout.setVerticalGroup(
            ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(33, 33, 33)
                .addComponent(jLabel25)
                .addGap(31, 31, 31)
                .addComponent(jLabel31)
                .addGap(30, 30, 30)
                .addGroup(ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(40, 40, 40))
        );

        Page.add(ThongTin, "card4");

        MonHoc.setPreferredSize(new java.awt.Dimension(767, 500));

        jLabel37.setText("Tổng Số Môn: ");

        txtMaMon.setBackground(new java.awt.Color(204, 255, 255));

        txtTongMon.setBackground(new java.awt.Color(0, 255, 153));

        txtTenMon.setBackground(new java.awt.Color(204, 255, 255));

        tblMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Môn Học", "Tên Môn Học"
            }
        ));
        tblMonHoc.setMaximumSize(null);
        tblMonHoc.setRequestFocusEnabled(false);
        tblMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonHocMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblMonHoc);
        if (tblMonHoc.getColumnModel().getColumnCount() > 0) {
            tblMonHoc.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnaddMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_add.png"))); // NOI18N
        btnaddMon.setText("Thêm");
        btnaddMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddMonActionPerformed(evt);
            }
        });

        btndeteleMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_delete.png"))); // NOI18N
        btndeteleMon.setText("Xóa");
        btndeteleMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeteleMonActionPerformed(evt);
            }
        });

        btnuploadMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_edit.png"))); // NOI18N
        btnuploadMon.setText("Sửa");
        btnuploadMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadMonActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jButton5.setText("Thoát");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnSaveMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSaveMon.setText("Lưu");
        btnSaveMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMonActionPerformed(evt);
            }
        });

        btnTimKiemMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnTimKiemMon.setText("Tìm kiếm");
        btnTimKiemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemMonActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("Quản Lý Môn Học");

        jLabel39.setText("Sắp xếp theo:");

        jLabel40.setText("Mã Môn Học:");

        cbbSapxepMon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSapxepMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapxepMonActionPerformed(evt);
            }
        });

        jLabel41.setText("Tên Môn Học:");

        jLabel42.setText("Khoa:");

        cbbKhoaToMonHoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhoaToMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhoaToMonHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MonHocLayout = new javax.swing.GroupLayout(MonHoc);
        MonHoc.setLayout(MonHocLayout);
        MonHocLayout.setHorizontalGroup(
            MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MonHocLayout.createSequentialGroup()
                .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MonHocLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MonHocLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MonHocLayout.createSequentialGroup()
                                    .addComponent(jLabel41)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(MonHocLayout.createSequentialGroup()
                                    .addComponent(jLabel40)
                                    .addGap(17, 17, 17)))
                            .addGroup(MonHocLayout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(30, 30, 30)))
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbKhoaToMonHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaMon, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTimKiemMon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnaddMon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSaveMon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnuploadMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btndeteleMon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MonHocLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongMon, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSapxepMon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MonHocLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel38)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MonHocLayout.setVerticalGroup(
            MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGap(80, 80, 80)
                .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MonHocLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbKhoaToMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MonHocLayout.createSequentialGroup()
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnaddMon)
                            .addComponent(btndeteleMon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnuploadMon)
                            .addComponent(btnTimKiemMon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(btnSaveMon))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(MonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtTongMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSapxepMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Page.add(MonHoc, "card3");

        DiemMonHoc.setPreferredSize(new java.awt.Dimension(767, 500));

        jLabel43.setText("Tổng Số: ");

        txtTongDiemMH.setBackground(new java.awt.Color(0, 255, 153));

        tblDiemMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sinh Viên", "Tên Sinh Viên", "Khoa", "Môn Học", "Điểm"
            }
        ));
        tblDiemMonHoc.setMaximumSize(null);
        tblDiemMonHoc.setRequestFocusEnabled(false);
        tblDiemMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemMonHocMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblDiemMonHoc);
        if (tblDiemMonHoc.getColumnModel().getColumnCount() > 0) {
            tblDiemMonHoc.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnaddDiemMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_add.png"))); // NOI18N
        btnaddDiemMH.setText("Thêm");
        btnaddDiemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddDiemMHActionPerformed(evt);
            }
        });

        btndeteleDiemMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_delete.png"))); // NOI18N
        btndeteleDiemMH.setText("Xóa");
        btndeteleDiemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeteleDiemMHActionPerformed(evt);
            }
        });

        btnuploadDiemMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_edit.png"))); // NOI18N
        btnuploadDiemMH.setText("Sửa");
        btnuploadDiemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadDiemMHActionPerformed(evt);
            }
        });

        btnThoatDiemMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btnThoatDiemMH.setText("Thoát");
        btnThoatDiemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatDiemMHActionPerformed(evt);
            }
        });

        btnSaveDiemMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSaveDiemMH.setText("Lưu");
        btnSaveDiemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDiemMHActionPerformed(evt);
            }
        });

        btnTimKiemDiemMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnTimKiemDiemMH.setText("Tìm kiếm");
        btnTimKiemDiemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDiemMHActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("Quản Lý Điểm Môn Học");

        jLabel36.setText("Sinh Viên: ");

        cbbSinhVienToDiemMH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel46.setText("Khoa:");

        cbbKhoaToDiemMH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhoaToDiemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhoaToDiemMHActionPerformed(evt);
            }
        });

        jLabel47.setText("Môn Học:");

        cbbMonHocToDiemMH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel48.setText("Điểm:");

        javax.swing.GroupLayout DiemMonHocLayout = new javax.swing.GroupLayout(DiemMonHoc);
        DiemMonHoc.setLayout(DiemMonHocLayout);
        DiemMonHocLayout.setHorizontalGroup(
            DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiemMonHocLayout.createSequentialGroup()
                .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DiemMonHocLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel44)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DiemMonHocLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DiemMonHocLayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(DiemMonHocLayout.createSequentialGroup()
                .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DiemMonHocLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnaddDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndeteleDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnuploadDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DiemMonHocLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47))
                        .addGap(21, 21, 21)
                        .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMonHocToDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKhoaToDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DiemMonHocLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiemDiemMH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSaveDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThoatDiemMH))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DiemMonHocLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbSinhVienToDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );
        DiemMonHocLayout.setVerticalGroup(
            DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiemMonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addGap(41, 41, 41)
                .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(cbbSinhVienToDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(cbbKhoaToDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(cbbMonHocToDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaddDiemMH)
                    .addComponent(btndeteleDiemMH)
                    .addComponent(btnuploadDiemMH)
                    .addComponent(btnTimKiemDiemMH)
                    .addComponent(btnSaveDiemMH)
                    .addComponent(btnThoatDiemMH))
                .addGap(29, 29, 29)
                .addGroup(DiemMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtTongDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Page.add(DiemMonHoc, "card3");

        Menu.setToolTipText("");

        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        btnTrangChu.setText("Trang Chủ");
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/student.png"))); // NOI18N
        btnSV.setText("Sinh Viên");
        btnSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSVActionPerformed(evt);
            }
        });

        btnKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/khoa.png"))); // NOI18N
        btnKhoa.setText("Khoa");
        btnKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaActionPerformed(evt);
            }
        });

        btnLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lop.png"))); // NOI18N
        btnLop.setText("Lớp");
        btnLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLopActionPerformed(evt);
            }
        });

        btnsetpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/setting.png"))); // NOI18N
        btnsetpass.setText("Đổi mật khẩu");
        btnsetpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsetpassActionPerformed(evt);
            }
        });

        btndangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btndangxuat.setText("Đăng xuất");
        btndangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangxuatActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        btnMonHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MonHoc.png"))); // NOI18N
        btnMonHoc.setText("Môn Học");
        btnMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonHocActionPerformed(evt);
            }
        });

        btnDiemMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DiemMH.png"))); // NOI18N
        btnDiemMH.setText("Điểm Môn Học");
        btnDiemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemMHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btndangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnsetpass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDiemMH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLop, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDiemMH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsetpass, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Page, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Page, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndeteleSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeteleSVActionPerformed
        // TODO add your handling code here:
        xoaSinhVien();
    }//GEN-LAST:event_btndeteleSVActionPerformed

    private void btndeteleLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeteleLopActionPerformed
        // TODO add your handling code here:
        xoaLop();
    }//GEN-LAST:event_btndeteleLopActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(TrangChu);
        Page.repaint();
        Page.revalidate();
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSVActionPerformed
        // TODO add your handling code here:
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(SinhVien);
        Page.repaint();
        Page.revalidate();
        xoaFieldSinhVien();
        loadCbbSapXepSV();
        loadCbbKhoa();
        loadCbbLopHollow();
    }//GEN-LAST:event_btnSVActionPerformed

    private void btnKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaActionPerformed
        // TODO add your handling code here:
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(Khoa);
        Page.repaint();
        Page.revalidate();
        xoaFieldKhoa();
        loadCbbSapXepKhoa();
    }//GEN-LAST:event_btnKhoaActionPerformed

    private void btnLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLopActionPerformed
        // TODO add your handling code here:
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(Lop);
        Page.repaint();
        Page.revalidate();
        xoaFieldLop();
        loadCbbKhoaToLop();
        loadCbbSapXepLop();
        

    }//GEN-LAST:event_btnLopActionPerformed

    private void btndeteleKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeteleKhoaActionPerformed
        // TODO add your handling code here:
        xoaKhoa();
    }//GEN-LAST:event_btndeteleKhoaActionPerformed

    private void cbbKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhoaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhoaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int click = JOptionPane.showConfirmDialog(null,
                    "Bạn Có Muốn Đăng Xuất");
            if (click == JOptionPane.YES_OPTION) {
                this.dispose();

                Login frmLogin = new Login();
                frmLogin.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbKhoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhoaMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbKhoaMouseEntered

    private void cbbKhoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhoaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhoaMouseExited

    private void cbbKhoaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhoaMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbKhoaMouseReleased

    private void cbbKhoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhoaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhoaMousePressed

    private void cbbKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhoaActionPerformed
        // TODO add your handling code here:
        for (Khoa khoa : qlkhoa.getLstKhoa()) {
            if (cbbKhoa.getSelectedItem() == khoa.getTenKhoa()) {
                loadCbbLop(qlkhoa.findName(khoa.getTenKhoa()).getMaKhoa());
            }
        }
    }//GEN-LAST:event_cbbKhoaActionPerformed

    private void btnaddSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddSVActionPerformed
        // TODO add your handling code here:
        if (kiemTraThongTinSV()) {
            SinhVien sv = GetFieldSinhVien();
            if (ktraMaSV(sv.getMaSV())) {
                qlsv.add(sv);
            } else {
                JOptionPane.showMessageDialog(null, "Mã Sinh Viên Bị Trùng", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            }
        }
        HienThiSV();
    }//GEN-LAST:event_btnaddSVActionPerformed

    private void btnaddLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddLopActionPerformed
        // TODO add your handling code here:
        String a = cbbKhoaToLop.getSelectedItem().toString();
        if (a == "Tất cả Khoa") {
            JOptionPane.showMessageDialog(null, "Vui lòng Chọn Khoa", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
        } else if (kiemTraThongTinLop()) {
            Lop lop = GetFieldLop();
            if (ktraMaLop(lop.getMaLop())) {
                if (ktraTenLop(lop.getTenLop())) {
                    for (Khoa khoa : qlkhoa.getLstKhoa()) {
                        if (khoa.getTenKhoa().equals(a)) {
                            khoa.getDSLop().add(lop);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tên Lớp Bị Trùng", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mã Lớp Bị Trùng", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            }
        }
        HienThiLop();
    }//GEN-LAST:event_btnaddLopActionPerformed

    private void btnaddKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddKhoaActionPerformed
        // TODO add your handling code here:
        if (kiemTraThongTinKhoa()) {
            Khoa khoa = GetFieldKhoa();
            if (ktraMaKhoa(khoa.getMaKhoa())) {
                if (ktraTenKhoa(khoa.getTenKhoa())) {
                    qlkhoa.add(khoa);
                } else {
                    JOptionPane.showMessageDialog(null, "Tên Khoa Bị Trùng", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Mã Khoa Bị Trùng", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            }
        }

        HienThiKhoa();
    }//GEN-LAST:event_btnaddKhoaActionPerformed

    private void cbbKhoaToLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhoaToLopActionPerformed
        // TODO add your handling code here:
        HienThiLop();
    }//GEN-LAST:event_cbbKhoaToLopActionPerformed

    private void btnuploadKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadKhoaActionPerformed
        // TODO add your handling code here:
        Khoa khoa = GetFieldKhoa();
        upLoadKhoa(khoa);
        setSinhVientoKhoa(khoa.getMaKhoa(), khoa);
    }//GEN-LAST:event_btnuploadKhoaActionPerformed

    private void btnuploadLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadLopActionPerformed
        // TODO add your handling code here:
        Lop lop = GetFieldLop();
        upLoadLop(lop);
        setSinhVientoLop(lop.getMaLop(), lop);
        
    }//GEN-LAST:event_btnuploadLopActionPerformed

    private void btnSaveKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveKhoaActionPerformed
        try {
            // TODO add your handling code here:
            qlkhoa.ghiFileKhoa();
            qlsv.ghiFileSinhVien();
            JOptionPane.showMessageDialog(this, "Lưu Khoa Thành Công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveKhoaActionPerformed

    private void btnuploadSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadSVActionPerformed
        // TODO add your handling code here:
     
        int index = tblSinhVien.getSelectedRow();
        String sMa = String.valueOf(tblSinhVien.getValueAt(index, 5));
        if (kiemTraThongTinSV()) {
            SinhVien sv = GetFieldSinhVien();
            upLoadSinhVien(sv);

            if (GetFieldSinhVien().getKhoa().getTenKhoa().equals(sMa) == false) {
                setDiemMHtoSV(sv.getMaSV());
            }
        }
        
        
    }//GEN-LAST:event_btnuploadSVActionPerformed

    private void btnSaveSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSVActionPerformed
        try {
            // TODO add your handling code here:
            qlsv.ghiFileSinhVien();
            qlkhoa.ghiFileKhoa();
            qlDiemMH.ghiFileDiemMH();
            JOptionPane.showMessageDialog(this, "Lưu Sinh Viên Thành Công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveSVActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        int row = tblSinhVien.getSelectedRow();
        txtMaSv.setText(String.valueOf(tblSinhVien.getValueAt(row,1)));
        txtTenSV.setText(String.valueOf(tblSinhVien.getValueAt(row,2)));
        txtNamSinh.setText(String.valueOf(tblSinhVien.getValueAt(row,3)));
        cbbKhoa.setSelectedItem(String.valueOf(tblSinhVien.getValueAt(row,5)));
        cbbLop.setSelectedItem(String.valueOf(tblSinhVien.getValueAt(row,4)));
        txtDiaChi.setText(String.valueOf(tblSinhVien.getValueAt(row,6)));
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void tblKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoaMouseClicked
        // TODO add your handling code here:
        int row = tblKhoa.getSelectedRow();
        txtMaKhoa.setText(String.valueOf(tblKhoa.getValueAt(row,1)));
        txtTenKhoa.setText(String.valueOf(tblKhoa.getValueAt(row,2)));
    }//GEN-LAST:event_tblKhoaMouseClicked

    private void tblLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopMouseClicked
        // TODO add your handling code here:
        int row = tblLop.getSelectedRow();
        txtMaLop.setText(String.valueOf(tblLop.getValueAt(row, 1)));
        txtTenLop.setText(String.valueOf(tblLop.getValueAt(row, 2)));
    }//GEN-LAST:event_tblLopMouseClicked

    private void btndangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangxuatActionPerformed
        // TODO add your handling code here:
        try {
            int click = JOptionPane.showConfirmDialog(null,
                    "Bạn Có Muốn Đăng Xuất");
            if (click == JOptionPane.YES_OPTION) {
                this.dispose();

                Login frmLogin = new Login();
                frmLogin.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btndangxuatActionPerformed

    private void btnuploadpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadpassActionPerformed
        // TODO add your handling code here:
        if (kiemTraThongTinDMK()) {
            for (User user : qluser.getLstUser()) {
                if (user.getTenTK().equals(Login.getUserLogin.getTenTK())) {
                    user.setMatKhau(txtmkmoi.getText());
                }
            }
            try {
                qluser.ghiFileTaiKhoan();
                JOptionPane.showMessageDialog(this, "Thay đổi Mật Khẩu Thành Công");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnuploadpassActionPerformed

    private void btnThoatDMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatDMKActionPerformed
        // TODO add your handling code here:
        try {
            int click = JOptionPane.showConfirmDialog(null,
                    "Bạn Có Muốn Đăng Xuất");
            if (click == JOptionPane.YES_OPTION) {
                this.dispose();

                Login frmLogin = new Login();
                frmLogin.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThoatDMKActionPerformed

    private void btnsetpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsetpassActionPerformed
        // TODO add your handling code here:
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(DMK);
        Page.repaint();
        Page.revalidate();
    }//GEN-LAST:event_btnsetpassActionPerformed

    private void cbbSapxepSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapxepSVActionPerformed
        // TODO add your handling code here:
        if (cbbSapxepSV.getSelectedItem() == "Sắp xếp theo Mã") {
            qlsv.sortSVByMaSV();
            HienThiSV();
        } else if (cbbSapxepSV.getSelectedItem() == "Sắp xếp theo Tên") {
            qlsv.sortSVByName();
            HienThiSV();
        } else if (cbbSapxepSV.getSelectedItem() == "Sắp xếp theo Năm Sinh") {
            qlsv.sortSVByMaBirthday();
            HienThiSV();
        } else if (cbbSapxepSV.getSelectedItem() == "Sắp xếp theo Lớp") {
            qlsv.sortSVByClass();
            HienThiSV();
        } else if (cbbSapxepSV.getSelectedItem() == "Sắp xếp theo Khoa") {
            qlsv.sortSVByKhoa();
            HienThiSV();
        } else if (cbbSapxepSV.getSelectedItem() == "Sắp xếp theo Địa Chỉ") {
            qlsv.sortSVByAddpress();
            HienThiSV();
        }
    }//GEN-LAST:event_cbbSapxepSVActionPerformed

    private void cbbSapxepKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapxepKhoaActionPerformed
        // TODO add your handling code here:
        if (cbbSapxepKhoa.getSelectedItem() == "Sắp xếp theo Mã") {
            qlkhoa.sortKhoaByMa();
            HienThiKhoa();
        } else if (cbbSapxepKhoa.getSelectedItem() == "Sắp xếp theo Tên") {
            qlkhoa.sortKhoaByName();
            HienThiKhoa();
        }
    }//GEN-LAST:event_cbbSapxepKhoaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            int click = JOptionPane.showConfirmDialog(null,
                    "Bạn Có Muốn Đăng Xuất");
            if (click == JOptionPane.YES_OPTION) {
                this.dispose();
                Login frmLogin = new Login();
                frmLogin.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            int click = JOptionPane.showConfirmDialog(null,
                    "Bạn Có Muốn Đăng Xuất");
            if (click == JOptionPane.YES_OPTION) {
                this.dispose();

                Login frmLogin = new Login();
                frmLogin.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbbSapxepLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapxepLopActionPerformed
        // TODO add your handling code here:
        if (cbbKhoaToLop.getSelectedItem() == "Tất cả Khoa") {
            if (cbbSapxepLop.getSelectedItem() == "Sắp xếp theo Mã") {
                for (Khoa khoa : qlkhoa.getLstKhoa()) {
                    khoa.getDSLop().sortLopByMa();
                    HienThiLop();
                }
            } else if (cbbSapxepLop.getSelectedItem() == "Sắp xếp theo Tên") {
                for (Khoa khoa : qlkhoa.getLstKhoa()) {
                    khoa.getDSLop().sortLopByName();
                    HienThiLop();
                }
            }
        } else {
            for (Khoa stKhoa : qlkhoa.getLstKhoa()) {
                if (stKhoa.getTenKhoa().equals(cbbKhoaToLop.getSelectedItem())) {
                    if (cbbSapxepLop.getSelectedItem() == "Sắp xếp theo Mã") {
                        stKhoa.getDSLop().sortLopByMa();
                        HienThiLop();
                    } else if (cbbSapxepLop.getSelectedItem() == "Sắp xếp theo Tên") {                      
                        stKhoa.getDSLop().sortLopByName();
                        HienThiLop();                      
                    }
                }
            }
        }
    }//GEN-LAST:event_cbbSapxepLopActionPerformed

    private void btnSaveLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveLopActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            qlsv.ghiFileSinhVien();
            qlkhoa.ghiFileKhoa();
            qlDiemMH.ghiFileDiemMH();
            JOptionPane.showMessageDialog(this, "Lưu Lớp Thành Công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveLopActionPerformed

    private void btnTimKiemKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKhoaActionPerformed
        // TODO add your handling code here:
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) tblKhoa.getModel();
        model.setRowCount(0);
        for(Khoa skhoa : qlkhoa.getLstKhoa()){
            if(skhoa.getMaKhoa().equals(GetFieldKhoa().getMaKhoa()) || skhoa.getTenKhoa().equals(GetFieldKhoa().getTenKhoa())){
                
                stt++;
                model.addRow(new Object[]{stt, skhoa.getMaKhoa(), skhoa.getTenKhoa()});
            }
        }
        txtTongKhoa.setText(String.valueOf(stt));
    }//GEN-LAST:event_btnTimKiemKhoaActionPerformed

    private void btnTimKiemLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemLopActionPerformed
        // TODO add your handling code here:
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) tblLop.getModel();
        model.setRowCount(0);
        for(Khoa skhoa : qlkhoa.getLstKhoa()){
            for(Lop lop : skhoa.getDSLop().getLstLop()){
                if(lop.getMaLop().equals(GetFieldLop().getMaLop()) || lop.getTenLop().equals(GetFieldLop().getTenLop())){
                
                stt++;
                model.addRow(new Object[]{stt, lop.getMaLop(), lop.getTenLop()});
                }
            }
        }
        txtTongLop.setText(String.valueOf(stt));
    }//GEN-LAST:event_btnTimKiemLopActionPerformed

    private void btnTimKiemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSVActionPerformed
        // TODO add your handling code here:
        int stt = 0;
       
        DefaultTableModel model = (DefaultTableModel) tblSinhVien.getModel();
        model.setRowCount(0);
        for(SinhVien sv : qlsv.getLstSV()){  
            if(sv.getMaSV().equals(txtMaSv.getText()) || sv.getTenSV().equals(txtTenSV.getText()) || 
                    sv.getNamSinh().equals(txtNamSinh.getText()) || sv.getKhoa().getTenKhoa().equals(cbbKhoa.getSelectedItem()) ||
                    sv.getLop().getTenLop().equals(cbbLop.getSelectedItem()) || sv.getDiaChi().equals(txtDiaChi.getText())){
                stt++;
                model.addRow(new Object[]{stt, sv.getMaSV(), sv.getTenSV(), sv.getNamSinh(),
                sv.getLop().getTenLop(), sv.getKhoa().getTenKhoa(), sv.getDiaChi()});
            }
        }
        txtTongSV.setText(String.valueOf(stt));
    }//GEN-LAST:event_btnTimKiemSVActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(ThongTin);
        Page.repaint();
        Page.revalidate();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void tblMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonHocMouseClicked
        // TODO add your handling code here:
        int row = tblMonHoc.getSelectedRow();
        txtMaMon.setText(String.valueOf(tblMonHoc.getValueAt(row, 1)));
        txtTenMon.setText(String.valueOf(tblMonHoc.getValueAt(row, 2)));
    }//GEN-LAST:event_tblMonHocMouseClicked

    private void btnaddMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddMonActionPerformed
        // TODO add your handling code here:
        String a = cbbKhoaToMonHoc.getSelectedItem().toString();
        if (a == "Tất cả Khoa") {
            JOptionPane.showMessageDialog(null, "Vui lòng Chọn Khoa", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
        } else if (kiemTraThongTinMon()) {
            MonHoc mh = GetFieldMon();
            if (ktraMaMon(mh.getMaMon())) {
                if (ktraTenMon(mh.getTenMon())) {
                    for (Khoa khoa : qlkhoa.getLstKhoa()) {
                        if (khoa.getTenKhoa().equals(a)) {
                            khoa.getDsMonHoc().add(mh);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tên Môn Bị Trùng", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mã Môn Bị Trùng", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            }
        }
        HienThiMonHoc();
    }//GEN-LAST:event_btnaddMonActionPerformed

    private void btndeteleMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeteleMonActionPerformed
        // TODO add your handling code here:
        xoaMon();
    }//GEN-LAST:event_btndeteleMonActionPerformed

    private void btnuploadMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadMonActionPerformed
        // TODO add your handling code here:
        MonHoc mh = GetFieldMon();
        upLoadMonHoc(mh);
        
    }//GEN-LAST:event_btnuploadMonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSaveMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMonActionPerformed
        try {
            // TODO add your handling code here:
            qlkhoa.ghiFileKhoaToMonHoc();
            //qlsv.ghiFileSinhVien();
            //qlkhoa.ghiFileKhoa();
            qlDiemMH.ghiFileDiemMH();
            JOptionPane.showMessageDialog(this, "Lưu Môn Học Thành Công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveMonActionPerformed

    private void btnTimKiemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemMonActionPerformed
        // TODO add your handling code here:
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) tblMonHoc.getModel();
        model.setRowCount(0);
        for(Khoa skhoa : qlkhoa.getLstKhoa()){
            for(MonHoc mh : skhoa.getDsMonHoc().getLstMonHoc()){
                if(mh.getMaMon().equals(GetFieldMon().getMaMon()) || mh.getTenMon().equals(GetFieldMon().getTenMon())){
                
                stt++;
                model.addRow(new Object[]{stt, mh.getMaMon(), mh.getTenMon()});
                }
            }
        }
        txtTongMon.setText(String.valueOf(stt));
    }//GEN-LAST:event_btnTimKiemMonActionPerformed

    private void cbbSapxepMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapxepMonActionPerformed
        // TODO add your handling code here:
         if (cbbKhoaToMonHoc.getSelectedItem() == "Tất cả Khoa") {
            if (cbbSapxepMon.getSelectedItem() == "Sắp xếp theo Mã") {
                for (Khoa khoa : qlkhoa.getLstKhoa()) {
                    khoa.getDsMonHoc().sortMonByMa();
                    HienThiMonHoc();
                }
            } else if (cbbSapxepMon.getSelectedItem() == "Sắp xếp theo Tên") {
                for (Khoa khoa : qlkhoa.getLstKhoa()) {
                    khoa.getDsMonHoc().sortMonByName();
                    HienThiMonHoc();
                }
            }
        } else {
            for (Khoa stKhoa : qlkhoa.getLstKhoa()) {
                if (stKhoa.getTenKhoa().equals(cbbKhoaToMonHoc.getSelectedItem())) {
                    if (cbbSapxepMon.getSelectedItem() == "Sắp xếp theo Mã") {
                        stKhoa.getDsMonHoc().sortMonByMa();
                        HienThiMonHoc();
                    } else if (cbbSapxepMon.getSelectedItem() == "Sắp xếp theo Tên") {                      
                        stKhoa.getDsMonHoc().sortMonByName();
                        HienThiMonHoc();                      
                    }
                }
            }
        }
    }//GEN-LAST:event_cbbSapxepMonActionPerformed

    private void cbbKhoaToMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhoaToMonHocActionPerformed
        // TODO add your handling code here:
        HienThiMonHoc();
    }//GEN-LAST:event_cbbKhoaToMonHocActionPerformed

    private void btnMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonHocActionPerformed
        // TODO add your handling code here:
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(MonHoc);
        Page.repaint();
        Page.revalidate();
        xoaFieldMon();
        loadCbbKhoaToMon();
        loadCbbSapXepMon();
    }//GEN-LAST:event_btnMonHocActionPerformed

    private void tblDiemMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemMonHocMouseClicked
        // TODO add your handling code here:
        int row = tblDiemMonHoc.getSelectedRow();
        cbbKhoaToDiemMH.removeAllItems();
        cbbKhoaToDiemMH.addItem(String.valueOf(tblDiemMonHoc.getValueAt(row, 3)));
        cbbSinhVienToDiemMH.setSelectedItem(String.valueOf(tblDiemMonHoc.getValueAt(row, 2)));
        cbbMonHocToDiemMH.setSelectedItem(String.valueOf(tblDiemMonHoc.getValueAt(row, 4)));
        txtDiem.setText(String.valueOf(tblDiemMonHoc.getValueAt(row, 5)));
    }//GEN-LAST:event_tblDiemMonHocMouseClicked

    private void btnaddDiemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddDiemMHActionPerformed
        // TODO add your handling code here:
        if(kiemTraThongTinDMH()){
            if(ktraDiemMonHoc(GetFieldDiemMH())){
                qlDiemMH.add(GetFieldDiemMH());
            HienThiDiemMonHoc();
            }else{
                JOptionPane.showMessageDialog(null, "Môn Học Sinh Viên Đã Đăng Ký", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnaddDiemMHActionPerformed

    private void btndeteleDiemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeteleDiemMHActionPerformed
        // TODO add your handling code here:
        xoaDiemMonHoc();
    }//GEN-LAST:event_btndeteleDiemMHActionPerformed

    private void btnuploadDiemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadDiemMHActionPerformed
        // TODO add your handling code here:
        int row = tblDiemMonHoc.getSelectedRow();
        DiemMonHoc dmh = GetFieldDiemMH();
        if(dmh.getSinhVien().getMaSV().equals(String.valueOf(tblDiemMonHoc.getValueAt(row, 1))) && 
                dmh.getMonHoc().getTenMon().equals(String.valueOf(tblDiemMonHoc.getValueAt(row, 4)))){
            upLoadDiemMH(GetFieldDiemMH());
            HienThiDiemMonHoc();
        }else if(ktraDiemMonHoc(dmh)){
            upLoadDiemMH(GetFieldDiemMH());
            HienThiDiemMonHoc();
        }
        else {
            JOptionPane.showMessageDialog(null, "Môn Học Sinh Viên Đã Đăng Ký", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnuploadDiemMHActionPerformed

    private void btnThoatDiemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatDiemMHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoatDiemMHActionPerformed

    private void btnSaveDiemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDiemMHActionPerformed
        try {
            // TODO add your handling code here:
            qlDiemMH.ghiFileDiemMH();
            qlsv.ghiFileSinhVien();
            qlkhoa.ghiFileKhoa();
            //qlDiemMH.ghiFileDiemMH();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(this, "Lưu Điểm Môn Học Thành Công");
    }//GEN-LAST:event_btnSaveDiemMHActionPerformed

    private void btnTimKiemDiemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDiemMHActionPerformed
        // TODO add your handling code here:
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) tblDiemMonHoc.getModel();
        model.setRowCount(0);
        for(DiemMonHoc dmh : qlDiemMH.getLstDiemMH()){  
            if(dmh.getSinhVien().getTenSV().equals(cbbSinhVienToDiemMH.getSelectedItem()) || 
                    dmh.getMonHoc().getTenMon().equals(cbbMonHocToDiemMH.getSelectedItem()) || 
                    dmh.getDiem().equals(txtDiem.getText())){
                stt++;
                model.addRow(new Object[]{stt, dmh.getSinhVien().getMaSV(), dmh.getSinhVien().getTenSV(),
                dmh.getSinhVien().getKhoa().getTenKhoa(), dmh.getMonHoc().getTenMon(), dmh.getDiem()});
            }      
        }
        txtTongDiemMH.setText(String.valueOf(stt));
    }//GEN-LAST:event_btnTimKiemDiemMHActionPerformed

    private void btnDiemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemMHActionPerformed
        // TODO add your handling code here:
        Page.removeAll();
        Page.repaint();
        Page.revalidate();
        Page.add(DiemMonHoc);
        Page.repaint();
        Page.revalidate();
        loadCbbKhoaToDMH();
        loadCbbMonHocHollow();
        loadCbbSinhVienHollow();
        txtDiem.setText("");
        HienThiDiemMonHoc();
    }//GEN-LAST:event_btnDiemMHActionPerformed

    private void cbbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLopActionPerformed

    private void cbbKhoaToDiemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhoaToDiemMHActionPerformed
        // TODO add your handling code here:
        if(cbbKhoaToDiemMH.getSelectedItem() == "Chọn Khoa"){
            loadCbbSinhVienHollow();
            loadCbbMonHocHollow();
            txtDiem.setText("");
            return;
        }
        for(Khoa khoa : qlkhoa.getLstKhoa()){
            if (cbbKhoaToDiemMH.getSelectedItem() == khoa.getTenKhoa()) {
                loadCbbMonHocToDMH(khoa.getMaKhoa());
                loadSVToDMH(khoa.getMaKhoa());
            }
        }
    }//GEN-LAST:event_cbbKhoaToDiemMHActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormMain().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DMK;
    private javax.swing.JPanel DiemMonHoc;
    private javax.swing.JPanel Khoa;
    private javax.swing.JPanel Lop;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel MonHoc;
    private javax.swing.JPanel Page;
    private javax.swing.JPanel SinhVien;
    private javax.swing.JPanel ThongTin;
    private javax.swing.JPanel TrangChu;
    private javax.swing.JButton btnDiemMH;
    private javax.swing.JButton btnKhoa;
    private javax.swing.JButton btnLop;
    private javax.swing.JButton btnMonHoc;
    private javax.swing.JButton btnSV;
    private javax.swing.JButton btnSaveDiemMH;
    private javax.swing.JButton btnSaveKhoa;
    private javax.swing.JButton btnSaveLop;
    private javax.swing.JButton btnSaveMon;
    private javax.swing.JButton btnSaveSV;
    private javax.swing.JButton btnThoatDMK;
    private javax.swing.JButton btnThoatDiemMH;
    private javax.swing.JButton btnTimKiemDiemMH;
    private javax.swing.JButton btnTimKiemKhoa;
    private javax.swing.JButton btnTimKiemLop;
    private javax.swing.JButton btnTimKiemMon;
    private javax.swing.JButton btnTimKiemSV;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnaddDiemMH;
    private javax.swing.JButton btnaddKhoa;
    private javax.swing.JButton btnaddLop;
    private javax.swing.JButton btnaddMon;
    private javax.swing.JButton btnaddSV;
    private javax.swing.JButton btndangxuat;
    private javax.swing.JButton btndeteleDiemMH;
    private javax.swing.JButton btndeteleKhoa;
    private javax.swing.JButton btndeteleLop;
    private javax.swing.JButton btndeteleMon;
    private javax.swing.JButton btndeteleSV;
    private javax.swing.JButton btnsetpass;
    private javax.swing.JButton btnuploadDiemMH;
    private javax.swing.JButton btnuploadKhoa;
    private javax.swing.JButton btnuploadLop;
    private javax.swing.JButton btnuploadMon;
    private javax.swing.JButton btnuploadSV;
    private javax.swing.JButton btnuploadpass;
    private javax.swing.JComboBox<String> cbbKhoa;
    private javax.swing.JComboBox<String> cbbKhoaToDiemMH;
    private javax.swing.JComboBox<String> cbbKhoaToLop;
    private javax.swing.JComboBox<String> cbbKhoaToMonHoc;
    private javax.swing.JComboBox<String> cbbLop;
    private javax.swing.JComboBox<String> cbbMonHocToDiemMH;
    private javax.swing.JComboBox<String> cbbSapxepKhoa;
    private javax.swing.JComboBox<String> cbbSapxepLop;
    private javax.swing.JComboBox<String> cbbSapxepMon;
    private javax.swing.JComboBox<String> cbbSapxepSV;
    private javax.swing.JComboBox<String> cbbSinhVienToDiemMH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblDiemMonHoc;
    private javax.swing.JTable tblKhoa;
    private javax.swing.JTable tblLop;
    private javax.swing.JTable tblMonHoc;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtMaKhoa;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtMaSv;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtTenKhoa;
    private javax.swing.JTextField txtTenLop;
    private javax.swing.JTextField txtTenMon;
    private javax.swing.JTextField txtTenSV;
    private javax.swing.JTextField txtTongDiemMH;
    private javax.swing.JTextField txtTongKhoa;
    private javax.swing.JTextField txtTongLop;
    private javax.swing.JTextField txtTongMon;
    private javax.swing.JTextField txtTongSV;
    private javax.swing.JPasswordField txtmkcu;
    private javax.swing.JPasswordField txtmkmoi;
    private javax.swing.JPasswordField txtmkmoiv2;
    // End of variables declaration//GEN-END:variables
}

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
public class DocFileDiemMonHoc {
    public static void docFile(String fName, ListDiemMonHoc qlDiemMH, ListSV qlsv, ListKhoa qlkhoa) throws FileNotFoundException, IOException {
        try (BufferedReader bf = new BufferedReader(new FileReader(fName))) {
            String line;
            while((line = bf.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(line,":");
                while(tokens.hasMoreTokens()){
                    String maSV = tokens.nextToken();
                    SinhVien a = qlsv.find(maSV);
                    String monHoc = tokens.nextToken();
                    MonHoc mh = qlkhoa.find(a.getKhoa().getMaKhoa()).getDsMonHoc().findName(monHoc);
                    String diem = tokens.nextToken();
                    qlDiemMH.add(new DiemMonHoc(a, mh, diem));
                }
            }
        }
    }
    
    public static  void ghiFile(String fName, ArrayList<DiemMonHoc> listDiemMonHoc) throws FileNotFoundException{
        PrintWriter fOut = new PrintWriter(fName);
        for(DiemMonHoc dmh : listDiemMonHoc){
            fOut.println(dmh.stringGhiFile());
        }
        fOut.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class DichVu {
     private String maDV;
     private String tenDV;
     private String maMay;
    private String maKH;
    private String gia;
  
    @Override
    public String toString() {
        return this.tenDV;
    }

    public DichVu() {
    }

    public DichVu(String maDV, String tenDV, String maMay, String maKH, String gia) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.maMay = maMay;
        this.maKH = maKH;
        this.gia = gia;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
 
}

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
public class May {
 private String maMay;
 private String maKH;
 private String maNV;
 private String gioChoi;
 @Override
 public String toString() {
 return this.toString();
 }

    public May() {
    }

    public May(String maMay, String maKH, String maNV, String gioChoi) {
        this.maMay = maMay;
        this.maKH = maKH;
        this.maNV = maNV;
        this.gioChoi = gioChoi;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getGioChoi() {
        return gioChoi;
    }

    public void setGioChoi(String gioChoi) {
        this.gioChoi = gioChoi;
    }

   
}

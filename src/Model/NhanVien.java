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
public class NhanVien {
    private String maNV;
    private String matKhau;
    private String tenNV;
   

    @Override
    public String toString() {
        return this.tenNV;
    }

    public NhanVien() {
    }

    public NhanVien(String maNV, String matKhau, String tenNV) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.tenNV = tenNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

}

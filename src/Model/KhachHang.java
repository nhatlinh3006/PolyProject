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
public class KhachHang {
     private String maKH;
    private String matKhau;
    private String tenTK;
   

    @Override
    public String toString() {
        return this.tenTK;
    }

    public KhachHang() {
    }

    public KhachHang(String maKH, String matKhau, String tenTK) {
        this.maKH = maKH;
        this.matKhau = matKhau;
        this.tenTK = tenTK;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

}

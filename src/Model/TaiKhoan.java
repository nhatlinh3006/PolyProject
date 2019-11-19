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
public class TaiKhoan {
      private String maTK;
    private String matKhau;
    private String tenTK;
   

    @Override
    public String toString() {
        return this.tenTK;
    }

    public TaiKhoan() {
    }

    public TaiKhoan(String maTK, String matKhau, String tenTK) {
        this.maTK = maTK;
        this.matKhau = matKhau;
        this.tenTK = tenTK;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
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

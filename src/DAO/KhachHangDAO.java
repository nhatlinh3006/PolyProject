/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.KhachHang;

import help.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDAO {
    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang (MaKH, TenTK, MatKhau) VALUES (?, ?, ?)";
        jdbc.executeUpdate(sql,
                model.getMaKH(),
                model.getTenTK(),
                model.getMatKhau()    );       
                
    }

    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang SET MatKhau=?, TenTK=? WHERE MaKH=?";
        jdbc.executeUpdate(sql,
                model.getMaKH(),
                model.getTenTK(),
                model.getMatKhau() );        
                
    }

    public void delete(String MaKH) {
        String sql = "DELETE FROM KhachHang WHERE MaKH=?";
        jdbc.executeUpdate(sql, MaKH);
    }

    public List<KhachHang> select() {        
        String sql = "SELECT * FROM KhachHang";
        return select(sql);
    }

    public KhachHang findById(String makh) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
        List<KhachHang> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKH(rs.getString("MaKH"));
        model.setTenTK(rs.getString("TenTK"));
        model.setMatKhau(rs.getString("MatKhau")); 
        return model;
    }
}

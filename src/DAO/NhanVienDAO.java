/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.NhanVien;
import help.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAO {
    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (MaNV, TenNV, MatKhau) VALUES (?, ?, ?)";
        jdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getTenNV(),
                model.getMatKhau()    );       
                
    }

    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET MatKhau=?, TenNV=? WHERE MaNV=?";
        jdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getTenNV(),
                model.getMatKhau() );        
                
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        jdbc.executeUpdate(sql, MaNV);
    }

    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }

    public NhanVien findById(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setTenNV(rs.getString("TenNV"));
        model.setMatKhau(rs.getString("MatKhau")); 
        return model;
    }
}

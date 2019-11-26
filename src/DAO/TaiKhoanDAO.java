/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TaiKhoan;
import help.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TaiKhoanDAO {
     public void insert(TaiKhoan model) {
        String sql = "INSERT INTO TaiKhoan (MaTK, TenTK, MatKhau) VALUES (?, ?, ?)";
        jdbc.executeUpdate(sql,
                model.getMaTK(),
                model.getTenTK(),
                model.getMatKhau()    );       
                
    }

    public void update(TaiKhoan model) {
        String sql = "UPDATE TaiKhoan SET MatKhau=?, TenTK=? WHERE MaTK=?";
        jdbc.executeUpdate(sql,
                model.getMaTK(),
                model.getTenTK(),
                model.getMatKhau() );                      
    }

    public void delete(String MaTK) {
        String sql = "DELETE FROM TaiKhoan WHERE MaTK=?";
        jdbc.executeUpdate(sql, MaTK);
    }

    public List<TaiKhoan> select() {
        String sql = "SELECT * FROM TaiKhoan";
        return select(sql);
    }

    public TaiKhoan findById(String matk) {
        String sql = "SELECT * FROM TaiKhoan WHERE MaTK=?";
        List<TaiKhoan> list = select(sql, matk);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<TaiKhoan> select(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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

    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setMaTK(rs.getString("MaTK"));
        model.setTenTK(rs.getString("TenNV"));
        model.setMatKhau(rs.getString("MatKhau")); 
        return model;
    }
}

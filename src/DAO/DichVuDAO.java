/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DichVu;
import help.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DichVuDAO {
     public void insert(DichVu model) {
        String sql = "INSERT INTO DichVu (MaDV, TenDV, MaMay, MaKH,Gia) VALUES (?, ?, ?, ?, ?)";
        jdbc.executeUpdate(sql,
                model.getMaDV(),
                 model.getTenDV(),
                  model.getMaMay(),
                model.getMaKH(),
                model.getGia()    );       
                
    }

    public void update(DichVu model) {
        String sql = "UPDATE DichVu SET TenDV=?, MaMay=? , MaKH=?, Gia=?  WHERE MaDV=?";
        jdbc.executeUpdate(sql,
                model.getMaDV(),
                 model.getTenDV(),
                  model.getMaMay(),
                model.getMaKH(),
                model.getGia() );        
                
    }

    public void delete(String MaDV) {
        String sql = "DELETE FROM DichVu WHERE MaDV=?";
        jdbc.executeUpdate(sql, MaDV);
    }

    public List<DichVu> select() {
        String sql = "SELECT * FROM DichVu";
        return select(sql);
    }

    public DichVu findById(String madv) {
        String sql = "SELECT * FROM DichVu WHERE MaDV=?";
        List<DichVu> list = select(sql, madv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<DichVu> select(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    DichVu model = readFromResultSet(rs);
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

    private DichVu readFromResultSet(ResultSet rs) throws SQLException {
        DichVu model = new DichVu();
        model.setMaDV(rs.getString("MaDV"));
        model.setTenDV(rs.getString("TenDV"));
         model.setMaMay(rs.getString("MaMay"));
          model.setMaKH(rs.getString("MaKH"));
        model.setGia(rs.getString("Gia")); 
        return model;
    }
}


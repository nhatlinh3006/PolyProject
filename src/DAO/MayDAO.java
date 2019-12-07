/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.May;
import help.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MayDAO {
    public void insert(May model) {
        String sql = "INSERT INTO May(MaMay, MaKH, MaNV, GioChoi) VALUES(?, ?, ?,?)";
        jdbc.executeUpdate(sql,
                model.getMaMay(),
                model.getMaKH(),
                model.getMaNV(),
                model.getGioChoi());
    }

    public void update(May model) {
        String sql = "UPDATE May SET MaKH=?, MaNV=?, GioChoi=? WHERE MaMay=?";
        jdbc.executeUpdate(sql,
                
                model.getMaKH(),
                model.getMaNV(),
                model.getGioChoi(),
                model.getMaMay());
    }

    public void delete(Integer MaMay) {
        String sql = "DELETE FROM May WHERE MaMay=?";
        jdbc.executeUpdate(sql, MaMay);
    }

    public List<May> select() {
        String sql = "SELECT * FROM May";
        return select(sql);
    }

    public May findById(Integer mamay) {
        String sql = "SELECT * FROM May WHERE MaMay=?";
        List<May> list = select(sql, mamay);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<May> select(String sql, Object... args) {
        List<May> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    May model = readFromResultSet(rs);
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

    private May readFromResultSet(ResultSet rs) throws SQLException {
        May model = new May();
        model.setMaMay(rs.getString("MaMay"));
        model.setMaKH(rs.getString("MaKH"));
        model.setMaNV(rs.getString("MaNV"));
        model.setGioChoi(rs.getString("GioChoi"));
        return model;
    }
    
    
}

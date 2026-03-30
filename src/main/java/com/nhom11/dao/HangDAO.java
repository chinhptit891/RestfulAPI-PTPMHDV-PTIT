package com.nhom11.dao;

import com.nhom11.config.KetNoiCSDL;
import com.nhom11.model.Hang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangDAO {
    
    public List<Hang> layTatCaHang() {
        List<Hang> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM Hang";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql);
             ResultSet ketQua = lenh.executeQuery()) {
            
            while (ketQua.next()) {
                Hang hang = new Hang();
                hang.setId(ketQua.getInt("id"));
                hang.setTenHang(ketQua.getString("tenHang"));
                danhSach.add(hang);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSach;
    }

    public boolean themHang(Hang hang) {
        String sql = "INSERT INTO Hang(tenHang) VALUES(?)";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setString(1, hang.getTenHang());
            return lenh.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

package com.nhom11.dao;

import com.nhom11.config.KetNoiCSDL;
import com.nhom11.model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NguoiDungDAO {
    
    public boolean dangKy(NguoiDung nd) {
        String sql = "INSERT INTO NguoiDung(tenDangNhap, matKhau, hoTen, soDienThoai) VALUES(?, ?, ?, ?)";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setString(1, nd.getTenDangNhap());
            lenh.setString(2, nd.getMatKhau());
            lenh.setString(3, nd.getHoTen());
            lenh.setString(4, nd.getSoDienThoai());
            
            return lenh.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public NguoiDung dangNhap(String tenDangNhap, String matKhau) {
        String sql = "SELECT * FROM NguoiDung WHERE tenDangNhap = ? AND matKhau = ?";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setString(1, tenDangNhap);
            lenh.setString(2, matKhau);
            
            try (ResultSet ketQua = lenh.executeQuery()) {
                if (ketQua.next()) {
                    NguoiDung nd = new NguoiDung();
                    nd.setId(ketQua.getInt("id"));
                    nd.setTenDangNhap(ketQua.getString("tenDangNhap"));
                    nd.setMatKhau(ketQua.getString("matKhau"));
                    nd.setHoTen(ketQua.getString("hoTen"));
                    nd.setSoDienThoai(ketQua.getString("soDienThoai"));
                    return nd;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

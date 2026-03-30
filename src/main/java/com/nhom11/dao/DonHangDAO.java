package com.nhom11.dao;

import com.nhom11.config.KetNoiCSDL;
import com.nhom11.model.DonHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO {
    
    public boolean taoDonHang(DonHang dh) {
        String sql = "INSERT INTO DonHang(idNguoiDung, idDienThoai, tongTien, trangThai) VALUES(?, ?, ?, ?)";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setInt(1, dh.getIdNguoiDung());
            lenh.setInt(2, dh.getIdDienThoai());
            lenh.setInt(3, dh.getTongTien());
            lenh.setString(4, dh.getTrangThai() != null ? dh.getTrangThai() : "Cho Xu Ly");
            
            return lenh.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public DonHang layDonHangTheoId(int id) {
        String sql = "SELECT * FROM DonHang WHERE id = ?";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setInt(1, id);
            try (ResultSet ketQua = lenh.executeQuery()) {
                if (ketQua.next()) {
                    DonHang dh = new DonHang();
                    dh.setId(ketQua.getInt("id"));
                    dh.setIdNguoiDung(ketQua.getInt("idNguoiDung"));
                    dh.setIdDienThoai(ketQua.getInt("idDienThoai"));
                    dh.setNgayDat(ketQua.getTimestamp("ngayDat"));
                    dh.setTongTien(ketQua.getInt("tongTien"));
                    dh.setTrangThai(ketQua.getString("trangThai"));
                    return dh;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<DonHang> layDonHangCuaNguoiDung(int idNguoiDung) {
        List<DonHang> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM DonHang WHERE idNguoiDung = ?";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setInt(1, idNguoiDung);
            try (ResultSet ketQua = lenh.executeQuery()) {
                while (ketQua.next()) {
                    DonHang dh = new DonHang();
                    dh.setId(ketQua.getInt("id"));
                    dh.setIdNguoiDung(ketQua.getInt("idNguoiDung"));
                    dh.setIdDienThoai(ketQua.getInt("idDienThoai"));
                    dh.setNgayDat(ketQua.getTimestamp("ngayDat"));
                    dh.setTongTien(ketQua.getInt("tongTien"));
                    dh.setTrangThai(ketQua.getString("trangThai"));
                    danhSach.add(dh);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSach;
    }
}

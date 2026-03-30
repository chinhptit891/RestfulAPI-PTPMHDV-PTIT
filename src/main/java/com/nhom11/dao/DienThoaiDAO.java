package com.nhom11.dao;

import com.nhom11.config.KetNoiCSDL;
import com.nhom11.model.DienThoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAO {

    public List<DienThoai> layTatCaDienThoai() {
        List<DienThoai> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM DienThoai";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql);
             ResultSet ketQua = lenh.executeQuery()) {
            
            while (ketQua.next()) {
                DienThoai dt = new DienThoai();
                dt.setId(ketQua.getInt("id"));
                dt.setIdHang(ketQua.getInt("idHang"));
                dt.setTenDienThoai(ketQua.getString("tenDienThoai"));
                dt.setGia(ketQua.getInt("gia"));
                dt.setMoTa(ketQua.getString("moTa"));
                dt.setAnhDaiDien(ketQua.getString("anhDaiDien"));
                danhSach.add(dt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSach;
    }

    public DienThoai layDienThoaiTheoId(int id) {
        String sql = "SELECT * FROM DienThoai WHERE id = ?";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setInt(1, id);
            try (ResultSet ketQua = lenh.executeQuery()) {
                if (ketQua.next()) {
                    DienThoai dt = new DienThoai();
                    dt.setId(ketQua.getInt("id"));
                    dt.setIdHang(ketQua.getInt("idHang"));
                    dt.setTenDienThoai(ketQua.getString("tenDienThoai"));
                    dt.setGia(ketQua.getInt("gia"));
                    dt.setMoTa(ketQua.getString("moTa"));
                    dt.setAnhDaiDien(ketQua.getString("anhDaiDien"));
                    return dt;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean themDienThoai(DienThoai dt) {
        String sql = "INSERT INTO DienThoai(idHang, tenDienThoai, gia, moTa, anhDaiDien) VALUES (?, ?, ?, ?, ?)";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setInt(1, dt.getIdHang());
            lenh.setString(2, dt.getTenDienThoai());
            lenh.setInt(3, dt.getGia());
            lenh.setString(4, dt.getMoTa());
            lenh.setString(5, dt.getAnhDaiDien());
            
            return lenh.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean capNhatDienThoai(DienThoai dt) {
        String sql = "UPDATE DienThoai SET idHang = ?, tenDienThoai = ?, gia = ?, moTa = ?, anhDaiDien = ? WHERE id = ?";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setInt(1, dt.getIdHang());
            lenh.setString(2, dt.getTenDienThoai());
            lenh.setInt(3, dt.getGia());
            lenh.setString(4, dt.getMoTa());
            lenh.setString(5, dt.getAnhDaiDien());
            lenh.setInt(6, dt.getId());
            
            return lenh.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean xoaDienThoai(int id) {
        String sql = "DELETE FROM DienThoai WHERE id = ?";
        try (Connection ketNoi = KetNoiCSDL.layKetNoi();
             PreparedStatement lenh = ketNoi.prepareStatement(sql)) {
            
            lenh.setInt(1, id);
            return lenh.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

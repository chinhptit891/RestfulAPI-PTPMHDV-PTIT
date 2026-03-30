package com.nhom11.service;

import com.nhom11.dao.DonHangDAO;
import com.nhom11.model.DonHang;
import java.util.List;

public class DonHangService {
    private DonHangDAO donHangDAO = new DonHangDAO();

    public boolean taoDonHang(DonHang dh) {
        if (dh == null || dh.getIdNguoiDung() <= 0 || dh.getIdDienThoai() <= 0) {
            return false;
        }
        return donHangDAO.taoDonHang(dh);
    }

    public DonHang layDonHangTheoId(int id) {
        if (id <= 0) return null;
        return donHangDAO.layDonHangTheoId(id);
    }

    public List<DonHang> layDonHangCuaNguoiDung(int idNguoiDung) {
        if (idNguoiDung <= 0) return null;
        return donHangDAO.layDonHangCuaNguoiDung(idNguoiDung);
    }
}

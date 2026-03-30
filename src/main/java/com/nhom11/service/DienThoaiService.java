package com.nhom11.service;

import com.nhom11.dao.DienThoaiDAO;
import com.nhom11.model.DienThoai;
import java.util.List;

public class DienThoaiService {
    private DienThoaiDAO dienThoaiDAO = new DienThoaiDAO();

    public List<DienThoai> layTatCaDienThoai() {
        return dienThoaiDAO.layTatCaDienThoai();
    }

    public DienThoai layDienThoaiTheoId(int id) {
        if (id <= 0) return null;
        return dienThoaiDAO.layDienThoaiTheoId(id);
    }

    public boolean themDienThoai(DienThoai dt) {
        if (dt == null || dt.getTenDienThoai() == null) {
            return false;
        }
        return dienThoaiDAO.themDienThoai(dt);
    }

    public boolean capNhatDienThoai(int id, DienThoai dt) {
        if (id <= 0 || dt == null) return false;
        dt.setId(id);
        return dienThoaiDAO.capNhatDienThoai(dt);
    }

    public boolean xoaDienThoai(int id) {
        if (id <= 0) return false;
        return dienThoaiDAO.xoaDienThoai(id);
    }
}

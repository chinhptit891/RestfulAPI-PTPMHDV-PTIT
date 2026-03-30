package com.nhom11.service;

import com.nhom11.dao.HangDAO;
import com.nhom11.model.Hang;
import java.util.List;

public class HangService {
    private HangDAO hangDAO = new HangDAO();

    public List<Hang> layTatCaHang() {
        return hangDAO.layTatCaHang();
    }

    public boolean themHang(Hang hang) {
        if (hang == null || hang.getTenHang() == null || hang.getTenHang().trim().isEmpty()) {
            return false;
        }
        return hangDAO.themHang(hang);
    }
}

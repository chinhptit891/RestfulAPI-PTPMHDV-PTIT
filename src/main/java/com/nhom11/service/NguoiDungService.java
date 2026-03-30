package com.nhom11.service;

import com.nhom11.dao.NguoiDungDAO;
import com.nhom11.model.NguoiDung;

public class NguoiDungService {
    private NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

    public boolean dangKy(NguoiDung nd) {
        if (nd == null || nd.getTenDangNhap() == null || nd.getMatKhau() == null) {
            return false;
        }
        return nguoiDungDAO.dangKy(nd);
    }

    public NguoiDung dangNhap(String tenDangNhap, String matKhau) {
        if (tenDangNhap == null || matKhau == null) {
            return null;
        }
        return nguoiDungDAO.dangNhap(tenDangNhap, matKhau);
    }
}

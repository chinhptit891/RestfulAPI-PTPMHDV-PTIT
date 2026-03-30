package com.nhom11.model;

import java.util.Date;

public class DonHang {
    private int id;
    private int idNguoiDung;
    private int idDienThoai;
    private Date ngayDat;
    private int tongTien;
    private String trangThai;

    public DonHang() {
    }

    public DonHang(int id, int idNguoiDung, int idDienThoai, Date ngayDat, int tongTien, String trangThai) {
        this.id = id;
        this.idNguoiDung = idNguoiDung;
        this.idDienThoai = idDienThoai;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public int getIdDienThoai() {
        return idDienThoai;
    }

    public void setIdDienThoai(int idDienThoai) {
        this.idDienThoai = idDienThoai;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

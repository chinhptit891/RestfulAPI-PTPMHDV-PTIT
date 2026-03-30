package com.nhom11.model;

public class DienThoai {
    private int id;
    private int idHang;
    private String tenDienThoai;
    private int gia;
    private String moTa;
    private String anhDaiDien;

    public DienThoai() {
    }

    public DienThoai(int id, int idHang, String tenDienThoai, int gia, String moTa, String anhDaiDien) {
        this.id = id;
        this.idHang = idHang;
        this.tenDienThoai = tenDienThoai;
        this.gia = gia;
        this.moTa = moTa;
        this.anhDaiDien = anhDaiDien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHang() {
        return idHang;
    }

    public void setIdHang(int idHang) {
        this.idHang = idHang;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }
}

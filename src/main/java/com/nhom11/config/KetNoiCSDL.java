package com.nhom11.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiCSDL {
    private static final String URL = "jdbc:mysql://localhost:3306/quanlydienthoai";
    private static final String USER = "root";
    private static final String PASS = ""; // Đổi thông tin nếu cần

    public static Connection layKetNoi() {
        Connection ketNoi = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ketNoi = (Connection) DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return ketNoi;
    }
}

package com.myshop.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";  // DB 주소
        String user = "postgres";    // ← 본인 사용자 이름
        String password = "1234";    // ← 본인 비밀번호

        return DriverManager.getConnection(url, user, password);
    }
}

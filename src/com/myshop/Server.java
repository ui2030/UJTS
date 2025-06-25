package com.myshop;
/*
    서버 연결을 확인하는 곳
 */

import com.myshop.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Server {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()){
            System.out.println("연결 완료");

        } catch (SQLException e) {
            System.out.println("연결 실패: " + e.getMessage());
        }
    }
}

package com.myshop.dao;

import com.myshop.model.User;
import com.myshop.util.DBUtil;

import java.sql.*;

public class UserDAO {

    // 해당 ID의 유저가 존재하는지 확인
    public boolean exists(int id) {
        String sql = "SELECT 1 FROM users WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // 존재하면 true
        } catch (SQLException e) {
            System.out.println("유저 확인 실패: " + e.getMessage());
            return false;
        }
    }

    // 새로운 ID 생성
    public void insert(User user) {
        if (exists(user.getId())) {
            System.out.println("이미 존재하는 ID이네요. 다른 ID를 입력해주시겠어요?");
            return;
        }

        String sql = "INSERT INTO users (id, username, balance) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setInt(3, user.getBalance());

            ps.executeUpdate();
            System.out.println("사용자 등록 완료!");
            System.out.println("이제부터는 정상 이용이 가능하십니다.");
            System.out.println("등록하신 상품은 진열해드리도록 하겠습니다");

        } catch (SQLException e) {
            System.out.println("사용자 등록이 불가능합니다.\n 이유는: " + e.getMessage());
        }
    }
}

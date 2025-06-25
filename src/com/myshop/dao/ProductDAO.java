package com.myshop.dao;

import com.myshop.model.Product;
import com.myshop.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Buy,Read,Update,Sell,Exit {
    @Override
    public void buy(Product p) {
        String sql = "INSERT INTO products (name, price, sellid, sold) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setInt(2, p.getPrice());
            ps.setInt(3, p.getSellId());
            ps.setBoolean(4, false);
            
            ps.executeUpdate();
            System.out.println(" 상품을 구매하셨습니다.");

        } catch (SQLException e) {
            System.out.println("구매 실패\n사유: " + e.getMessage());
        }
    }
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY id";

        try (Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("sellid"),
                        rs.getBoolean("sold")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("미안하지만 더 이상 보여줄 물품이 없다네");
            System.out.println("다음에 또 들려주게나");
        }
        return list;
    }

    @Override
    public void update(Product p) {
        String sql = "UPDATE products SET price = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getPrice());
            ps.setInt(2, p.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("상품의 가격이 변경되었네");
            } else {
                System.out.println("자네가 찾는 물건은 없는거 같네만");
            }
        }catch (SQLException e) {
            System.out.println("변경할 수 없네.\n이유는: " + e.getMessage() +"때문이네.");
        }
    }
    
    @Override
    public void sell(int id) {
        String sql = "UDATE products SET sold = true WHERE id = ?";
        
        try (Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("구매해줘서 고맙네!");
            } else {
                System.out.println("자네가 찾는 물건이 없네만 다른 상품도 둘러보시게나!");
            }
        } catch (SQLException e) {
            System.out.println("그 상품은 판매할 수가 없네.\n그 이유는" + e.getMessage() + "때문이지 자네가 이해하게");
        }
    }
    @Override
    public void exit() {
        System.out.println("살펴 가게");
        System.exit(0);
    }
}


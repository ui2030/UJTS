package com.myshop.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private int sellerId;
    private boolean is_sold;

    // 생성자
    public Product(int id, String name, int price, int seller_Id, boolean is_sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sellerId = seller_Id;
        this.is_sold = is_sold;
    }

    // getter 메서드들 추가
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getSellerId() {
        return sellerId;
    }
    public boolean isSold() {
        return is_sold;
    }

    // 선택: setter도 만들면 좋음
    public void setPrice(int price) {
        this.price = price;
    }
    public void setSold(boolean sold) {
        this.is_sold = sold;
    }
}
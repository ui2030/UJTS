package com.myshop.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private int sellId;
    private boolean sold;

    // 생성자
    public Product(int id, String name, int price, int sellId, boolean sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sellId = sellId;
        this.sold = sold;
    }

    // ✅ getter 메서드들 추가
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getSellId() {
        return sellId;
    }
    public boolean sold() {
        return sold;
    }

    // 선택: setter도 만들면 좋음
    public void setPrice(int price) {
        this.price = price;
    }
    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
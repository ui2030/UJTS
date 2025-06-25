package com.myshop.model;

public class User {
    private int id;
    private String username;
    private int balance;

    public User(int id, String username, int balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getBalance() {
        return balance;
    }
}
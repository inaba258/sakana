package com.example.sakana;

public class Company {
    private String name;    // 企業名
    private String status;  // 状態
    //private String ;  増やす用

    public Company(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
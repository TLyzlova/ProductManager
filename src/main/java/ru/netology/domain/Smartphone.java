package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String brand;

    public Smartphone(){
        super();
    }

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}


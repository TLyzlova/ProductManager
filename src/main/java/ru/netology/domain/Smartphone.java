package ru.netology.domain;

public class Smartphone extends Product {
    private String brand;

    public Smartphone(){
        super(8, "Product", 355);
    }

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price, "Xiaomi");
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}


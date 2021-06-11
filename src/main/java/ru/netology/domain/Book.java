package ru.netology.domain;


public class Book extends Product {
    private String author;


    public Book() {
        super(8, "Product", 355);
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price, "Xiaomi");
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


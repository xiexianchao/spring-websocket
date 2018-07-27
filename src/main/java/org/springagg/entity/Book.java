package org.springagg.entity;

public class Book {
    private String name;
    private Double price;
    private Long num;

    public Book(String name, Double price, Long num) {
        this.name = name;
        this.price = price;
        this.num = num;
    }
    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}

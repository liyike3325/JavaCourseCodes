package com.bootcamp.spring02.bean02;

public class Car {

    private String brand;

    private double price;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "brand:" + brand + "," + "price:" + price;
    }
}

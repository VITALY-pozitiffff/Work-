package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String name, double price) {
        super(name);
        if (price <= 0) {
           throw new IllegalArgumentException("Цена должна быть больше 0") ;
        }
        this.price = price;
    }

    @Override
    public double getPrice() {

        return price;
    }

    @Override
    public String toString() {
        return  getName() +" " +"цена " + price ;
    }
}

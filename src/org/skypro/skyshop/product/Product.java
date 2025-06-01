package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;


public abstract class Product implements Searchable {
    private String name;


    public Product(String name) {
        if (name==null ||name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или null");
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    public boolean isSpecial() {
        return false;
    }
        public abstract double getPrice();

    @Override
    public String toString() {
        return "Название товара:  " + name ;
    }
}


package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket  {
    private Map<String,List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        List<Product> productList = products.computeIfAbsent(product.getName(), k -> new ArrayList<>());
        productList.add(product);
    }


    public void printContents() {
        double total = 0;
        int specialCount = 0;


        for (List<Product> productList : products.values()) {

            for (Product product : productList) {
                System.out.println(product.toString());
                total += product.getPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }


        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();


        List<Product> productList = products.get(name);

        if (productList != null) {

            removedProducts.addAll(productList);
            products.remove(name);
        }

        return removedProducts;
    }
}
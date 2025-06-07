package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket  {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public void printContents() {

        products.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);


        System.out.println("Итого: " + calculateTotal());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private double calculateTotal() {
        return products.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public List<Product> removeProductsByName(String name) {
            List<Product> removedProducts = products.remove(name);
            return removedProducts != null ? removedProducts : Collections.emptyList();
        }
    }


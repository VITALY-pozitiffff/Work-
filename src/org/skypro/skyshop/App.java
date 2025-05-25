package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

            Product product1 = new Product("Мороженое", 200);
            Product product2 = new Product("Пельмени", 456);
            Product product3 = new Product("Рыба", 455);
            Product product4 = new Product("Курица", 333);
            Product product5 = new Product("Сметана", 55);
            Product product6 = new Product("Торт", 967);

            ProductBasket basket = new ProductBasket();

            System.out.println("\n1. Добавление продуктов в корзину:");
            basket.addProduct(product1);
            basket.addProduct(product2);
            basket.addProduct(product3);
            basket.addProduct(product4);
            basket.addProduct(product5);

            System.out.println("\n2. Попытка добавить продукт в заполненную корзину:");
            basket.addProduct(product6);

            System.out.println("\n3. Содержимое корзины:");
            basket.printBasket();

            System.out.println("\n4. Стоимость корзины: " + basket.getTotalCost());

            System.out.println("\n5. Поиск товара 'Рыба': " + basket.containsProduct("Рыба"));

            System.out.println("\n6. Поиск товара 'Тушенка': " + basket.containsProduct("Тушенка"));

            System.out.println("\n7. Очищаем корзину");
            basket.clearBasket();

            System.out.println("\n8. Содержимое пустой корзины:");
            basket.printBasket();

            System.out.println("\n9. Стоимость пустой корзины: " + basket.getTotalCost());

            System.out.println("\n10. Поиск товара 'Мороженное' в пустой корзине: " + basket.containsProduct("Мороженное"));
        }
    }


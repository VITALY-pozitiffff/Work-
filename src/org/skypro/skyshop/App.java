package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new Product("Хуавей") {
            @Override
            public double getPrice() {
                return 15_000;
            }
        });
        basket.addProduct(new Product("Моторола") {
            @Override
            public double getPrice() {
                return 20_000;
            }
        });
        basket.addProduct(new Product("Сименс") {
            @Override
            public double getPrice() {
                return 30_000;
            }
        });


        //  Удаление существующего продукта
        System.out.println("Удаление существующих продуктов");
        List<Product> removed = basket.removeProductsByName("Хуавей");

        System.out.println("\nУдаленные продукты:");
        for (Product product : removed) {
            System.out.println(product.getName());
        }

        System.out.println("\nСодержимое корзины после удаления:");
        basket.printContents();

        // Сценарий 2: Удаление несуществующего продукта
        System.out.println("\nУдаление несуществующего продукта");
        removed = basket.removeProductsByName("Нокия");

        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("\nФинальное содержимое корзины:");
        basket.printContents();


        try {

            new SimpleProduct("Iphone", 100);
            new DiscountedProduct("Iphone", 10, 100);
            new DiscountedProduct("Samsung", 100, 90);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }


        SearchEngine<Searchable> productSearchEngine = new SearchEngine<>();
        productSearchEngine.add(new SimpleProduct("Iphone 15 pro", 77_000));
        productSearchEngine.add(new SimpleProduct("\nIphone 16 pro max", 137_000));
        productSearchEngine.add(new SimpleProduct("\nIphone 15 pro max", 105_000));


        try {

            Searchable result = productSearchEngine.findBestMatch("Iphone");
            System.out.println("Найден наилучший результат: " + result.getSearchTerm());
            result = productSearchEngine.findBestMatch("Samsung");


        } catch (BestResultNotFound e) {
            System.err.println("Ошибка поиска: " + e.getMessage());
        }


        productSearchEngine.add(new DiscountedProduct("\nIphone 15 pro max со скидкой", 105_000, 57));
        productSearchEngine.add(new FixPriceProduct("\nТовар FIXE PRICE"));

        System.out.println();


        productSearchEngine.add(new Article("\nОбзор нового Iphone", "Все минусы и плюсы нового Iphone"));
        productSearchEngine.add(new Article("\nКак телефон забирает вас из семьи", "Как избавиться от такой зависимости как сидеть в телефоне"));




        System.out.println("Поиск по слову 'Iphone':");

        Set<Searchable> results  = productSearchEngine.search("Iphone");

        for (Searchable item : results) {
            System.out.println(item.getName() + " [" + item.getContentType() + "]");
        }

    }
}


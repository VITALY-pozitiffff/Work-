package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;


import java.util.Arrays;
import java.util.List;


public class App {
        public static void main(String[] args) {

                ProductBasket basket=new ProductBasket();
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


                SearchEngine searchEngine=new SearchEngine();
                searchEngine.add (new SimpleProduct("Iphone 15 pro", 77_000));
                searchEngine.add (new SimpleProduct("\nIphone 16 pro max", 137_000));
                searchEngine.add (new SimpleProduct("\nIphone 15 pro max", 105_000));


                try {

                        Searchable result = searchEngine.findBestMatch("Iphone");
                        System.out.println("Найден наилучший результат: " + result.getSearchTerm());
                        result = searchEngine.findBestMatch("Samsung");


                } catch (BestResultNotFound e) {
                        System.err.println("Ошибка поиска: " + e.getMessage());
                }


                searchEngine.add (new DiscountedProduct("\nIphone 15 pro max со скидкой", 105_000, 57));
                searchEngine.add (new FixPriceProduct("\nТовар FIXE PRICE"));

                System.out.println();


                searchEngine.add(new Article("\nОбзор нового Iphone", "Все минусы и плюсы нового Iphone"));
                searchEngine.add(new Article("\nКак телефон забирает вас из семьи", "Как избавиться от такой зависимости как сидеть в телефоне"));

                System.out.println("Поиск по слову 'Iphone':");
                List<Searchable> results = searchEngine.search("Iphone");
                for (Searchable result : results) {
                        System.out.println(result.getSearchTerm());
                }


                System.out.println("\nПоиск по слову 'Обзор': ");
                 results = searchEngine.search("Обзор");
                for (Searchable result : results) {
                        System.out.println(result.getSearchTerm());
                }


                System.out.println("\nПоиск по слову 'телефон':");
                results = searchEngine.search("телефон");
                for (Searchable result : results) {
                        System.out.println(result.getSearchTerm());
                }


        }

}


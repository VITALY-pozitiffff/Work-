package org.skypro.skyshop.product;

public class BestResultNotFound extends Exception {

    public BestResultNotFound(String search) {
        super("Не найдено подходящих результатов для запроса "+search+ " ");


    }
}

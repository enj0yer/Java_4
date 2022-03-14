package ru.exam;

/*
Торговые роботы
item - название, цена
Пример работы робота - если цена item > 60 - покупай на 100 рублей
                       если цена item > 80 - продавай на 100 рублей
Роботы привязаны к счету
Счет имеет деньги
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Wallet w = new Wallet(1000);
        Robot<Item, Wallet> r = new Robot<Item, Wallet>(item -> item.getValue() > 60, (item, wallet) -> wallet.buy(item, 420), List.of(w));
        Item i = new Item("Apple", 100, List.of(r));

    }
}

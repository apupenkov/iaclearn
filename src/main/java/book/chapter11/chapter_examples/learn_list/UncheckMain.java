package book.chapter11.chapter_examples.learn_list;


import book.chapter11.chapter_examples.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class UncheckMain {
    public static void main(String[] args) {
        List raw = List.of(
                new Order(231, 21.f),
                new ArrayList(),
                new Order(217, 17.f),
                "Unitas"
        );
        Order or1 = (Order) raw.get(0);
        ArrayList or2 = (ArrayList) raw.get(1);
        Order or3 = (Order) raw.get(2);
        String or4 = (String) raw.get(3);
        raw.forEach(System.out::println);

        List<Order> orders = List.of(
            new Order(231, 12.f),
            new Order(543, 29.f),
            // new ArrayList(),
            new Order(217, 17.f)
        );

        orders.forEach(System.out::println);
    }
}

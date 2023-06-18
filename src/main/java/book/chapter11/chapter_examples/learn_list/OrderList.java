package book.chapter11.chapter_examples.learn_list;

import book.chapter11.chapter_examples.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<Order> orders;
    public OrderList() {
        this.orders = new ArrayList<Order>();
    }
    public OrderList(List<Order> orders) {
        this.orders = orders;
    }

    // Возвращает список, который можно изменять.
//    public List<Order> getOrders() {
//        return orders;
//    }

    public List<Order> getOrders() {
        return List.copyOf(orders);
    }

    // Или так
//    public List<Order> getOrders() {
//        Order[] array = {};
//        return List.of(orders.toArray(array));
//    }
}

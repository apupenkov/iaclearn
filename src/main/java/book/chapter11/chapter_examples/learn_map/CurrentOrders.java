package book.chapter11.chapter_examples.learn_map;

import book.chapter11.chapter_examples.entity.Key;
import book.chapter11.chapter_examples.entity.Order;

import java.util.WeakHashMap;

public class CurrentOrders {
    private WeakHashMap<Key, Order> orders = new WeakHashMap<Key, Order>();

    public Order put(Key key, Order value) {
        return orders.put(key, value);
    }

    public Order get(Object key) {
        return orders.get(key);
    }

    public int size() {
        return orders.size();
    }
}

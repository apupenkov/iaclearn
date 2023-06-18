package book.chapter11.chapter_examples.learn_iterator;

import book.chapter11.chapter_examples.entity.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorMain {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>() {
            {
                add(new Order(231, 12.));
                add(new Order(289, 29.));
                add(new Order(747, 32.));
                add(new Order(517, 18.));
                add(new Order(414, 17.));
                add(new Order(777, 10.));
            }
        };
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order);
        }
        // or
        // orders.forEach(System.out::println();

        final int controlAmount = 20;
        final int discountPercent = 10;
        while (iterator.hasNext()) {
            Order current = iterator.next();
            if (current.getAmount() < controlAmount) {
                iterator.remove();
                continue;
            }
            current.setAmount(current.getAmount() * (100 - discountPercent) / 100.0);
        }
        System.out.println(orders);

        // or:
        orders.removeIf(o -> o.getAmount() <= controlAmount);
        orders.forEach(o -> o.setAmount(o.getAmount() * (100 - discountPercent) / 100.0));
        orders.forEach(System.out::println);


        // Exceptions:
        List<Order> orders1 = new ArrayList<>();
        orders1.add(new Order(555, 55.));
        Iterator<Order> iterator1 = orders1.iterator();
        orders1.add(new Order(433, 34.5f)); // or orders.remove(0);
        while (iterator1.hasNext()) { // generation exception
            System.out.println(iterator1.next());
        }
    }

}

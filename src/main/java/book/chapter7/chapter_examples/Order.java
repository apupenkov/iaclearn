package book.chapter7.chapter_examples;

import java.util.Comparator;

public class Order {
    private long orderId;
    private double amount;

    public long getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public static class IdComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            return Long.compare(o1.orderId, o2.orderId);
        }
    }

    public static class AmountComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            return Double.compare(o1.getAmount(), o2.getAmount());
        }
    }

}

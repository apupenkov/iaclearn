package book.chapter11.chapter_examples.learn_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Отношение HAS-A
public class OrderType implements Iterable<String> {
    private int orderId;
    private List<String> currencyNames = new ArrayList<>(); /* SEK, DKK, NOK, CZK
                                                                 GBP, EUR, PLN */

    public OrderType(int orderId) {
        this.orderId = orderId;
    }

    public List<String> getCurrencyNames() {
        return List.copyOf(currencyNames);
    }

    public boolean add(String e) {
        return currencyNames.add(e);
    }

    @Override
    public Iterator<String> iterator() {
        return currencyNames.iterator();
    }
}

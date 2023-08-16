package book.chapter12.entities.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Library {
    private Map<String, Book> books;

    public Library(List<Book> books) {
        this.books = new ConcurrentHashMap<>();
        for (Book book : books) {
            this.books.put(book.toString(), book);
        }
    }

    public Book getRandomBook() {
        if (!books.isEmpty()) {
            List<String> keys = new ArrayList<>(books.keySet());
            int index = (int) (Math.random() * keys.size());
            Book book = books.get(keys.get(index));
            if (book != null) {
                books.remove(book.toString(), book);
                return book;
            }
        }
        return null;
    }
}

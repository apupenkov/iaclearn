package book.chapter12.entities.library;

import java.util.List;

public class Reader implements Runnable{
    private String name;
    private List<Book> books;
    private Library library;

    public Reader(String name, List<Book> books, Library library) {
        this.name = name;
        this.books = books;
        this.library = library;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Book book = library.getRandomBook();
                if (book == null) {
                    System.out.println(name + " закончил чтение");
                    break;
                }

                if (book.isAvailableForReadingRoom()) {
                    System.out.println(name + " читает в читальном зале: " + book);
                } else {
                    boolean borrowed = book.borrow();
                    if (borrowed) {
                        System.out.println(name + " взял на руки: " + book);
                        books.add(book);
                    } else {
                        System.out.println(name + " не смог взять: " + book);
                    }
                }

                Thread.sleep(1000); // Имитация чтения
            }

            for (Book book : books) {
                if (!book.isAvailableForReadingRoom()) {
                    book.returnBook();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

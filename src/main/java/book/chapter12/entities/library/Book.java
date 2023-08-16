package book.chapter12.entities.library;

import java.util.concurrent.Semaphore;

public class Book {
    private String title;
    private boolean availableForReadingRoom;
    private Semaphore availableCopies;

    public Book(String title, boolean availableForReadingRoom) {
        this.title = title;
        this.availableForReadingRoom = availableForReadingRoom;
        this.availableCopies = new Semaphore(1, true);
    }

    public boolean isAvailableForReadingRoom() {
        return availableForReadingRoom;
    }

    public boolean borrow() throws InterruptedException {
        return availableCopies.tryAcquire();
    }

    public void returnBook() {
        availableCopies.release();
    }

    @Override
    public String toString() {
        return title;
    }
}

package book.chapter7.chapter_examples;

public interface ServiceApp {
    default void anOperation() { // public
        System.out.println("ServiceApp anOperation");
    }
}

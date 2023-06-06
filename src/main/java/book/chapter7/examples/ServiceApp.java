package book.chapter7.examples;

public interface ServiceApp {
    default void anOperation() { // public
        System.out.println("ServiceApp anOperation");
    }
}

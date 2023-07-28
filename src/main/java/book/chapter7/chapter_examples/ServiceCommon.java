package book.chapter7.chapter_examples;

public interface ServiceCommon extends Service, ServiceApp{
    @Override
    default void anOperation() {
        System.out.println("necessary method implementation");
    }
}

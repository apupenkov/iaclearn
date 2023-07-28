package book.chapter7.chapter_examples;

public class ServiceTwoImpl implements Service, ServiceApp{
    @Override
    public void anOperation() {
        System.out.println("necessary method implementation");
    }

    @Override
    public int define(int x, int y) {
        return x - y;
    }

    @Override
    public void load() {
    }
}

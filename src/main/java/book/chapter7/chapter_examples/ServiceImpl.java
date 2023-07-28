package book.chapter7.chapter_examples;

public class ServiceImpl implements Service{
    @Override
    public int define(int x, int y) {
        return x + y;
    }

    @Override
    public void load() {
        System.out.println("load()");
    }
}

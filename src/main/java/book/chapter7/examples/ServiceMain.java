package book.chapter7.examples;

public class ServiceMain {
    public static void main(String[] args) {
        Service.action();
        ServiceImpl service = new ServiceImpl();
        service.define(1, 2);
        service.load();
        service.anOperation();
    }
}

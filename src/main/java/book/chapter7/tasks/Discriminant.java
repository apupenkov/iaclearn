package book.chapter7.tasks;

@FunctionalInterface
public interface Discriminant<T, R> {
    R result(T t1, T t2, T t3);
}

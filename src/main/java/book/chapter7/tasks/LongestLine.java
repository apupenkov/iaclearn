package book.chapter7.tasks;

@FunctionalInterface
public interface LongestLine<T, R> {
    R apply(T t1, T t2);
}

package book.chapter11.chapter_examples.learn_linked_list_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>() {
            {
                this.offer("Jean");
            }
        };
        queue.add("Dress");
        queue.offer("Gloves");
        queue.offer("T-Shirt");

        // Вывести отфильтрованные значений, без изменения исходной очереди.
        queue.stream()
                .filter(s -> !s.endsWith("s"))
                .forEach(System.out::println);

        System.out.println("__________");
        queue.forEach(System.out::println);

        // Действие с изменением исходной коллекции.
        queue.removeIf(s -> s.endsWith("s"));
        System.out.println("__________");
        queue.forEach(System.out::println);
    }
}

package book.chapter11.chapter_examples.learn_linked_list_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityMain {
    public static void main(String[] args) {
        Queue<String> prior = new PriorityQueue<>(Comparator.reverseOrder());
        prior.offer("J");
        prior.offer("A");
        prior.offer("V");
        prior.offer("A");
        prior.offer("1");
        prior.offer("4");
        while (!prior.isEmpty()) {
            System.out.println(prior.poll());
        }
    }
}

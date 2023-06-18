package book.chapter11.chapter_examples.learn_deque_array_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeMain {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // like as stack
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(11);
        queue.offer(22);
        queue.offer(33);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // like as queue
        }
    }
}

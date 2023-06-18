package book.chapter11.chapter_examples.learn_list;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(42);
        list.add(null);
        list.add(50);
        list.add(77);
        System.out.println(list);
        list.add(5, 87);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}

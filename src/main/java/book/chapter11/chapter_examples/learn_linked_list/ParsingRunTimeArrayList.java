package book.chapter11.chapter_examples.learn_linked_list;

import java.util.ArrayList;
import java.util.List;

public class ParsingRunTimeArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5_000_000; i++) {
            list.add(i);
        }

        long start=System.currentTimeMillis();

        for (int i=0;i<100;i++){
            list.add(2_000_000, Integer.MAX_VALUE);
        }
        System.out.println("Время работы для ArrayList (в миллисекундах) = " + (System.currentTimeMillis()-start));
    }
}

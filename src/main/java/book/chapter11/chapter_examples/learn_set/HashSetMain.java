package book.chapter11.chapter_examples.learn_set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("8Y");
        hashSet.add("2Y");
        hashSet.add("2Y");
        hashSet.add("8Y");
        hashSet.add("6Y");
        hashSet.add("5Y");
        hashSet.add("Y-");
        hashSet.stream()
                .peek(System.out::println)
                .forEach(s -> System.out.println(" " + s.hashCode()));

        Set<String> set = Set.of("2Y", "8Y", "6Y", "5Y", "Y-");
        System.out.println(set);
        TreeSet<String> treeSet = new TreeSet<>(set);
        treeSet.add("Y-");
        System.out.println(treeSet);
        System.out.println(treeSet.last() + " " + treeSet.first());
    }
}

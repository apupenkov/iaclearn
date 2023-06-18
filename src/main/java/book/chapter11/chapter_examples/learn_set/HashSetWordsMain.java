package book.chapter11.chapter_examples.learn_set;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class HashSetWordsMain {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(100_000);
        Scanner scan;
        try {
            scan = new Scanner(new File("src\\test\\resources\\words.txt"));
            scan.useDelimiter("[\\p{Punct}\\s]+");
            while (scan.hasNext()) {
                String word = scan.next();
                words.add(word.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(words);
        TreeSet<String> treeSet = new TreeSet<>(words);
        System.out.println(treeSet);
    }
}

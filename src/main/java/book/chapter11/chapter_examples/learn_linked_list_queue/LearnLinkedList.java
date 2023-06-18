package book.chapter11.chapter_examples.learn_linked_list_queue;

import java.util.LinkedList;

public class LearnLinkedList {
    /*
    * Original:
    * https://javarush.com/groups/posts/1938-linkedlist
    * */
    public static void main(String[] args) {
        String str1 = new String("Hello world!");
        String str2 = new String("My name is Earl");
        String str3 = new String("I love Java");
        String str4 = new String("I live in Moscow");

        // Создание LinkedList
        LinkedList<String> earlBio = new LinkedList<>();
        earlBio.add(str1);
        earlBio.add(str2);
        earlBio.add(str3);
        earlBio.add(str4);

        System.out.println(earlBio);

        LinkedList<String> earlBio1 = new LinkedList<>();
        earlBio1.add(str1);
        earlBio1.add(str3);
        // Вставляем между 1 записью и 3
        earlBio1.add(1, str2);

        // Удаление из списка записи
        earlBio1.remove(1);

        System.out.println(earlBio1);
    }
}

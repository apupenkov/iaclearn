package book.chapter11.chapter_examples.learn_linked_list_queue;

import java.util.Comparator;

public class StringBuilderWrapper implements Comparable<StringBuilder> {
    private StringBuilder content = new StringBuilder();

    @Override
    public int compareTo(StringBuilder o) {
        return content.toString().compareTo(o.toString());
    }
}

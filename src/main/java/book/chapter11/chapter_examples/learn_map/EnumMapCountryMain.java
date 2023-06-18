package book.chapter11.chapter_examples.learn_map;

import book.chapter11.chapter_examples.entity.Country;

import java.util.EnumMap;

public class EnumMapCountryMain {
    public static void main(String[] args) {
        EnumMap<Country, Integer> map = new EnumMap<>(Country.class);
        map.put(Country.POLAND, 8);
        map.put(Country.UKRAINE, 1);
        map.put(Country.BELARUS, 0);
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}

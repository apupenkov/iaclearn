package book.chapter11.chapter_examples.learn_set;

import book.chapter11.chapter_examples.entity.Country;

import java.util.EnumSet;

import static book.chapter11.chapter_examples.entity.Country.*;

public class EnumSetCountryMain {
    public static void main(String[] args) {
        EnumSet<Country> asiaCountries = EnumSet.of(ARMENIA, INDIA, KAZAKHSTAN);
        String nameCountry = "Belarus";
        Country current = Country.valueOf(nameCountry.toUpperCase());
        if (asiaCountries.contains(current)) {
            System.out.print(current + " is in Asia");
        } else {
            System.out.print(current + " is not in Asia");
        }
    }
}

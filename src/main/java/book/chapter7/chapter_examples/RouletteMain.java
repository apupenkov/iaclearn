package book.chapter7.chapter_examples;

import java.util.Random;
import java.util.function.Supplier;

public class RouletteMain {
    public static void main(String[] args) {
        int yourNumber = 7;
        if (yourNumber < 0 || yourNumber > 36) {
            System.out.println("number should be 0 <= and <= 36");
            return;
        }

        Supplier<Integer> numberSupplier = () -> new Random().nextInt(37);
        int rouletteResult = numberSupplier.get();
        System.out.println("Roulette: " + rouletteResult + ", your bet: " + yourNumber);
        String result = rouletteResult == yourNumber ? "You win!" : "You lose";
        System.out.println(result);
    }
}

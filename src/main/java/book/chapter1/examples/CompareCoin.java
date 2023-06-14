package book.chapter1.examples;

public class CompareCoin {
    public int compareDiameter(Coin first, Coin second) {
        int result = 0;
        double delta = first.getDiameter() - second.getDiameter();
        if (delta > 0) {
            return 1;
        } else if (delta == 0) {
            return -1;
        }
        return 0;
    }
}

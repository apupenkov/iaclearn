package book.chapter1.tasks;

public class SummaArgumentNumbers {
    public static void main(String[] args) {
        int summa = 0;
        for (String num : args) {
            summa += Integer.parseInt(num);
        }
        System.out.println("Summa argument numbers: " + summa);
    }
}

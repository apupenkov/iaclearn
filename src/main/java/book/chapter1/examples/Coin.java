package book.chapter1.examples;

public class Coin {
    private double diameter;
    private double weight;
    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        if (diameter > 0) {
            this.diameter = diameter;
        } else {
            System.out.println("Negative diameter!");
        }
    }

    public double takeWeight() {
        return weight;
    }

    public void setWeight(double value) {
        this.weight = value;
    }
}

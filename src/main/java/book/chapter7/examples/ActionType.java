package book.chapter7.examples;

public class ActionType {
    private double x;
    private double y;
    public ActionType(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double action(ShapeService service) {
        return 10 * service.perimeter(x, y);
    }

    // calling the functional interface:
    double result = new ActionType(3, 5).action((a, b) -> (a + b) * 4);
}

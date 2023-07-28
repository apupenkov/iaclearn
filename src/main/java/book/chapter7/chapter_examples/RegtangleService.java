package book.chapter7.chapter_examples;

public class RegtangleService implements ShapeService {
    @Override
    public double perimeter(double a, double b) {
        return 2 * (a + b);
    }

//    ShapeService rectangleService = new ShapeService() {
//        @Override
//        public double perimeter(double a, double b) {
//            return 2 * (a + b);
//        }
//    }

//    ShapeService rectangleService = (double a, double b) -> {
//        return 2 * (a + b);
//    }

//    ShapeService rectangleService = (double a, double b) -> 2 * (a + b);

    ShapeService rectangleService = (a, b) -> 2 * (a + b);

    // lambda expression
    // ShapeService rectangleService = (a, b) -> 2 * (a + b);


}

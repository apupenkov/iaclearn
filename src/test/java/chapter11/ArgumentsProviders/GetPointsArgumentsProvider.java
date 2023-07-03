package chapter11.ArgumentsProviders;

import book.chapter11.CollectionSolver;
import book.chapter11.entities.Point;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GetPointsArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        List<Point> inputPoints1 = CollectionSolver.getPoints(1, 2, 1, 2);
        List<Point> expectedPoints = Arrays.asList(
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 1),
                new Point(2, 2)
        );

        return Stream.of(Arguments.of(inputPoints1, expectedPoints));
    }
}

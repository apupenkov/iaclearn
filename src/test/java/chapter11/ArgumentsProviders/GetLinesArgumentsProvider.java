package chapter11.ArgumentsProviders;

import book.chapter11.CollectionSolver;
import book.chapter11.entities.Line;
import book.chapter11.entities.Point;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GetLinesArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        List<Point> points1 = CollectionSolver.getPoints(1, 2, 1, 2);
        List<Line> inputLines1 = CollectionSolver.getLines(points1);

        List<Line> expectedLines1 = Arrays.asList(
                new Line(new Point(1, 1), new Point(1, 2)),
                new Line(new Point(1, 1), new Point(2, 1)),
                new Line(new Point(1, 1), new Point(2, 2)),
                new Line(new Point(1, 2), new Point(2, 1)),
                new Line(new Point(1, 2), new Point(2, 2)),
                new Line(new Point(2, 1), new Point(2, 2))
        );

        return Stream.of(
                Arguments.of(inputLines1, expectedLines1)
        );
    }
}

package chapter11.ArgumentsProviders;

import book.chapter11.CollectionSolver;
import book.chapter11.entities.Line;
import book.chapter11.entities.Point;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.*;
import java.util.stream.Stream;

public class LineArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        List<Point> points = CollectionSolver.getPoints(1, 4, 1, 4);
        return Stream.of(
                Arguments.of(
                        points,
                        CollectionSolver.getLines(points),
                        new HashMap<Line, Set<Point>>() {{
                            put(
                                    new Line(new Point(1, 1), new Point(1, 4)),
                                    new HashSet<>(Arrays.asList(
                                            new Point(1, 2),
                                            new Point(1, 3)
                                    )));
                            put(
                                    new Line(new Point(1, 1), new Point(4, 1)),
                                    new HashSet<>(Arrays.asList(
                                            new Point(2, 1),
                                            new Point(3, 1)
                                    )));
                            put(
                                    new Line(new Point(1, 2), new Point(4, 2)),
                                    new HashSet<>(Arrays.asList(
                                            new Point(2, 2),
                                            new Point(3, 2)
                                    )));
                        }}
                )
        );
    }
}

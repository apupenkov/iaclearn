package collectionutil;

import collections.CollectionUtil;
import collections.model.Line;
import collections.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindTests {
    @Nested
    @DisplayName("Unit tests for CollectionUtil generateLines, contains, round")
    class CollectionUtilTests {
//        @ParameterizedTest("{index}, {display_name}")
//        @ArgumentsSource()
        @Test
        void generateLines() {
            List<Point> points = new ArrayList<>();
            for (int i = 1; i < 5; i++) {
                for (int j = 1; j < 5; j++) {
                    points.add(new Point(i, j));
                }
            }
            Map<Line, Set<Point>> map = CollectionUtil.generateLines(points);
            map.forEach((k, v) -> System.out.println(k + " = " + v));

        }
    }
}

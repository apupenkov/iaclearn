package collections;

import collections.model.Line;
import collections.model.Point;

import java.util.*;

public class CollectionUtil {

    public static Map<Line, Set<Point>> generateLines(List<Point> points) {

        points = points.stream().distinct().sorted(Comparator.comparingInt(Point::getX)).toList();

        Map<Line, Set<Point>> result = new LinkedHashMap<>();
        Map<Point, List<Line>> pointGroups = new LinkedHashMap<>();

        for (int i = 0; i < points.size() - 1; i++) {
            ArrayList<Line> linesForTempPointList = new ArrayList<>();
            for (int j = i; j < points.size(); j++) {
                if (j + 1 < points.size()) {
                    linesForTempPointList.add(new Line(points.get(i), points.get(j + 1)));

                }
            }
            pointGroups.put(points.get(i), linesForTempPointList);
        }

        for (Map.Entry<Point, List<Line>> entry: pointGroups.entrySet()) {

            List<Line> lines = entry.getValue();

            for (int i = 0; i < lines.size(); i++) {
                Line mainLine = lines.get(i);
                for (int j = i + 1; j < lines.size(); j++) {
                    Line tempLine = lines.get(j);
                    Point tempEndPoint = tempLine.getEndPoint();
                    double vectorSum = mainLine.getLength() +
                            new Line(mainLine.getEndPoint(), tempEndPoint).getLength();
                    if (round(vectorSum, 4) == round(tempLine.getLength(), 4)) {
                        mainLine.addPoint(tempEndPoint);
                        mainLine.setEndPoint(tempEndPoint);
                        mainLine.setLineLength(tempLine.getStartPoint(), tempEndPoint);
                    }

                }

                if (!contains(result.keySet(), mainLine)) {
                    result.put(mainLine, mainLine.getPoints());
                }

                if (!result.containsKey(mainLine)) {
                    result.put(mainLine, mainLine.getPoints());
                }
            }
        }

        return result;
    }

    private static boolean contains (Set<Line> lines, Line mainLine) {
        boolean contains = false;
        for (Line line : lines) {
            if (line.equals(mainLine)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    private static double round(double num, int numCountAfter) {
        String str0 = String.valueOf(num);
        if(str0.length() < 4) {
            return num;
        } else {
            String str1 = str0.substring(0, str0.indexOf('.'));
            return Double.parseDouble(str1 + str0.substring(str0.indexOf('.'), str0.indexOf('.') + numCountAfter + 1));
        }
    }
}

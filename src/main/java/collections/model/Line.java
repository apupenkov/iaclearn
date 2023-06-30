package collections.model;

import java.util.HashSet;
import java.util.Set;

public class Line {

    private final Point startPoint;
    private Point endPoint;
    private double length;
    private final Set<Point> points = new HashSet<>();

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        setLineLength(startPoint, endPoint);
        points.add(startPoint);
        points.add(endPoint);
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public double getLength() {
        return length;
    }

    public void setLineLength(Point startPoint, Point endPoint) {
        try {
            length = Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2)
                    + Math.pow(endPoint.getY() - startPoint.getY(), 2));
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Проверьте координаты вектора.\n" + e.getMessage());
        }
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return (line.getEndPoint().getY() - startPoint.getY()) * (endPoint.getX() - startPoint.getX())
                == (endPoint.getY() - startPoint.getY()) * (line.getEndPoint().getX() - startPoint.getX())
                && (line.getStartPoint().getY() - startPoint.getY()) * (endPoint.getX() - startPoint.getX())
                == (endPoint.getY() - startPoint.getY()) * (line.getStartPoint().getX() - startPoint.getX());
    }

    @Override
    public String toString() {
        return "Line{" + "startPoint=" + startPoint + ", endPoint=" + endPoint + '}';
    }

    @Override
    public int hashCode() {
        return 1;
    }
}

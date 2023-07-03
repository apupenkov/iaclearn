package book.chapter11.entities;

import java.util.Objects;
import java.util.Set;

public class Line {
    private final Point p1, p2;
//    private Set<Point>

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public boolean pointOnLine(Point p) {
        if (p1.equals(p) || p2.equals(p1)) return false;

        int dx1 = p2.getX() - p1.getX();
        int dy1 = p2.getY() - p1.getY();

        int dx = p.getX() - p1.getX();
        int dy = p.getY() - p1.getY();

        return dx1 * dy - dx * dy1 == 0;
    }

    public boolean parallelX(Point point) {
        return p1.equalsX(point) && p2.equalsX(point);
    }

    public boolean parallelY(Point point) {
        return p1.equalsY(point) && p2.equalsY(point);
    }

    public double calculateDistance() {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calculateDistance(Point p1, Point p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line line)) return false;
        return Objects.equals(p1, line.p1) && Objects.equals(p2, line.p2);
    }

    @Override
    public int hashCode() {
        int result = p1.hashCode();
        result = 31 * result + p2.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + p1 + ";" + p2 + ")";
    }
}
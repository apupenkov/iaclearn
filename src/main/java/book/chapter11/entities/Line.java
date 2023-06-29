package book.chapter11.entities;

import java.util.Objects;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public boolean pointOnLine(Point p) {
        if (p1.equals(p) || p2.equals(p1)) return false;

        if (parallelX(p))
            return p1.getY() < p.getY() && p.getY() < p2.getY();

        if (parallelY(p))
            return p1.getX() < p.getX() && p.getX() < p2.getX();

        return (calculateDistance(this.p1, p) + calculateDistance(this.p2, p)) == calculateDistance() &&
                (p1.getX() - p.getX()) * (p.getY() - p2.getY()) == (p.getX() - p2.getX()) * (p1.getY() - p.getY());
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
        return Objects.hash(p1, p2);
    }

    @Override
    public String toString() {
        return "(" + p1 + ";" + p2 + ")";
    }
}
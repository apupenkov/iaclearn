package book.chapter11.entities;

public class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return ((Point) o).getX() == x && ((Point) o).getY() == y;
//        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    public boolean equalsX(Object o) {
        if (!(o instanceof Point point)) return false;
        return ((Point) o).getX() == x;
    }

    public boolean equalsY(Object o) {
        if (!(o instanceof Point point)) return false;
        return ((Point) o).getY() == y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
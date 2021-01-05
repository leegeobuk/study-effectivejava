package chapter3.equals;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
}

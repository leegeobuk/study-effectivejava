package chapter3.equals;

import java.awt.*;
/*
ColorPoint class implemented by using composition instead of extending Point class.
This enables comparing Point and ColorPoint without breaking the the protocols of equals() method.
 */
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return point.equals(cp.point) && color.equals(cp.color);
    }

    public static void main(String[] args) {
        Point p1 = new Point(10, 5);
        ColorPoint cp1 = new ColorPoint(10, 5, Color.GRAY);

        System.out.println(p1.equals(cp1));
        System.out.println(cp1.equals(p1));
        System.out.println(p1.equals(cp1.asPoint()));
        System.out.println(cp1.asPoint().equals(p1));
    }
}

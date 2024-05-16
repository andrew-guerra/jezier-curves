package com.github.andrewguerra.lib.bezier;

public class Point {
    public final double x, y;
    private static final double DELTA = 0.001;

    public static final Point ZERO = new Point(0, 0);

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Point otherPoint) {
        return new Point(this.x + otherPoint.x, this.y + otherPoint.y);
    }

    public Point scale(double factor) {
        return new Point(this.x * factor, this.y * factor);
    }

    public double distance(Point otherPoint) {
        double xDelta = this.x - otherPoint.x;
        double yDelta = this.y - otherPoint.y;

        return Math.sqrt(xDelta * xDelta + yDelta * yDelta);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj.getClass() != Point.class) {
            return false;
        }

        Point point = (Point) obj;

        return this.equalsDelta(point);
    }

    private boolean equalsDelta(Point otherPoint) {
        return Math.abs(this.x - otherPoint.x) <= DELTA && Math.abs(this.y - otherPoint.y) <= DELTA;
    }
}

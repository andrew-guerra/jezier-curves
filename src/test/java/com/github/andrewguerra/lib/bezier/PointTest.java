package com.github.andrewguerra.lib.bezier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {
    @Test
    public void testConstructor() {
        Point point = new Point(0, 0);

        assertEquals("(0.00, 0.00)", point.toString());
    }

    @Test
    public void testAdd() {
        Point point1 = new Point(0, 1);
        Point point2 = new Point(1, 0);
        Point addPoint1ToPoint2 = point1.add(point2);
        Point addPoint2ToPoint1 = point2.add(point1);
        Point expectedPoint = new Point(1, 1);

        assertEquals(addPoint1ToPoint2, addPoint2ToPoint1);
        assertEquals(expectedPoint, addPoint1ToPoint2);
    }

    @Test
    public void testDistance() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 0);
        double distancePoint1ToPoint2 = point1.distance(point2);
        double distancePoint2ToPoint1 = point2.distance(point1);

        assertEquals(distancePoint1ToPoint2, distancePoint2ToPoint1, 0.01);
        assertEquals(1, distancePoint1ToPoint2, 0.01);
    }

    @Test
    public void testToString() {
        Point point = new Point(0, 0);

        assertEquals("(0.00, 0.00)", point.toString());
    }

    @Test
    public void testEquals() {

    }
}

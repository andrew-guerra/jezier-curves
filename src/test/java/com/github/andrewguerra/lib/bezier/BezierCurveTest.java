package com.github.andrewguerra.lib.bezier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BezierCurveTest {
    public final BezierCurve standardCurve = new BezierCurve(new Point[]{Point.ZERO, new Point(0.5, 0.5), new Point(1, 0)});

    @Test 
    public void testInterpolationStart() {
        Point actual = standardCurve.interpolate(0);
        Point expected = Point.ZERO;

        assertEquals(expected, actual);
    }

    @Test 
    public void testInterpolationEnd() {
        Point actual = standardCurve.interpolate(1);
        Point expected = new Point(1, 0);

        assertEquals(expected, actual);
    }
}

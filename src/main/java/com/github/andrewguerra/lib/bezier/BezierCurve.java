package com.github.andrewguerra.lib.bezier;

import com.github.andrewguerra.lib.math.MathTools;

public class BezierCurve {
    private final Point[] points;
    private final int bezierDegree;

    public BezierCurve(Point[] points) {
        this.points = points;
        this.bezierDegree = points.length - 1;
    }

    public Point interpolate(double t) {
        if(t < 0 || t > 1) {
            throw new IllegalArgumentException("Interpolation argument must be in range [0,1]");
        }

        Point interpolatedPoint = Point.ZERO;

        for(int i = 0; i <= this.bezierDegree; i++) {
            interpolatedPoint = interpolatedPoint.add(this.points[i].scale(MathTools.binomialCoefficient(this.bezierDegree, i) * Math.pow(t, i) * Math.pow(1 - t, this.bezierDegree - i)));
        }

        return interpolatedPoint;
    }
}

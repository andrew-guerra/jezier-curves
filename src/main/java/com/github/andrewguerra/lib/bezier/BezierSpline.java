package com.github.andrewguerra.lib.bezier;

public class BezierSpline {
    private BezierCurve[] curves;

    public BezierSpline(Point[] points, int bezierDegree) {
        int numberCurves = (int) Math.ceil(((double) points.length) / bezierDegree);
        curves = new BezierCurve[numberCurves];

        int startIndex, endIndex;

        for(int i = 0; i < curves.length; i++) {
            startIndex = i * bezierDegree;
            endIndex = startIndex + bezierDegree;

            if(endIndex >= points.length) {
                endIndex = points.length - 1;
            }

            curves[i] = new BezierCurve(subset(points, i, i));
        }   
    }

    public Point interpolate(double t) {
        return Point.ZERO;
    }

    public Point[] subset(Point[] points, int startIndex, int endIndex) {
        Point[] pointsSubset = new Point[endIndex - startIndex];

        for(int i = startIndex; i <= endIndex; i++) {
            pointsSubset[i - startIndex] = points[i];
        }

        return pointsSubset;
    }
}

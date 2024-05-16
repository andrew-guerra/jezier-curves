package com.github.andrewguerra.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.github.andrewguerra.lib.bezier.BezierCurve;
import com.github.andrewguerra.lib.bezier.Point;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class BezierToCSV {
    private static BezierCurve generateBezierCurve(String bezierCurveFilePath) {
        File file = new File(bezierCurveFilePath);
        try {
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);

            List<String[]> rows = csvReader.readAll();
            csvReader.close();

            Point[] points = new Point[rows.size()];

            for(int i = 0; i < rows.size(); i++) {
                points[i] = new Point(Double.parseDouble(rows.get(i)[0]), Double.parseDouble(rows.get(i)[1]));
            }

            for (Point point : points) {
                System.out.println(point);
            }

            return new BezierCurve(points);
         } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void writeBezierCurveCSV(String destinationPath, BezierCurve curve, double delta) {
        File file = new File(String.format("%s.csv", destinationPath));

        try {
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            for(double t = 0; t <= 1; t += delta) {
                Point point = curve.interpolate(t);
                csvWriter.writeNext(new String[]{String.format("%f", point.x), String.format("%f", point.y)});
            }

            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Usuage: [bezier curve points file] [destination file] [delta]");
            return;
        }

        BezierCurve curve = generateBezierCurve(args[0]);
        writeBezierCurveCSV(args[1], curve, Double.parseDouble(args[2]));
    }
}

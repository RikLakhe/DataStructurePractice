package global.citytech.duke.quize1;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestDrive {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/duke/q1/datatest4.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String[] points;
            List<Point> pointsArray = new ArrayList<Point>();
            while ((line = br.readLine()) != null) {
                points = line.split(",");
                System.out.println("x==>" + points[0] + "    y==>" + points[1]);
                Point p = new Point(Float.parseFloat(points[0]), Float.parseFloat(points[1]));
                pointsArray.add(p);
            }

            Shape sh = new Shape(pointsArray);
            System.out.println("example1===>" + sh.getParameter());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

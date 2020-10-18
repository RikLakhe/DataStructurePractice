package global.citytech.duke;

import global.citytech.duke.quize1.Point;
import global.citytech.duke.quize1.Shape;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class quize1Test {
    private static final double DELTA = 1e-15;
    Point p = new Point(3.5f, 6.7f);


    @Test
    public void doPointConstructorTesting() {
        String test = p.toString();
        assertEquals("(3.5,6.7)", test);
    }

    @Test
    public void doPointSetXTesting() {
        p.setX(55f);
        String test = p.toString();
        assertEquals("(55.0,6.7)", test);
    }

    @Test
    public void doPointSetYTesting() {
        p.setY(55f);
        String test = p.toString();
        assertEquals("(3.5,55.0)", test);
    }

    @Test
    public void doPointGetXTesting() {
        assertEquals(3.5f, p.getX(), DELTA);
    }

    @Test
    public void doPointGetYTesting() {
        assertEquals(6.7f, p.getY(), DELTA);
    }

    @Test(expected = IOException.class)
    public void doTestDriveExceptionTesting() throws IOException {
        File file = new File("src/main/resources/duke/q1/unreachable.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
    }

    @Test
    public void doTestDriveTesting() throws IOException {
        File file = new File("src/main/resources/duke/q1/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String[] points;
        List<Point> pointsArray = new ArrayList<Point>();
        while ((line = br.readLine()) != null) {
            points = line.split(",");
            Point p = new Point(Float.parseFloat(points[0]), Float.parseFloat(points[1]));
            pointsArray.add(p);
        }
        Shape sh = new Shape(pointsArray);
        Point lastPoint = sh.getLastPoint();

        assertEquals("(-3.0,3.0)", lastPoint.toString());
    }

    @Test
    public void doShapeCalcuationTesting() throws IOException {
        File file = new File("src/main/resources/duke/q1/datatest4.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String[] points;
        List<Point> pointsArray = new ArrayList<Point>();
        while ((line = br.readLine()) != null) {
            points = line.split(",");
            Point p = new Point(Float.parseFloat(points[0]), Float.parseFloat(points[1]));
            pointsArray.add(p);
        }
        Shape sh = new Shape(pointsArray);
        assertEquals(59.4565544128418, sh.getParameter(),DELTA);
        assertEquals(8.485280990600586, sh.getLongestSide(),DELTA);
        assertEquals(5.945655345916748, sh.getAverageLength(),DELTA);
    }
}

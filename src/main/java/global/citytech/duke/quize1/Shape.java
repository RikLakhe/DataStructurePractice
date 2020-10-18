package global.citytech.duke.quize1;

import java.util.List;

public class Shape {
    private final List<Point> points;
    private final float parameter;
    private float averageLength;
    private float longestSide;

    public Shape(List<Point> points) {
        this.points = points;
        this.parameter = calculateParameter();
        this.averageLength = calculateAverageLength();
        this.longestSide = calculateLongestSide();
    }

    public Point getLastPoint() {
        return points.get(points.size() - 1);
    }

    public float getParameter() {
        return parameter;
    }

    public float getAverageLength() {
        return averageLength;
    }

    public float getLongestSide() {
        return longestSide;
    }

    private float calculateLongestSide() {
        float greaterLength = 0;
        Point prevPoint = points.get(points.size() - 1);
        for (Point newPoint : points) {
            float length = (float) Math.sqrt(Math.pow(prevPoint.getX() - newPoint.getX(), 2) + Math.pow(prevPoint.getY() - newPoint.getY(), 2));
            if (length > greaterLength) {
                greaterLength = length;
            }
            prevPoint = newPoint;
        }

        return greaterLength;
    }

    private float calculateAverageLength() {
        return getParameter() / this.points.size();
    }

    private float calculateParameter() {
        float totalParameter = 0;
        Point prevPoint = points.get(points.size() - 1);
        for (Point newPoint : points) {
            float length = (float) Math.sqrt(Math.pow(prevPoint.getX() - newPoint.getX(), 2) + Math.pow(prevPoint.getY() - newPoint.getY(), 2));
            totalParameter += length;
            prevPoint = newPoint;
        }

        return totalParameter;
    }
}

package global.citytech.duke.quize1;

public class Point {
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public Point setX(float x) {
        this.x = x;
        return this;
    }

    public float getY() {
        return y;
    }

    public Point setY(float y) {
        this.y = y;
        return this;
    }

    public Point getPoint() {
        return this;
    }

    @Override
    public String toString() {
        return ("(" + this.getX() + "," + this.getY() + ")");
    }
}

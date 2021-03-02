package ru.quest.lect1;

public class Point {
    public double x, y;
    public Point(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }
    public double distance(Point b) {

        return Math.sqrt((b.x - this.x) * (b.x - this.x) * (b.y - this.y) * (b.y - this.y));
    }
}



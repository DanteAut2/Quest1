package ru.quest.lect1;

public class Point {
    public double x, y;
    public Point(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }
    public static double distance(Point a, Point b) {

        return Math.sqrt((b.x - a.x) * (b.x - a.x) * (b.y - a.y) * (b.y - a.y));
    }
}



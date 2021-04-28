package ru.quest.lect1;

public class questOne {
    public static void main(String[] args) {
        Point a = new Point(3, 6);
        Point b = new Point(2, 4);
        System.out.println("Inputed some text for first question");
        System.out.println("Расстояние между точками равно " + a.distance(b));
    }

}
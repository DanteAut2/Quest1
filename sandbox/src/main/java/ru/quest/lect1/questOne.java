package ru.quest.lect1;

public class questOne {
	public void main(String[] args){
		System.out.println("Inputed some text for first question");
		System.out.println("Расстояние между точками равно " + x.distance());
	}
	public double distance(Point a, Point b) {

		return Math.sqrt((b.x - a.x) * (b.x - a.x) * (b.y - a.y) * (b.y - a.y));
	}
}
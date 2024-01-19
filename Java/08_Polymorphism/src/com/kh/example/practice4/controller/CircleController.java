package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Circle;

public class CircleController {

	private Circle c = new Circle();

	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c.toString() + "넓이 : " + radius * radius * Math.PI;
	}

	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c.toString() + "둘레 : " + radius * 2 * Math.PI;
	}

}

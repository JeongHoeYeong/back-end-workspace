package com.kh.map.model;

public class Snack {
	private String flaver;
	private int calorie;
	
	public Snack() {
	}
	
	public Snack(String flavero, int calorie) {
		this.flaver = flavero;
		this.calorie = calorie;
	}
	
	public String getFlaver() {
		return flaver;
	}
	
	public void setFlavero(String flavero) {
		this.flaver = flavero;
	}
	
	public int getCalorie() {
		return calorie;
	}
	
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	
	@Override
	public String toString() {
		return "Snack [flaver=" + flaver + ", calorie=" + calorie + "]";
	}
	
	
}

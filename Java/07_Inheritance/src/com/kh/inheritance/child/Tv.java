package com.kh.inheritance.child;

import com.kh.inheritance.parent.Product;

public class Tv extends Product{
	
	private int inch; // 인치

	public Tv() {}

	public Tv(String brand, String pCode, String name, int price, int inch) {
		super(brand, pCode, name, price);
		// TODO Auto-generated constructor stub
		this.inch = inch;
	}
	
	public void setinch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return super.toString() + ", Tv [inch=" + inch + "]";
	}
	
	
}

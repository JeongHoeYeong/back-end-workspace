package com.kh.coupang.model;

import java.util.Date;

public class Coupon {
	private int couponcode;
	private String couponName;
	private Date expiry_date;
	
	private Customer customer;
	private Product product;
}

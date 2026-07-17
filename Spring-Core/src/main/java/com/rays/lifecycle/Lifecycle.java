package com.rays.lifecycle;

public class Lifecycle {

	public void start() {
		System.out.println("Bean created...");
	}
	
	public void clear() {
		System.out.println("Bean Destroyed...");
	}
}

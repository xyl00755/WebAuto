package com.stray.studyjava;

public class Testthis001 {

	public void jump() {
		System.out.println("run method: jump");
	}
	
	public void run() {
		Testthis001 test = new Testthis001();
		test.jump();
		System.out.println("run method: run");
	}
	
	public void ruuun() {
		this.jump();
		System.out.println("run method: ruuun");
	}
	
	public void ruuuuun() {
		jump();
		System.out.println("run method: ruuuuun");
	}
	
	public static void main(String[] args) {
		
		Testthis001 test = new Testthis001();
		
		test.run();
		test.ruuun();
		test.ruuuuun();
		
	}
}

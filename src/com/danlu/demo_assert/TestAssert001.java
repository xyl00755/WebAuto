package com.danlu.demo_assert;

public class TestAssert001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Assertiona.verifyEquals(3, 3, "abc");
        Assertiona.verifyEquals(2, 2, "xyz");
        Assertiona.verifyEquals(3, 2, "abc");
        Assertiona.verifyEquals(2, 3, "xyz");

	}

}

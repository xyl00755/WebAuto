package com.danlu.demo_random;

import java.util.Random;

public class RandomNum {

	private static Random randGen = null;
	private static char[] characters = null;

	public static final String randomNum(int length) {
		if (length < 1) {
			return null;
        }
		if (randGen == null) {
             randGen = new Random();
             characters = ("0123456789").toCharArray();
        }
        char [] randBuffer = new char[length];
        for (int i=0; i<randBuffer.length; i++) {
            randBuffer[i] = characters[randGen.nextInt(10)];
        }
        return new String(randBuffer);
	}
	
}

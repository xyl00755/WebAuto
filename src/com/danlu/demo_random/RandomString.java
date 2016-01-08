package com.danlu.demo_random;
import java.util.Random;

public class RandomString {

/**
 * 产生随机字符串
*/
	private static Random randGen = null;
	private static char[] characters = null;

	public static final String randomString(int length) {
		if (length < 1) {
			return null;
        }
		if (randGen == null) {
             randGen = new Random();
             characters = ("0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        }
        char [] randBuffer = new char[length];
        for (int i=0; i<randBuffer.length; i++) {
            randBuffer[i] = characters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
	}
}


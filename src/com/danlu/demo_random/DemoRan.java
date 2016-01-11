package com.danlu.demo_random;

import com.danlu.demo_random.RandomString;
import com.danlu.demo_random.RandomNum;

public class DemoRan {

	//调用此方法randomString(int),int是字符串的长度，即可产生指定长度的随机字符串。
		public static void main (String[] args){
			String c = RandomString.randomString(23);
			String d = RandomString.randomString(3);
			String e = "13" + RandomNum.randomNum(9);
			String f = RandomNum.randomNum(8);
			String g = "028-" + RandomNum.randomNum(8);
			
			System.out.println(c);
			System.out.println(d);
			System.out.println(e);
			System.out.println(f);
			System.out.println(g);
		}
	
}

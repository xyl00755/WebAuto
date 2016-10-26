package util;

import java.util.HashMap;

public class RunExe {

	/**
	 * run windows .exe
	 * 
	 * @param pCommand
	 */
	public static void run(HashMap<String, String> params) {
		Runtime rn = Runtime.getRuntime();
		try {
			rn.exec(params.get("RunExe"));
		} catch (Exception e) {
			System.out.println("Error win exec!");
		}
	}
	
}

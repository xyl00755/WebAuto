package util;

import util.Browser;

public class GoBack {

	public static void run(){
		Browser.Driver.navigate().back();
	}
	
}
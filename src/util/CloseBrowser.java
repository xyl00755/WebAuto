package util;

import util.Browser;

public class CloseBrowser {

	public static void run(){
	    if(Browser.Driver!=null)
	    	Browser.Driver.quit();
	  }
	
}

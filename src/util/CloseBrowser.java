package util;

import util.Browser;

public class CloseBrowser {

	public static void run(Object parmas) {
		if (Browser.Driver != null)
			Browser.Driver.close();
	}

}

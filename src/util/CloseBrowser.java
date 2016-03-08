package util;

import util.Browser;

public class CloseBrowser {

	public static void run(Object parmas) {
        if (Browser.Driver != null)
            try {
                Browser.Driver.close();
                Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
            } catch (Exception anException) {
                anException.printStackTrace();
            }
	}
}

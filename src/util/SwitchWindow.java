package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import util.Browser;

public class SwitchWindow {

	public static void run(HashMap<String, String> params) {
		int iTimeout = 20;
		if (params.get("Browser window name") == "Default Window") {
			Browser.Driver.switchTo().window(Browser.MainWinHandle);
			return;
		}
		while (iTimeout > 0) {
			for (String handle : Browser.Driver.getWindowHandles()) {
				Browser.Driver.switchTo().window(handle);
				if (Browser.Driver.getTitle().equals(params.get("Window Name"))) {
					return;
				}
			}
			iTimeout--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Window:" + params.get("Window Name") + "does not exist.");
		}
	}
    
    public static void newWindow(HashMap<String, String> params) {
		Set<String> s1 = Browser.Driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!Browser.MainWinHandle.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				Browser.Driver.switchTo().window(ChildWindow);
			}
		}
	}

}

package util;

import java.util.HashMap;

public class DeleteCookie {
	
	public static void run(HashMap<String, String> params){
		if(params.get("Cookie Name") == "ALL"){
			System.out.println("Cookies:"+Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteAllCookies();
			System.out.println("Cookies:"+Browser.Driver.manage().getCookies());
		} else {
			System.out.println("Cookies:"+Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteCookieNamed(params.get("Cookie Name"));
			System.out.println("Cookies:"+Browser.Driver.manage().getCookies());			
		}
	}
	
}

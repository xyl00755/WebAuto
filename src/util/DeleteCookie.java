package util;

import java.util.HashMap;

import common.Wait;

public class DeleteCookie {
	
	public static void run(HashMap<String, String> params){
		if(params.get("Cookie Name") == "ALL"){
			System.out.println("Cookie Name == ALL");
			System.out.println("Before Cookies:"+Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteAllCookies();
			Wait.run(params);
			System.out.println("After Cookies:"+Browser.Driver.manage().getCookies());
		} else {
			System.out.println("Cookie Name == "+params.get("Cookie Name"));
			System.out.println("Before Cookies:"+Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteCookieNamed(params.get("Cookie Name"));
			System.out.println("After Cookies:"+Browser.Driver.manage().getCookies());			
		}
	}
	
}

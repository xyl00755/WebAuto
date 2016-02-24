package util;

import java.util.HashMap;

public class DeleteCookie {
	
	public static void run(HashMap<String, String> params){
		if(params.get("Browser Type") == "ALL"){
			Browser.Driver.manage().deleteAllCookies();
		} else {
			Browser.Driver.manage().deleteCookieNamed(params.get("Cookie Name"));
		}
	}
	
}
package util;

import java.util.HashMap;

import common.Wait;

public class DeleteCookie {
	
	public static void run(HashMap<String, String> params){
		if(params.get("Cookie Name") == "ALL"){
			HashMap<String,String> map1 = new HashMap<String,String>();
			map1.put("Seconds", "2");
			
			System.out.println("Cookies:"+Browser.Driver.manage().getCookies());
            Wait.run(params);
            System.out.println(Browser.Driver);
			Browser.Driver.manage().deleteAllCookies();
			Wait.run(params);
			System.out.println("Cookies:"+Browser.Driver.manage().getCookies());
		} else {
			System.out.println("Cookies:"+Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteCookieNamed(params.get("Cookie Name"));
			System.out.println("Cookies:"+Browser.Driver.manage().getCookies());			
		}
	}
	
}

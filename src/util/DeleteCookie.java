package util;

import java.util.HashMap;

import common.Wait;
import util.Browser;

public class DeleteCookie {
	
	public static void run(HashMap<String, String> params){
		if(params.get("Cookie Name") == "ALL"){
            
            HashMap<String,String> map1 = new HashMap<String,String>();
			map1.put("Seconds", "2");
			Wait.run(map1);
            
			System.out.println("Cookie Name == ALL");
			System.out.println("Before Cookies:"+Browser.Driver.manage().getCookies());
            
            System.out.println(Browser.Driver);
            
			Browser.Driver.manage().deleteAllCookies();
			System.out.println("After Cookies:"+Browser.Driver.manage().getCookies());
			

			Wait.run(map1);
			
			System.out.println("After Wait:"+Browser.Driver.manage().getCookies());
			
			
		} else {
			System.out.println("Cookie Name == "+params.get("Cookie Name"));
			System.out.println("Before Cookies:"+Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteCookieNamed(params.get("Cookie Name"));
			System.out.println("After Cookies:"+Browser.Driver.manage().getCookies());			
		}
	}
	
}

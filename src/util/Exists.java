package util;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import common.Elements;

public class Exists {

	public static void run(HashMap<String, String> params){
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		System.out.println(params.get("Number of Matches"));
		String str = params.get("Number of Matches");
		if( null == str || "".equals(str) || "null".equals(str)){
			
			System.out.println("is null");
			System.out.println("elements.size() = " + elements.size());
			assert elements.size() > 0 : "Error element: " + params.get("ID") + " was not found.";

		} else {
			System.out.println("is not null");
			assert elements.size() == Integer.parseInt(params.get("Number of Matches")): "Error element: " + params.get("ID") + " was not found expected number of times: " + str + ".  It was found: " + elements.size() + " times.";
		}
	}
	
}

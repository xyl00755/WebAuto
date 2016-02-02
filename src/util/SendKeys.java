package util;

import common.Elements;
import util.Browser;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

public class SendKeys {

	public static void run(HashMap<String, Object> params){
	    WebElement element = Elements.find(params,Browser.Driver);
	    element.sendKeys((String) params.get("Text"));
	}
}
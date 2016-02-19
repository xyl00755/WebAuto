package util;

import common.Elements;
import util.Browser;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Verifies {
	
	public static void attribute(HashMap<String, String> params){
		WebElement element = Elements.find(params,Browser.Driver);
		Assert.assertEquals(element.getAttribute(params.get("Attribute Name")),params.get("Value"));
	}
	
	public static void pagetitle(HashMap<String, String> params){
		Assert.assertEquals(Browser.Driver.getTitle(),params.get("Title"));
	}
	
	public static void text(HashMap<String, String> params){
		WebElement element = Elements.find(params,Browser.Driver);
		Assert.assertEquals(element.getText(),params.get("Text"));
	}
	
    public static void currenturl(HashMap<String, String> params){
		Assert.assertEquals(Browser.Driver.getCurrentUrl(),params.get("Value"));
	}
   //CheckBox
	public static void checkbox(HashMap<String, String> params){
		WebElement element = Elements.find(params,Browser.Driver);
		Assert.assertEquals(element.isSelected(),params.get("Is Checked").equals("true"));
	}
}

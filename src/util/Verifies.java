package util;

import common.Elements;
import util.Browser;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Verifies {
	// Assert.assertEquals(actual, expected);
	// Attribute
	public static void attribute(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.getAttribute(params.get("Attribute Name")), params.get("Value"));
	}

	// Page Title
	public static void pageTitle(HashMap<String, String> params) {
		Assert.assertEquals(Browser.Driver.getTitle(), params.get("Title"));
	}

	// Text
	public static void text(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.getText(), params.get("Text"));
	}

	// Current URL
	public static void currentUrl(HashMap<String, String> params) {
		Assert.assertEquals(Browser.Driver.getCurrentUrl(), params.get("Value"));
	}

	// CheckBox
	public static void checkbox(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isSelected(), params.get("Is Checked").equals("true"));
	}

	// Exist
	public static void isExisted(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		Assert.assertNotEquals(elements.size(), 0);
		System.out.println("element " + params.get("ID") + " is existed.");
	}

	// Not Exist
	public static void notExisted(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		Assert.assertEquals(elements.size(), 0);
		System.out.println("element " + params.get("ID") + " is not existed.");
	}
    
    // Enabled
	public static void isEnable(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isEnabled(), true);
	}

	// Not Enable
	public static void notEnable(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isEnabled(), false);
	}

	// Visible
	public static void isVisible(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isDisplayed(), true);
	}

	// Not Visible
	public static void notVisible(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isDisplayed(), false);
	}
}

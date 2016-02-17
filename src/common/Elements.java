package common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;


public class Elements {

	public static WebElement find(HashMap<String, String> params, WebDriver Driver) {

		WebElement foundElement = null;

		switch (params.get("ID Type")) {
		case "Class Name":
			foundElement = Driver.findElement(By.className(params.get("ID")));
			break;
		case "Css Selector":
			foundElement = Driver.findElement(By.cssSelector(params.get("ID")));
			break;
		case "ID":
			foundElement = Driver.findElement(By.id(params.get("ID")));
			break;
		case "Link Text":
			foundElement = Driver.findElement(By.linkText(params.get("ID")));
			break;
		case "XPath":
			foundElement = Driver.findElement(By.xpath(params.get("ID")));
			break;
		case "Name":
			foundElement = Driver.findElement(By.name(params.get("ID")));
			break;
		case "Partial Link Text":
			foundElement = Driver.findElement(By.partialLinkText(params.get("ID")));
			break;
		case "Tag Name":
			foundElement = Driver.findElement(By.tagName(params.get("ID")));
			break;
		//Property,default:xpath, get from properties
		case "Property":
            foundElement = Driver.findElement(By.xpath(Elements.getP(params.get("ID"))));
            break;
		default:
			foundElement = Driver.findElement(By.xpath(Elements.getP(params.get("ID"))));
		}

		return foundElement;
	}

	/*
	 * Read properties
	 */
	public static Properties readProperties(String filePath) {

		Properties p = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			p.load(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	/*
	 * read key-value (param-pr)
	 * 
	 */
	public static String getP(String param) {
		String filePath = "./config/elementpath_TRADE.properties";
		Properties p = readProperties(filePath);
		String pr = p.getProperty(param);
		return pr;
	}

}
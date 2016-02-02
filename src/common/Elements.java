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

	public static WebElement find(HashMap<String, Object> params, WebDriver Driver) {

		WebElement foundElement = null;

		switch ((String) params.get("ID Type")) {
		case "Class Name":
			foundElement = Driver.findElement(By.className((String) params.get("ID")));
			break;
		case "Css Selector":
			foundElement = Driver.findElement(By.cssSelector((String) params.get("ID")));
			break;
		case "ID":
			foundElement = Driver.findElement(By.id((String) params.get("ID")));
			break;
		case "Link Text":
			foundElement = Driver.findElement(By.linkText((String) params.get("ID")));
			break;
		//XPath is different
		case "XPath":
			foundElement = Driver.findElement(By.xpath(Elements.getP((String) params.get("ID"))));
			break;
		case "Name":
			foundElement = Driver.findElement(By.name((String) params.get("ID")));
			break;
		case "Partial Link Text":
			foundElement = Driver.findElement(By.partialLinkText((String) params.get("ID")));
			break;
		case "Tag Name":
			foundElement = Driver.findElement(By.tagName((String) params.get("ID")));
			break;
		default:
			foundElement = Driver.findElement(By.xpath((String) params.get("ID")));
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
package util;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static WebDriver Driver = null;
	// public static MainWinHandle = null;

	// start browser
	public static void run(HashMap<String, Object> params) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch ((String) params.get("Browser Type")) {
		case "Firefox":
			Driver = new FirefoxDriver();
			break;
		case "Chrome":
			Driver = new ChromeDriver();
			break;
		default:
			Driver = new InternetExplorerDriver();
		}
		if ((String) params.get("URL") != null) {
			if (((String) params.get("URL")).startsWith("http://")
					|| ((String) params.get("URL")).startsWith("https://")) {
				Driver.get((String) params.get("URL"));
			} else {
				Driver.get("http://" + (String) params.get("URL"));
			}

		}
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
		// MainWinHandle = Driver.getWindowHandle();

	}
}
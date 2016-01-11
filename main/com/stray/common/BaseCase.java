package com.stray.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.danlu.demo_log4j.HelloLog4j;


/**
 * 
 * 封装...
 * 
 * @author: stray
 * @version: 1.0, 2015-8-25
 */
public class BaseCase {
	
	private static Logger logger = Logger.getLogger(HelloLog4j.class);
	
	public static WebDriver dr = init();
	Actions action = new Actions(dr);
	public static WebDriver init() {
		Configuration rc = new Configuration("./config/common.properties");//相对路径
		String a;
		a = rc.getValue("browser");
		WebDriver driver = null;
		if(a.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver","./resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(a.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","./resource/chromedriver.exe");
			driver = new ChromeDriver();
		}
		//启动firefox profile
		else if(a.equalsIgnoreCase("firefox")){
			ProfilesIni allProfiles = new ProfilesIni();  
	    	// "selenium" is the new profile just created  
	    	FirefoxProfile profile = allProfiles.getProfile("selenium");  
	    	driver = new FirefoxDriver(profile); 
//	    	driver = new FirefoxDriver();//启动firefox
		}else {
			driver = new HtmlUnitDriver();
		}
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

		return driver;
	
	}
	
	
//	public static final WebDriver dr = null;
//	public static Actions action = new Actions(dr);
	
	/**
	 * 测试:main()
	 * @param args
	 */
	public static void main(String[] args){
		
		
		
	}
	
}
	
    
package com.danlu.demo_api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class NewSeleniumApi {

	/**
     * 
     * selenium api 二次封装
     * 
     */
	public static WebDriver driver = null;
//	WebElement a = driver.findElement(By.xpath(""));
    //get() 打开url
    public static void openBrowser(String url){
//    	dr.get(url);    	
    }
    
    /**
     * 启动自定义的Firefox，
     * profile
     * @param url
     */
    public final static void openFirefox(String url){
    	ProfilesIni allProfiles = new ProfilesIni();  
    	// "Selenium" is the new profile just created  
    	FirefoxProfile profile = allProfiles.getProfile("selenium");  
    	WebDriver driver = new FirefoxDriver(profile); 
    	driver.get(url);
    }
    
    public static void openChrome(String url){
//    	dr.get(url);
    }
    
    public static void openIE(String url){
//    	dr.get(url);
    }
    
    //click element
    public static void click(String xPath){
//    	dr.findElement(By.xpath(xPath)).click();
    }
    
    /*
    public static void click(String id){
    	dr.findElement(By.id(id)).click();
    }
    */
    
    //
    public static void typeIn(String xPath, String text){
//    	dr.findElement(By.xpath(xPath)).sendKeys(text);
    	
    }
	
    
    //调用二次封装的方法
    public static void main(String[] args){
    	openFirefox("http://www.baidu.com");
//    	click(".//*[@id='u1']/a[6]");
//    	typeIn(".//*[@id='TANGRAM__PSP_8__userName']", "slionlyf");
//    	typeIn(".//*[@id='TANGRAM__PSP_8__password']", "199010131219");
//    	click(".//*[@id='TANGRAM__PSP_8__submit']");
    	
    }
}

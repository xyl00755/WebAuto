package com.danlu.demo_securitycode;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
  
public class Test002 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://123.57.66.231:8090");
     
        
         
        Cookie cookie=new Cookie("JSESSIONID","fd585f1a-c311-430f-b15e-543e89e037d0","/",null);
        driver.manage().addCookie(cookie);
  
        System.out.println(driver.manage().getCookieNamed("JSESSIONID"));
         
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        driver.get("http://123.57.66.231:8090");
        
    }
}
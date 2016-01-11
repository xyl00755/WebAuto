package com.danlu.demo_securitycode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test001 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		//访问xxxx网站
		driver.get("http://123.57.66.231:8090");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='beforeLogin']/div[2]/input[1]")).click();
        driver.findElement(By.xpath(".//*[@id='account']")).sendKeys("testlyf00");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        driver.findElement(By.xpath(".//*[@id='dlk']")).click();
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//将用户名密码写入浏览器cookie
		driver.manage().getCookies();
		System.out.println(driver.manage().getCookies());
		System.out.println(driver.manage().getCookieNamed("loginName"));
//		driver.manage().addCookie(null{'name':'Login_UserNumber', 'value':'username'});
//		driver.manage().addCookie({'name':'Login_Passwd', 'value':'password'});
		//再次访问xxxx网站，将会自动登录
		
//		Cookie cookie=new Cookie("JSESSIONID","fd585f1a-c311-430f-b15e-543e89e037d0","/",null);
//		driver.manage().addCookie(cookie);
		driver.get("http://123.57.66.231:8090");
		
		
	}
	
}

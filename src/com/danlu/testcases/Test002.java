package com.danlu.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test002 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).clear();
	    driver.findElement(By.id("kw")).sendKeys("周杰伦");
	    driver.findElement(By.id("su")).click();
	    driver.findElement(By.linkText("周杰伦_百度百科")).click();
		
	}
	
}

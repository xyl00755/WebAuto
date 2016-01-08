package com.danlu.demo_winhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test001 {
       
	public static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) throws Exception{
		
		driver.get("http://www.baidu.com");
		Thread.sleep(1000);
		driver.findElement(By.id("kw")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.id("kw")).sendKeys("163邮箱");
	    Thread.sleep(1000);
	    driver.findElement(By.id("su")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='1']/h3/a[1]")).click();
		//Store the current window handle
		String winHandleBefore = driver.getWindowHandle();  
        
	    //Switch to new window opened
	    for(String winHandle : driver.getWindowHandles()){     
	    	System.out.println("+++" + winHandle);     
	        driver.switchTo().window(winHandle);     
	    }
	    
	    /*
	    // Close the original window
	    driver.switchTo().window(winHandleBefore);     
	    driver.close();
	    */
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='idInput']")).sendKeys("123456");
	}
    
}

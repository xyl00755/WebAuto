package com.danlu.demo_dp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.danlu.demo_assert.Assertiona;

@Listeners({com.danlu.demo_assert.AssertionListener.class})
public class TestDataProvider001 {

	WebDriver dr;
	
	@DataProvider
	public Object[][] testData(){
	return new Object[][]{
		{"liyafei_01","123456"},
		{"liyafei_01","1234567"},
		{"lixuemei1","123456"},
		{"丹露","123456"},
		
	};
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		dr = new FirefoxDriver();
	}
	
	@Test(dataProvider = "testData")
	public void login(String userName, String password) {
		
		dr.manage().window().maximize();
		dr.get("http://www.danlu.com");
		
		dr.findElement(By.xpath(".//*[@id='account']")).sendKeys(userName);
		dr.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
		dr.findElement(By.xpath(".//*[@id='loginForm']/div[1]/div[2]/ul/li[5]/input")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dr.getCurrentUrl());
		Assertiona.verifyEquals(dr.getCurrentUrl(), "http://www.danlu.com/main/province.html");
	}
	
	@AfterMethod
	public void closeWebDriver() {
    	dr.quit();
    }
	
	
}

package com.danlu.demo_dp;

import org.testng.annotations.Test;
import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.danlu.demo_assert.Assertiona;

@Listeners({com.danlu.demo_assert.AssertionListener.class})
public class TestDataProvider003 extends FeedTest {
        
	public WebDriver driver;
    public String baseUrl = "http://www.danlu.com";
    public String LinkTest;
    public String LinkTestPassWord;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
    	driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "feeder")
    @Source("./test-data/Test.csv")
    public void testTcShortPasswordLg(String userName,String password,boolean flag,String expected) throws Exception {
    	
    	driver.findElement(By.xpath(".//*[@id='account']")).sendKeys(userName);
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
    	driver.findElement(By.xpath(".//*[@id='loginForm']/div[1]/div[2]/ul/li[5]/input")).click();
        if(flag){
        	Thread.sleep(3000);
        	LinkTest =  driver.getCurrentUrl().trim();
            Assertiona.verifyEquals(LinkTest, expected);
            LinkTest = null;
            Thread.sleep(2000);
        }else{
        	Thread.sleep(3000);
        	System.out.println("登录失败后URL:" + driver.getCurrentUrl());
        	LinkTest = driver.findElement(By.xpath(".//*[@id='resultMessage']")).getText().trim();
//        	System.out.println(expected + "expected");
//        	System.out.println(LinkTest + "actual");
            Assertiona.verifyEquals(LinkTest, expected);
            LinkTest = null;
            Thread.sleep(2000);
        }
    }
    @AfterMethod
	public void closeWebDriver() {
    	driver.quit();
    }
}
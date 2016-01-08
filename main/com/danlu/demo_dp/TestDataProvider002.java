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
public class TestDataProvider002 {
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
    
    @DataProvider(name = "testData")
    public Object[][] testNetHomeWrok_data() {
        return new Object[][] {
         	{"liyafei_01","123456","true","http://www.danlu.com/main/province.html"},
        	{"liyafei_01","1234567","false","用户名或密码错误."},
        	{"lixuemei1","123456","true","http://www.danlu.com/main/province.html"},
        	{"丹露","","false","请输入正确的密码!"},
        	{"丹露","123456","false","用户名不存在."},
        	{"1","123456","false","用户名不存在."},
        };
    }


    @Test(dataProvider = "testData")
    public void testTcShortPasswordLg(String userName,String password,String flag,String expected) throws Exception {
    	
        driver.findElement(By.xpath(".//*[@id='account']")).sendKeys(userName);
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
    	driver.findElement(By.xpath(".//*[@id='loginForm']/div[1]/div[2]/ul/li[5]/input")).click();
        if(flag == "true"){
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
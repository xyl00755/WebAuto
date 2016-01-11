package com.danlu.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.danlu.common.BaseTestCase;
import com.danlu.demo_assert.Assertiona;


/**
 * 百度登录
 * 每一步都作判断，执行成功还是失败
 * 每一步都截图
 *  
 */

//@Test
@Listeners({com.danlu.demo_assert.AssertionListener.class})
public class Test001 extends BaseTestCase {
	
//	WebDriver dr = new FirefoxDriver();
	static String baseUrl = "http://www.baidu.com";

	@Test(alwaysRun = true)
	public void getUrl(){
		vlogInfo("Current case: getUrl, Action: Browser navigate to baseUrl");
		dr.get(baseUrl);
	}
	
	@Test(dependsOnMethods = "getUrl")
	public static void getLog(){
		dr.findElement(By.xpath(".//*[@id='u1']/a[6]")).click();
	}
	
	@Test(dependsOnMethods = "getLog")
	public static void waitA(){
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods = "waitA")
	public static void inputUsername(){
		dr.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__userName']")).sendKeys("slionlyf");
		dr.manage().logs();
	}
	
	@Test(dependsOnMethods = "inputUsername")
	public static void inputPassword(){
		dr.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__password']")).sendKeys("199010131219");
	}
	
	@Test(dependsOnMethods = "inputPassword")
	public static void logBtn(){
		dr.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__submit']")).click();
	}
	
	@Test(dependsOnMethods = "logBtn")
	public static void verifyLog(){
		
		Assertiona.verifyEquals(dr.findElement(By.cssSelector(".user-name")).getText(), "Slionlyf____");
	}
	
	
	/*
	@Test
	public static void test001(){
		dr.get(baseUrl);
		dr.findElement(By.xpath(".//*[@id='u1']/a[6]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__userName']")).sendKeys("slionlyf");
		dr.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__password']")).sendKeys("199010131219");
		dr.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__submit']")).click();
		
	}
	*/
}

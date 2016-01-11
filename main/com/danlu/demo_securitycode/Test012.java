package com.danlu.demo_securitycode;

import java.util.concurrent.TimeUnit;

import org.databene.benerator.anno.Source;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.danlu.demo_assert.Assertiona;
import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;

@Listeners({com.danlu.demo_assert.AssertionListener.class})
public class Test012 extends FeedTest {

	public static WebDriver dr = new FirefoxDriver();
	public static void count() {
		
		dr.manage().window().maximize();
		int i = 0;
		
		for( ; i<10; i++){
			String a = "000";
			System.out.println(a + i);
			login(a + i);
		}
		
		for( ; i<100; i++){
			String a = "00";
			System.out.println(a + i);
			login(a + i);
		}
		
		for( ; i<1000; i++){
			String a = "0";
			System.out.println(a + i);
			login(a + i);
		}
		
		for( ; i<10000; i++){
			String a = "";
			System.out.println(a + i);
			login(a + i);
		}
		
	}
	
	@Test(dataProvider = "feeder")
    @Source("./test-data/sCode.csv")
	public static void login(String SecurityCode) {
		
		dr.manage().window().maximize();
		dr.get("http://123.57.66.231:8090");
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        dr.findElement(By.xpath(".//*[@id='beforeLogin']/div[2]/input[1]")).click();
        dr.findElement(By.xpath(".//*[@id='account']")).sendKeys("testlyf00");
        dr.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
        dr.findElement(By.xpath(".//*[@id='validateCode']")).sendKeys(SecurityCode);
        
        dr.findElement(By.xpath(".//*[@id='dlk']")).click();
        
        try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Security Code is: " + SecurityCode);
        String currentUrl = dr.getCurrentUrl();
        String expectedUrl = "http://123.57.66.231:8090/main/province.html";
        Assertiona.verifyEquals(currentUrl, expectedUrl);
        
	}
	
	public static void main(String[] args) {
		
		int i = 0;
		while(i < 10){
			System.out.println("000" + i);
			i++;
		}while(i < 100){
			System.out.println("00" + i);
			i++;
		}while(i < 1000){
			System.out.println("0" + i);
			i++;
		}while(i < 10000){
			System.out.println("" + i);
			i++;
		}
		System.out.println(i);
		
	}
}

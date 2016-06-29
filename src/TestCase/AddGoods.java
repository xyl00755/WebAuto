package TestCase;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

class AddGoods{
    static String url = "http://123.57.152.182:9002/login?service=http://123.57.244.205/common/caslogin.html";
	static String username = "testyuxi";
	static String password = "123456";
    
    @Test
	public static void addgoods() {

        System.setProperty("webdriver.chrome.driver", "\\\\testmech\\WebAuto\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
		dr.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
		dr.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		dr.findElement(By.xpath("//*[@id='validateCode']")).sendKeys("1111");
		dr.findElement(By.xpath("//*[@id='submitLogin']")).click();
        
         for(int i=0 ;i<2 ;i++){
            dr.get("http://123.57.244.205/common/goods/gotoGoods.html");

		dr.findElement(By.xpath(".//*[@id='addGoodsBtn']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.findElement(By.xpath(".//*[@id='firstTbody']/tr[2]/td[1]/input")).click();
		dr.findElement(By.xpath(".//*[@id='mainRight']/div/div/div[3]/a")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dr.findElement(By.xpath(".//*[@id='n_cod_pay']")).click();    
		dr.findElement(By.xpath(".//*[@id='toPayOrder']")).click();   
        }
        dr.quit();
    }
}
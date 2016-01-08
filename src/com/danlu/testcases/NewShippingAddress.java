package com.danlu.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import com.danlu.common.BaseTestCase;
import com.danlu.demo_random.RandomNum;
import com.danlu.demo_random.RandomString;

import com.danlu.demo_assert.Assertiona;

@Listeners({com.danlu.demo_assert.AssertionListener.class})
public class NewShippingAddress extends BaseTestCase {
	
//	public static WebDriver dr = new FirefoxDriver();
	
//	public static WebDriver dr = BaseTestCase.dr;
	public static Actions action = new Actions(dr);
	
//	@BeforeTest(alwaysRun = true)
	public static void initial(){
//		dr.manage().window().maximize();
		dr.get("http://www.danlu.com");
		
		dr.findElement(By.xpath(".//*[@id='account']")).sendKeys("liyafei_01");
		dr.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
		dr.findElement(By.xpath(".//*[@id='loginForm']/div[1]/div[2]/ul/li[5]/input")).click();
		
		dr.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/div[4]")).click();
		dr.findElement(By.xpath(".//*[@id='menu_list_id_1_3']")).click();
		dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/p")).click();
	}
	

//	public static void clickSaveBtn(){
//		dr.findElement(By.xpath(".//*[@id='deliveryAddressInsert']")).click();
//	}
	

	public static void inputBlank(){
		clear();
		dr.findElement(By.xpath(".//*[@id='deliveryAddressInsert']")).click();
	}
	
	public static void inputInvalid(){
		clear();
		dr.findElement(By.xpath(".//*[@id='deliveryPerson']")).sendKeys(RandomString.randomString(11));
		dr.findElement(By.xpath(".//*[@id='addressDetails']")).sendKeys(RandomString.randomString(80));
		dr.findElement(By.xpath(".//*[@id='deliveryMobole']")).sendKeys(RandomString.randomString(10));
		dr.findElement(By.xpath(".//*[@id='zipcode']")).sendKeys(RandomString.randomString(7));
		dr.findElement(By.xpath(".//*[@id='deliveryAddressInsert']")).click();
		
	}
	

	public static void inputValid(){
		clear();
		dr.findElement(By.xpath(".//*[@id='deliveryPerson']")).sendKeys(RandomString.randomString(3));
		dr.findElement(By.xpath(".//*[@id='addressDetails']")).sendKeys(RandomString.randomString(20));
		dr.findElement(By.xpath(".//*[@id='deliveryMobole']")).sendKeys("13" + RandomNum.randomNum(9));
		dr.findElement(By.xpath(".//*[@id='zipcode']")).sendKeys(RandomNum.randomNum(6));
		dr.findElement(By.xpath(".//*[@id='deliveryTel']")).sendKeys("028-" + RandomNum.randomNum(8));
		dr.findElement(By.xpath(".//*[@id='deliveryAddressInsert']")).click();
	}
	
	
	public static void clear(){
		dr.findElement(By.xpath(".//*[@id='deliveryPerson']")).clear();
		dr.findElement(By.xpath(".//*[@id='addressDetails']")).clear();
		dr.findElement(By.xpath(".//*[@id='deliveryMobole']")).clear();
		dr.findElement(By.xpath(".//*[@id='zipcode']")).clear();
	}
	
//	@Test(groups = {"Blank"} )
	public static void verifyBlank(){
//		inputBlank();
		
		WebElement a = dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[1]/label"));
		action.moveToElement(a).perform();
		WebElement b = dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[1]/div[@class='validate_bg']"));
		Assertiona.verifyEquals(b.getText(), "请输入收货人");
				
		WebElement c = dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[3]/label"));
		action.moveToElement(c).perform();
		Assertiona.verifyEquals(dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[3]/div[@class='validate_bg']")).getText(),"请输入街道地址");
				
		WebElement d = dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[4]/label"));
		action.moveToElement(d).perform();
		Assertiona.verifyEquals(dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[4]/div[@class='validate_bg']")).getText(),"请输入联系手机");
		
	}
	
//	@Test(groups = {"Invalid"})
	public static void verifyInvalid(){
//		inputInvalid();
		
		WebElement d = dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[4]/label"));
		action.moveToElement(d).perform();
		Assertiona.verifyEquals(dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[4]/div[@class='validate_bg']")).getText(), "请正确填写您的手机号码。");
				
		WebElement e = dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[5]/label"));
		action.moveToElement(e).perform();
		Assertiona.verifyEquals(dr.findElement(By.xpath(".//*[@id='deliveryAddressForm']/div/div[5]/div[@class='validate_bg']")).getText(), "请正确填写您的邮政编码。");
			
	}
	
//	@Test(groups = {"Valid"})
	public static void verifyValid(){
//		inputValid();
		
		dr.findElement(By.xpath(".//*[@id='ds_dialog_1']/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button")).click();
		Assertiona.verifyEquals(dr.getCurrentUrl(),"http://www.danlu.com/deliveryAddress/deliveryAddressInit.html");
	}
	

}

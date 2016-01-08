package com.stray.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class BaseStep extends BaseCase {

	public static void main(String[] args) {
		openBrowser("http://www.baidu.com");
		System.out.println(dr.getCurrentUrl());
		System.out.println(dr.getWindowHandle());
	}
	
	//get() 打开url
    public static void openBrowser(String url){
    	dr.get(url);
    }
	
	public static void closeWebDriver() {
    	dr.quit();
    }
    
        
    /**
     * take screenshot
     */
    public void screenShot() {
    	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss.SSS");//年月日时分秒毫秒
		String time = format.format(date);
    	Snapshot((TakesScreenshot)dr,time + ".png");
    }
    /**
     * take screenshot
     * @param drivername
     * @param filename
     */
    public static void Snapshot(TakesScreenshot drivername, String filename) {
		//this method will take screen shot ,require two parameters ,one is driver name, another is file name
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		
		String currentPath = "./output-report/Selenium_Screenshots/" + time; //定义截图保存路径
//		System.out.println(currentPath);
		
		//调用截图方法，创建截图文件。
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			//复制到指定目录,失败打印错误信息。	   	 
			System.out.println("save snapshot path is:"+currentPath+"/"+filename);
			FileUtils.copyFile(scrFile, new File(currentPath+"\\"+filename));
		} catch (IOException e) {
        //TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} 
		finally{	        
//			System.out.println("screen shot finished");
		}
	}
    
    
    
    /**
     * 
     * selenium api 二次封装
     * 
     */
    
    
    
    //click element
    public static void clickOn(String xPath){
    	dr.findElement(By.xpath(xPath)).click();
    }
    
    //
    public static void typeIn(String xPath, String text){
    	dr.findElement(By.xpath(xPath)).sendKeys(text);
    	WebElement a = dr.findElement(By.xpath(""));
    }

}

package com.danlu.demo_js;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestJs001 {

	public static WebDriver driver = new FirefoxDriver();
	public static void main(String[] args) {
		
		String baseUrl = "http://www.baidu.com";
		String a = "alert('欢迎!')";
		
		driver.get(baseUrl);
		excujs(a);
				
	}

	public static void excujs(String js){ 
		
//		创建一个javascriptExcutor 对象 执行executeScript（js）
		((JavascriptExecutor)driver).executeScript(js);
//		利用js代码取出关键字
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

}

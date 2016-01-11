package com.danlu.demo_js;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import com.danlu.common.BaseTestCase;

/**
 * WebDriver 执行 JavaScript
 * @author stray
 * @version 1.0
 *
 */
public class ExecuteJs extends BaseTestCase {

	public static void executeJs(String js){ 
			
//		创建一个javascriptExcutor 对象 执行executeScript（js）
		((JavascriptExecutor)dr).executeScript(js);
//		利用js代码取出关键字
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

}

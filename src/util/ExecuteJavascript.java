package util;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

import util.Browser;

public class ExecuteJavascript {

	public static void run(HashMap<String, String> params){
		System.out.println(params.get("Code"));
		JavascriptExecutor js = (JavascriptExecutor) Browser.Driver;
		System.out.println(js.toString());
		js.executeScript(params.get("Code"));
	}
	
}

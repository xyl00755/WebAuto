package com.danlu.demo_js;

import org.testng.annotations.Test;

import com.danlu.common.BaseTestCase;
public class Demo2 extends BaseTestCase {

	@Test
	public static void testJs() {
	
		dr.get("http://www.baidu.com");
		ExecuteJs.executeJs("alert('WebDriver执行JavaScript成功！')");
		
		
	}
	
}

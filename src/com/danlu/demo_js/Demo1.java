package com.danlu.demo_js;

import com.danlu.common.BaseTestCase;
public class Demo1 extends BaseTestCase {

	public static void main(String[] args) {
	
		dr.get("http://www.baidu.com");
		ExecuteJs.executeJs("alert('欢迎!')");
		
	}
	
}
